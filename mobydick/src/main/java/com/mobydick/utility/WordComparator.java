package com.mobydick.utility;


import java.util.Comparator;
import java.util.Map;

public class WordComparator implements Comparator<Map.Entry<String,Integer>>{

	
	public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
		return (o2.getValue()).compareTo(o1.getValue()); //To sort in descending order by count - | sort -nr
	}
	
}
