package com.tcs.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemovePreoccuredCharactersAdvanced{
	public static void main(String s[]){
		System.out.println("Hello How are you -" + removePreoccuredCharacters("Hello How are you"));
		System.out.println("I am a good boy -" + removePreoccuredCharacters("I am a good boy"));
		System.out.println("Sun rises in the east -" + removePreoccuredCharacters("Sun rises in the east"));
		System.out.println("Good is good so long as it is good -" + removePreoccuredCharacters("Good is good so long as it is good"));
		System.out.println("Indians love cricket -" + removePreoccuredCharacters("Indians love cricket"));
		System.out.println("Learn Java with Merit Campus -" + removePreoccuredCharacters("Learn Java with Merit Campus"));
	}

	public static String removePreoccuredCharacters(String sentence) {
		String[] arrayOfInput=sentence.split(" ");
		List<String> arrayOfOutput=new ArrayList<>();
		Set<Character> charSet=new HashSet<>();

		for(String input:arrayOfInput) {
			char[] charArray=input.toCharArray();
			List<Character> charList=new ArrayList<>();

			for(char inputChar:charArray) {
				boolean exits=charSet.contains(inputChar);
				if(!exits) {
					charList.add(inputChar);
				}
				charSet.add(Character.toUpperCase(inputChar));
				charSet.add(Character.toLowerCase(inputChar));
			}

			StringBuilder builder = new StringBuilder(charList.size());
			for(Character ch: charList){
				builder.append(ch);
			}
			String outputString=builder.toString();

			if(outputString.length()>0) {
				arrayOfOutput.add(outputString);
			}
		}

		return String.join(" ", arrayOfOutput); 
	} 
} 
