package cn.zzz.finished;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculate {
	
	//获得一个与输入的错误单词"有关"的所有单词
	
	private static final char[] allLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	Contains con = new Contains();
	Bayes bayes = new Bayes();
	String path = "./txt resource/big2.txt";
	
	public List<String> getNearWords(String input) throws IOException {
		Map<String,Integer> map = bayes.languageModel(path);
		Set<String> nearWords = new HashSet<String>();
		char[] characters = input.toCharArray();	
		
		//delete
		for(int i=0;i<input.length();i++) {
			nearWords.add(input.substring(0,i) + input.substring(i+1));
		}
		//exchange
		for(int i=0;i<input.length()-1;i++) {
			nearWords.add(input.substring(0,i) + characters[i+1] 
					+ characters[i] + input.substring(i+2));
		}
		//instead
		for(int i=0;i<input.length();i++) {
			for(char c : allLetters) {
				nearWords.add(input.substring(0,i) + c + input.substring(i+1));
			}
		}
		//insert
		for(int i=0;i<input.length()+1;i++){
			for(char c : allLetters) {
				nearWords.add(input.substring(0,i) + c + input.substring(i));
			}
		}
	
		return con.contains(nearWords, map);
	}
	
}
