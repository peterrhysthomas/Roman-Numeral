package romannumerals;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConvertor {
	
	private Map<Character, Integer> convertorMap;
	
	public RomanNumeralConvertor(){
		convertorMap = new HashMap<Character, Integer>();
		convertorMap.put('I', 1);
		convertorMap.put('V', 5);
		convertorMap.put('X', 10);
		convertorMap.put('L', 50);
		convertorMap.put('C', 100);
		convertorMap.put('D', 500);
		convertorMap.put('M', 1000);
	}

	public int convert(String value) throws ParseException {
		int convertedValue = 0;
		
		for (int i=0; i<value.length(); i++){
			Integer convertedDigit = convertNumeral(value, i);
			boolean shouldBeAdded = calculateShouldBeAdded(value, i, convertedDigit);
			if (shouldBeAdded){
				convertedValue += convertedDigit;
			} else {
				convertedValue -= convertedDigit;
			}
		}
		
		return convertedValue;
	}

	private Integer convertNumeral(String value, int i) throws ParseException {
		Integer convertedDigit = convertorMap.get(value.charAt(i));
		if (convertedDigit == null){
			throw new ParseException("Not a valid roman numeral " + value, 0);
		}
		return convertedDigit;
	}

	private boolean calculateShouldBeAdded(String value, int i, Integer convertedDigit) throws ParseException {
		boolean shouldBeAdded = true;
		if (i+1<value.length()){
			if (shouldBeSubtracted(value, i, convertedDigit)){
				shouldBeAdded = false;
			}
		}
		return shouldBeAdded;
	}

	protected boolean shouldBeSubtracted(String value, Integer index,Integer convertedDigit) throws ParseException {
		if (index+1<value.length()){
			Integer nextConvertedDigit = convertNumeral(value, index+1);

			if (convertedDigit < nextConvertedDigit){
				return true;
			} if (convertedDigit.equals(nextConvertedDigit)){
				return shouldBeSubtracted(value, index+1, nextConvertedDigit);
			} else {
				return false;
			}
		}
		return false;
	}

}
