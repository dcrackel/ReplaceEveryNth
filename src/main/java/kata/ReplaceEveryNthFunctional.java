package kata;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReplaceEveryNthFunctional {

    // Splits a string by the given character into a list of sub-strings
    public static List<String> splitBy(String text, Character splitValue) {
        return Arrays.stream(text.split(Pattern.quote(splitValue.toString()), -1)).toList();
    }

    // Generates an infinite sequence where every Nth item is one value
    // and all other values are another
    // generateEveryNthSequence(3, 'A', 'B') =? ['B', 'B', 'A', 'B', 'B', 'A', ...]
    public static <T> List<T> generateEveryNthSequence(int n, T everyNthValue, T everyOtherValue, int size) {
        return Stream.iterate(1, i -> i + 1)
                .limit(size)
                .map(i -> i % n == 0 ? everyNthValue : everyOtherValue)
                .collect(Collectors.toList());
    }

    // Combines two sequences by alternating the values
    // ['A','B','C'] and ['1','2','3'] => ['A', '1', 'B, '2', 'C', '3']
    public static <T> Stream<T> alternateValues(Stream<T> stream1, List<String>  stream2) {
        Iterator<T> iterator1 = stream1.iterator();
        Iterator<T> iterator2 = (Iterator<T>) stream2.stream().iterator();
        return Stream.iterate(iterator1, t -> t == iterator1 ? iterator2 : iterator1)
                .takeWhile(t -> t.hasNext())
                .map(t -> t.next());
    }

    public static String replaceNth(String text, Integer n, Character oldValue, Character newValue){
        // "V", "der s", "id: No, I ", "m your f", "ther!"
        List<String> segments = splitBy(text, oldValue);
        // "a", "o", "a", "o", ...
        List<String> separators = generateEveryNthSequence(n, newValue.toString(), oldValue.toString(), segments.size());

        // "V", "a", "der s", "o", "id: No, I ", "a", "m your f", "o", "ther!", "a"
        Stream<String> alternatingItems = alternateValues(segments.stream(), separators);
        // "V", "a", "der s", "o", "id: No, I ", "a", "m your f", "o", "ther!"
        Stream<String> alternatingItemsTrimmed = alternatingItems.limit(segments.size() * 2 - 1);
        // "Vader soid: No, I am your fother!"
        return alternatingItemsTrimmed.collect(Collectors.joining());
    }


    public static String replaceNthReduced(String text, Integer n, Character oldValue, Character newValue){
        List<String> segments = splitBy(text, oldValue);
        List<String> separators = generateEveryNthSequence(n, newValue.toString(), oldValue.toString(), segments.size());
        return alternateValues(segments.stream(), separators)
                .limit(segments.size() * 2 - 1)
                .collect(Collectors.joining());
    }

}
