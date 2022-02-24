package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import com.schwarz.assignment.AnagramThreadBasedFinder;



public class AnagramFinderTest {
	
	@Test
	public void getInputFromFileTest() throws IOException{
		String expectedValue="act";
		String file="src/resources/anagramInputFile.txt";
		
		BufferedReader reader= new BufferedReader(new FileReader(file));
		String currentLine=reader.readLine();
		
		assertEquals(expectedValue, currentLine);
		
	}
	
	@Test
	public void getCharacterCountMapTest() {
		HashMap<Character, Integer> expectedValue=new HashMap<>();
		expectedValue.put('a', 1);
		expectedValue.put('c', 1);
		expectedValue.put('t', 1);
		
		AnagramThreadBasedFinder anagramObject = new AnagramThreadBasedFinder();
		HashMap<Character, Integer> actualValue=anagramObject.characterCountMap("act");
		System.out.println("ActualValue="+actualValue);
		assertEquals(expectedValue, actualValue);
		
	}
	
	@Test
	public void getgetAnagramListMap()
	{
		HashMap<Character, Integer> hm1=new HashMap<>();
		hm1.put('a', 1);
		hm1.put('c', 1);
		hm1.put('t', 1);
		
		HashMap<Character, Integer> hm2=new HashMap<>();
		hm2.put('c', 1);
		hm2.put('a', 1);
		hm2.put('t', 1);
		
		ArrayList<String> inputList=new ArrayList<>();
		inputList.add("act");
		inputList.add("cat");
		
		HashMap<HashMap<Character, Integer>, ArrayList<String>> expectedAnagramListMap= new HashMap<>();
		expectedAnagramListMap.put(hm1,inputList);
		
		HashMap<HashMap<Character, Integer>, ArrayList<String>> actualAnagramListMap= new HashMap<>();
		AnagramThreadBasedFinder anagramObject = new AnagramThreadBasedFinder();
		
		anagramObject.getAnagramListMap(hm1, inputList.get(0),actualAnagramListMap );
		anagramObject.getAnagramListMap(hm2, inputList.get(1),actualAnagramListMap );
		assertEquals(expectedAnagramListMap, actualAnagramListMap);
		
		
	}
	
}
