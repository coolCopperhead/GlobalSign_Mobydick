package com.mobydick.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Utility {
	
	public static HashMap<String, Integer> sortMapByValue(Map<String, Integer> wordMap) {
		
		HashMap<String, Integer> tempWordMap = new LinkedHashMap<String, Integer>();
		List<Map.Entry<String, Integer>> listWordMap = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());
		
		//Comparator to sort Map on basis of count of words
		WordComparator wordComparator = new WordComparator(); 
		// List sorting on basis of map's value
		Collections.sort(listWordMap, wordComparator);
		
		//Parsing map and putting in sorted order. 
		for (Map.Entry<String, Integer> entry : listWordMap) {
			tempWordMap.put(entry.getKey(), entry.getValue());
		}
		return tempWordMap;
	}

	public static void printFrequentUsedCharacters(
			HashMap<String, Integer> sortByValue) {
		int i = 1;
		for (Map.Entry<String, Integer> entry : sortByValue.entrySet()) {
			if (i > 20) //Print 20 characters | head -20
				break;
			String Key = entry.getKey();
			int value = entry.getValue();
			System.out.println(Key+"\t\t "+ value);
			//System.out.println(Key + "     " + value);
			i++;
		}
	}

	public static String loadConfig(String configparameter, String propertiesFileName) {
		String sConfigvalue="";
		FileInputStream inputStream;
		Properties properties;
		try {
			inputStream = new FileInputStream(new File(propertiesFileName));
			properties = new Properties();
			properties.load(inputStream);
			sConfigvalue = properties.getProperty(configparameter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sConfigvalue;
		
	}	
	
}


