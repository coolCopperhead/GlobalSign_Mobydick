package com.mobydick.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DataFileReader{


	public Map<String,Integer> readFile(String inputResource) {
		
		Map<String,Integer> wordMap = new HashMap<String,Integer>();
		BufferedReader br=null;
		String line;
		FileReader file;
		try {
			file = new FileReader(inputResource);
			br = new BufferedReader(file);
			while ((line = br.readLine()) != null) {
				//to split word anything wich not contains continuous sequence of letters | tr -cs 'a-zA-z' [\n*]
				String string[] = line.toLowerCase().split("([^A-Za-z])"); 
				for (String s : string) {
					if (!s.isEmpty()) {
						//Converting String into lowercase | tr '[upper]' '[lower]'
						s = s.toLowerCase(); 
						//Counting words using map
						if (wordMap.containsKey(s))
							wordMap.put(s, wordMap.get(s) + 1);
						else
							wordMap.put(s, 1);
					}
				}
			}
			br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return wordMap;
	}

	
	
}
