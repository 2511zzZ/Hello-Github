package cn.zzz.finished;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bayes {
	public Map<String, Integer> languageModel(String path) throws IOException{
		
		//通过已有的big.txt文本建立一个语言模型
		//一个word-frequency的HashMap
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while ((line = reader.readLine()) != null) {
			String[] words = line.split("\\s+");
			for(String word:words) {
				word = word.replaceAll("[\\pP\\p{Punct}]","").trim();
				if(map.containsKey(word)) {
					map.put(word, map.get(word)+1);
				}
				else {
					map.put(word, 1);
				}
			}
		}
		reader.close();
		return map;
	}
}
