package katatests;

import kata.ReplaceEveryNth;
import kata.ReplaceEveryNthFunctional;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReplaceEveryNthTestsFunctional {
    ReplaceEveryNthFunctional subject = null;
    List<String> defaultNthSeq = null;

    @Before
    public void setUp() {
        defaultNthSeq = new ArrayList<String>();
        defaultNthSeq.add("a");
        defaultNthSeq.add("o");
        defaultNthSeq.add("a");
        defaultNthSeq.add("o");
        defaultNthSeq.add("a");
    }

    @Test
    public void splitByActuallySplits(){
        String input1 = "Vader said: No, I am your father!";
        List<String> result =  subject.splitBy(input1, 'a');
        assertEquals(result.size(), 5);
        assertEquals(result.get(1), "der s");
    }

    @Test
    public void generateEveryNthSequenceCanGenerateCorrectly(){
        List<String> separators = subject.generateEveryNthSequence(2, "o", "a", 5);
        assertEquals(separators.size(), 5);
        assertEquals(separators, defaultNthSeq);
    }

    @Test
    public void replaceEveryNth() {
        String input1 = "Vader said: No, I am your father!";
        String result = subject.replaceNth(input1, 2, 'a', 'o');
        assertEquals(result, "Vader soid: No, I am your fother!");
    }

    @Test
    public void replaceEveryNthReduced() {
        String input1 = "Vader said: No, I am your father!";
        String result = subject.replaceNthReduced(input1, 2, 'a', 'o');
        assertEquals(result, "Vader soid: No, I am your fother!");
    }


}