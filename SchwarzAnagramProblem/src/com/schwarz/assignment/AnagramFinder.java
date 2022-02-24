package com.schwarz.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramFinder {

	private String fileName = "src/resources/anagramInputFile.txt";
	private HashMap<HashMap<Character, Integer>, ArrayList<String>> anagramListMap = new HashMap<>();

	/*
	 * This method will fetch the data from file into ArrayList
	 */
	private List<String> getInputFromFile() {

		File file = new File(fileName);
		List<String> inputStringList = new ArrayList<>();
		String currentLine;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			while ((currentLine = reader.readLine()) != null) {
				inputStringList.add(currentLine.toString());
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return inputStringList;

	}

	/*
	 * This method loops over the String values in List and passes it to get the
	 * character count Once character count is obtained- that is added to another
	 * map where key= character count Hashmap and value= input String
	 */
	private void getAnagrams(List<String> inputWordList) {

		try {

			for (String inputString : inputWordList) {
				if (!inputString.isEmpty() && inputString.length() > 0)
					getAnagramListMap(characterCountMap(inputString), inputString, anagramListMap);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/*
	 * This method prepares a map of character counts in given string
	 */
	private HashMap<Character, Integer> characterCountMap(String inputString) {

		HashMap<Character, Integer> characterCountHashMap = new HashMap<>();
		for (int i = 0; i < inputString.length(); i++) {
			if (characterCountHashMap.containsKey(inputString.charAt(i))) {
				int getCurrentCount = characterCountHashMap.get(inputString.charAt(i));
				characterCountHashMap.put(inputString.charAt(i), ++getCurrentCount);
			} else {
				characterCountHashMap.put(inputString.charAt(i), 1);
			}
		}
		return characterCountHashMap;
	}

	/*
	 * This method adds the character count map and input string into wrapper map If
	 * for any given value key is same then that value is added in ArrayList to
	 * existing key If key is not present new value is added to ArrayList
	 */

	private void getAnagramListMap(HashMap<Character, Integer> characterCountMap, String inputWord,
			HashMap<HashMap<Character, Integer>, ArrayList<String>> anagramListMap) {

		if (anagramListMap.containsKey(characterCountMap)) {
			anagramListMap.get(characterCountMap).add(inputWord);
		} else {
			ArrayList<String> valueList = new ArrayList<>();
			valueList.add(inputWord);
			anagramListMap.put(characterCountMap, valueList);
		}

	}
	/*
	 * Used to print all the anagram in the wrapper map where the value size is
	 * greater than 1
	 */

	private void printAnagrams(HashMap<HashMap<Character, Integer>, ArrayList<String>> anagramListMap2) {

		anagramListMap2.forEach((anagKey, anagValue) -> {
			anagValue.stream().filter(itr -> anagValue.size() > 1).map(str -> str + " ").forEach(System.out::print);
			if(anagValue.size() > 1)
				System.out.println("");
		});

	}

	/*
	 * Entry point of this Program
	 */
	public static void main(String[] args) {
		System.out.println("--------------Start of Anagram Program--------------");
		AnagramFinder anagramObject = new AnagramFinder();
		List<String> inputWordList = anagramObject.getInputFromFile();
		anagramObject.getAnagrams(inputWordList);
		anagramObject.printAnagrams(anagramObject.anagramListMap);
		System.out.println("--------------End of Anagram Program--------------");

	}

}
