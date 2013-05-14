package romannumerals.acceptance;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import romannumerals.RomanNumeralConvertor;

@RunWith(value = Parameterized.class)
public class RomanNumeralConversionTest {

    private final String romanNumeral;
    private final int expectedValue;
    private RomanNumeralConvertor convertor;

    @Parameterized.Parameters(name= "Should convert {0} to {1}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "I", 1 },
                                           { "V", 5 },
                                           { "X", 10 },
                                           { "L", 50 },
                                           { "C", 100 },
                                           { "D", 500 },
                                           { "M", 1000 },
                                           { "VI", 6 },
                                           { "VII", 7 },
                                           { "IV", 4 },
                                           { "MMVI", 2006 },
                                           { "MCMXLIV", 1944 },
                                           { "MCMXCIV", 1994 },
                                           };
        return Arrays.asList(data);
    }

    public RomanNumeralConversionTest(String romanNumeral, int expectedValue){
        this.romanNumeral = romanNumeral;
        this.expectedValue = expectedValue;
    }
	
	@Before
	public void setUp(){
		convertor = new RomanNumeralConvertor();
	}

	@Test
	public void shouldConvertNumeralToValue() throws ParseException{
		assertEquals(convertor.convert(romanNumeral), expectedValue);
	}
}