package romannumerals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;


public class RomanNumeralSpecificationTests {
	
	RomanNumeralConvertor convertor;
	
	@Before
	public void setUp(){
		convertor = new RomanNumeralConvertor();
	}
	
	
	@Test
	public void shouldDetermineIIAsAdditive() throws ParseException{
		assertFalse(convertor.shouldBeSubtracted("II", 0, 1));
		
	}
	
	@Test
	public void shouldDetermineVIIAsAdditive() throws ParseException{
		assertFalse(convertor.shouldBeSubtracted("VII", 0, 5));
		
	}
	
	@Test
	public void shouldDetermineIVAsSubtractive() throws ParseException{
		assertTrue(convertor.shouldBeSubtracted("IV", 0, 1));
	}

	@Test(expected=ParseException.class)
	public void shouldDetermineIIZAsInvalid() throws ParseException{
		convertor.shouldBeSubtracted("IZ", 0, 1);
	}
}
