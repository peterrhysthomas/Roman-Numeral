package romannumerals;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RomanNumeralAcceptanceTests {
	
	private RomanNumeralConvertor convertor;
	
	@Before
	public void setUp(){
		convertor = new RomanNumeralConvertor();
	}

	@Test
	public void shouldReturn1forI() throws ParseException{
		assertEquals(convertor.convert("I"), 1);
	}
	
	@Test
	public void shouldReturn5forV() throws ParseException{
		assertEquals(convertor.convert("V"), 5);
	}
	
	@Test
	public void shouldReturn10forX() throws ParseException{
		assertEquals(convertor.convert("X"), 10);
	}

	@Test
	public void shouldReturn50forL() throws ParseException{
		assertEquals(convertor.convert("L"), 50);
	}

	@Test
	public void shouldReturn100forC() throws ParseException{
		assertEquals(convertor.convert("C"), 100);
	}
	
	@Test
	public void shouldReturn500forD() throws ParseException{
		assertEquals(convertor.convert("D"), 500);
	}
	
	@Test
	public void shouldReturn1000forM() throws ParseException{
		assertEquals(convertor.convert("M"), 1000);
	}
	
	@Test(expected=ParseException.class)
	public void shouldThrowExceptionForSingleInvalidNumeral() throws ParseException{
		convertor.convert("A");
	}
	
	@Test(expected=ParseException.class)
	public void shouldThrowExceptionForInvalidNumeralContainedInStringOfValidNumerals() throws ParseException{
		convertor.convert("MCMA");
	}
	
	@Test
	public void shouldCombineSingleNumbersAdditively() throws ParseException{
		assertEquals(convertor.convert("VI"), 6);
	}
	
	@Test
	public void shouldCombineMultipleNumbersAdditively() throws ParseException{
		assertEquals(convertor.convert("VII"), 7);
	}

	@Test
	public void shouldCombineSingleNumbersSubtractively() throws ParseException{
		assertEquals(convertor.convert("IV"), 4);
	}

	@Test
	public void shouldCombineMultipleNumbersSubtractively() throws ParseException{
		assertEquals(convertor.convert("IIV"), 3);
	}
	
	@Test
	public void shouldReturn2006ForMMVI() throws ParseException{
		assertEquals(convertor.convert("MMVI"), 2006);
	}

	@Test
	public void shouldReturn1944ForMCMXLIV() throws ParseException{
		assertEquals(convertor.convert("MCMXLIV"), 1944);
	}


}
