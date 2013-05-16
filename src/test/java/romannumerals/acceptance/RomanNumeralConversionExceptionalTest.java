package romannumerals.acceptance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import romannumerals.RomanNumeralConvertor;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConversionExceptionalTest {

    private RomanNumeralConvertor convertor;

	@Before
	public void setUp(){
		convertor = new RomanNumeralConvertor();
	}

	@Test(expected=ParseException.class)
	public void shouldThrowExceptionForSingleInvalidNumeral() throws ParseException{
		convertor.convert("A");
	}
	
	@Test(expected=ParseException.class)
	public void shouldThrowExceptionForInvalidNumeralContainedInStringOfValidNumerals() throws ParseException{
		convertor.convert("MCMA");
	}

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForIIII() throws ParseException{
        convertor.convert("IIII");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForXXXX() throws ParseException {
        convertor.convert("XXXX");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForCCCC() throws ParseException {
        convertor.convert("CCCC");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForMMMM() throws ParseException {
        convertor.convert("MMMM");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForIL() throws ParseException {
        convertor.convert("IL");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForIC() throws ParseException {
        convertor.convert("IC");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForVC() throws ParseException {
        convertor.convert("VC");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForVX() throws ParseException {
        convertor.convert("VX");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForLC() throws ParseException {
        convertor.convert("LC");
    }

    @Test(expected=ParseException.class)
    public void shouldThrowExceptionForDM() throws ParseException {
        convertor.convert("DM");
    }

}