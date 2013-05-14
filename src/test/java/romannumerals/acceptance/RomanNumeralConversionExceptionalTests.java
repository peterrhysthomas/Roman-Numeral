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

public class RomanNumeralConversionExceptionalTests {

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
}