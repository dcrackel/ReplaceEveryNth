package katatests;

import kata.ReplaceEveryNth;
import kata.ReplaceEveryNthFunctional;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReplaceEveryNthTestsFunctional {
    ReplaceEveryNthFunctional subject = null;

    @Before
    public void setUp() {
    }

    @Test
    public void replaceEveryNth() {
            /* replaceNth(text, n, oldValue, newValue);
            n:         2
            oldValue: 'a'
            newValue: 'o'
            "Vader said: No, I am your father!" -> "Vader soid: No, I am your fother!"
            1     2          3        4       -> 2nd and 4th occurence are replaced

     */
        String input1 = "Vader said: No, I am your father!";
        String result = subject.replaceNth(input1, 2, 'a', 'o');

        assertEquals(result, "Vader soid: No, I am your fother!");
    }


}