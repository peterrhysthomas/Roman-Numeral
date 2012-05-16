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

	public int convert(String romanNumeral) throws ParseException {
		int convertedValue = 0;
		
		for (int index=0; index<romanNumeral.length(); index++){
			Integer convertedDigit = convertNumeralAtIndex(romanNumeral, index);
			boolean shouldBeAdded = determineIfDigitAtIndexShouldBeAdded(romanNumeral, index, convertedDigit);
			if (shouldBeAdded){
				convertedValue += convertedDigit;
			} else {
				convertedValue -= convertedDigit;
			}
		}
		
		return convertedValue;
	}

	private Integer convertNumeralAtIndex(String value, int index) throws ParseException {
		Integer convertedDigit = convertorMap.get(value.charAt(index));
		if (convertedDigit == null){
			throw new ParseException("Not a valid roman numeral " + value, 0);
		}
		return convertedDigit;
	}

	private boolean determineIfDigitAtIndexShouldBeAdded(String value, int index, Integer convertedDigit) throws ParseException {
		boolean shouldBeAdded = true;
		if (isNotLastNumeral(value, index)){
			if (shouldBeSubtracted(value, index, convertedDigit)){
				shouldBeAdded = false;
			}
		}
		return shouldBeAdded;
	}

	private boolean isNotLastNumeral(String value, int index) {
		return index+1<value.length();
	}

	protected boolean shouldBeSubtracted(String value, Integer index,Integer convertedDigit) throws ParseException {
		if (index+1<value.length()){
			Integer nextConvertedDigit = convertNumeralAtIndex(value, index+1);

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
