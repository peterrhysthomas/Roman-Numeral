package romannumerals;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import romannumerals.RomanNumeralConvertor;

import java.text.ParseException;

@RunWith(ConcordionRunner.class)
public class RomanNumeralsDescriptionFixture {

    private RomanNumeralConvertor convertor;

    @Before
    public void setUp(){
        convertor = new RomanNumeralConvertor();
    }

    public int convert(String numeral) throws ParseException {
        return convertor.convert(numeral);
    }

}
