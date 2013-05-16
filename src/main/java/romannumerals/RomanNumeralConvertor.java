package romannumerals;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanNumeralConvertor {
	
	private Map<Character, Integer> convertorMap;
    private Set<Character> nonSubtractingNumerals;
	
	public RomanNumeralConvertor(){
		convertorMap = new HashMap<Character, Integer>();
		convertorMap.put('I', 1);
		convertorMap.put('V', 5);
		convertorMap.put('X', 10);
		convertorMap.put('L', 50);
		convertorMap.put('C', 100);
		convertorMap.put('D', 500);
		convertorMap.put('M', 1000);

        nonSubtractingNumerals = new HashSet<Character>();
        nonSubtractingNumerals.add('V');
        nonSubtractingNumerals.add('L');
        nonSubtractingNumerals.add('D');
	}

	public int convert(String romanNumeral) throws ParseException {
		int convertedValue = 0;
        checkIfValid(romanNumeral);
		
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

    private void checkIfValid(String romanNumeral) throws ParseException {
        if (romanNumeral.contains("IIII") || romanNumeral.contains("XXXX") || romanNumeral.contains("CCCC") || romanNumeral.contains("MMMM")){
            throw new ParseException("Invalid format " + romanNumeral, 0);
        }
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
		if (isNotLastNumeral(value, index)){
			Integer nextConvertedDigit = convertNumeralAtIndex(value, index+1);

			if (convertedDigit < nextConvertedDigit){
                checkCanBeSubtracted(value, convertedDigit, nextConvertedDigit);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

    private void checkCanBeSubtracted(String value, Integer convertedDigit, Integer nextConvertedDigit) throws ParseException {
        if (((nextConvertedDigit - convertedDigit) / convertedDigit) > 9.0 ) {
            throw new ParseException("Not a valid roman numeral " + value, 0);
        }

        if (nonSubtractingNumerals.contains(numeralValueOf(convertedDigit))){
            throw new ParseException("Not a valid roman numeral " + value, 0);
        }

    }

    private Character numeralValueOf(Integer convertedDigit) {
        for (Character key : convertorMap.keySet()){
            if (convertorMap.get(key).equals(convertedDigit)){
                return key;
            }
        }
        return null;
    }

}
