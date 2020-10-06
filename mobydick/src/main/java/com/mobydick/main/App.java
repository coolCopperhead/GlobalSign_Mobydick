package com.mobydick.main;

import java.util.HashMap;
import java.util.Map;
import com.mobydick.reader.DataFileReader;
import com.mobydick.utility.Utility;

public class App 
{
    public static void main( String[] args )
    {
		String sFilePath;
		try {
			Map<String, Integer> wordMap = new HashMap<String, Integer>();
			sFilePath = Utility.loadConfig("inputFile","config\\config.properties");
			DataFileReader fileReader = new DataFileReader();
			wordMap = fileReader.readFile(sFilePath);
			if (wordMap != null)
				Utility.printFrequentUsedCharacters(Utility.sortMapByValue(wordMap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
