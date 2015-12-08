package com.processing.semantics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 13/03/14.
 */
@RunWith(JUnit4.class)
public class NumericParserTest {

    private NumericParser numericParser;

    @Before
    public void setup() {
        numericParser = new NumericParser();
    }

    @Test
    public void canUnderstand() {
        Assert.assertTrue(numericParser.canUnderstand("3"));
        Assert.assertTrue(numericParser.canUnderstand(new String[]{"3", "4"}));
        Assert.assertTrue(numericParser.canUnderstand("3 9"));
        Assert.assertFalse(numericParser.canUnderstand("a"));
        Assert.assertFalse(numericParser.canUnderstand("4 b"));
        Assert.assertFalse(numericParser.canUnderstand(new String[]{"3", "b"}));
        Assert.assertFalse(numericParser.canUnderstand("3a"));
    }

    @Test
    public void parseArrayOfNumbers() {
        verifyInput(new String[]{"1", "9.8596"});
        verifyInput("1 9.8596");
    }

    private void verifyInput(Object input) {
        List<BigDecimal> numbers = numericParser.parseNumbers(input);
        Assert.assertNotNull(numbers);
        Assert.assertEquals("wrong size", 2, numbers.size());
        BigDecimal num = numbers.get(0);
        Assert.assertEquals(1, num.intValue());
        num = numbers.get(1);
        Assert.assertEquals(9.8596d, num.doubleValue(), 0.00001d);
    }

}
