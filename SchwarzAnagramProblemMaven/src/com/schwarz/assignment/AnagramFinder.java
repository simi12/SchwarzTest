package com.schwarz.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AnagramFinder {

	private String fileName = "src/resources/anagramInputFile.txt";
	private HashMap<TreeMap<Character, Integer>, ArrayList<String>> anagramListMap = new HashMap<>();

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
	private TreeMap<Character, Integer> characterCountMap(String inputString) {

		
		TreeMap<Character, Integer> sortedCharacterCountMap=new TreeMap<>();
		
		for (int i = 0; i < inputString.length(); i++) {
			if (sortedCharacterCountMap.containsKey(inputString.charAt(i))) {
				int getCurrentCount = sortedCharacterCountMap.get(inputString.charAt(i));
				sortedCharacterCountMap.put(inputString.charAt(i), ++getCurrentCount);
			} else {
				sortedCharacterCountMap.put(inputString.charAt(i), 1);
			}
		}
	
		
		return sortedCharacterCountMap;
	}

	/*
	 * This method adds the character count map and input string into wrapper map If
	 * for any given value key is same then that value is added in ArrayList to
	 * existing key If key is not present new value is added to ArrayList
	 */

	private void getAnagramListMap(TreeMap<Character, Integer> characterCountMap, String inputWord,
			HashMap<TreeMap<Character, Integer>, ArrayList<String>> anagramListMap) {

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

	private void printAnagrams(HashMap<TreeMap<Character, Integer>, ArrayList<String>> anagramListMap2) {

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
