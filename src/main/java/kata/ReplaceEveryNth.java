package kata;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReplaceEveryNth {

    /* replaceNth(text, n, oldValue, newValue);
    n:         2
    oldValue: 'a'
    newValue: 'o'
            "Vader said: No, I am your father!" -> "Vader soid: No, I am your fother!"
            1     2          3        4       -> 2nd and 4th occurence are replaced

     */

    public static String replaceNth(String text, Integer n, Character oldValue, Character newValue){
        char[] chars = text.toCharArray();
        char[] ret = new char[chars.length];
        int counter = 1;

        for (int i = 0; i < chars.length; ++i)
        {
            ret[i] = chars[i];
            if (chars[i] == oldValue) {
                if (counter % n == 0) {
                    ret[i] = newValue;
                    counter = 0;
                }
                counter++;
            }
        }
        return new String(ret);
    }

}
