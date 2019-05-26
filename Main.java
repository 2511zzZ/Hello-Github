package cn.zzz.finished;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static String path = "./txt resource/big2.txt";
	public static void main(String args[]) throws IOException {
		Bayes b = new Bayes();
		@SuppressWarnings("unused")
		Map<String, Integer> map = b.languageModel(path);
		Scanner scanner = new Scanner(System.in);
		while(!scanner.hasNext("#")) {
			String word = scanner.next();
			Calculate cal = new Calculate();
			System.out.println("您想输入的词可能是:");	
			List<String> list = cal.getNearWords(word);
			List<String> list1 = new ArrayList<>();
			
			//输出7个最大可能的单词
			for(String s:list) {
				System.out.print(s+" ");
				//System.out.println(map.get(s));
			}
			if(list.size()<7) {
				for(String s:list) {
					list1.addAll(cal.getNearWords(s));
				}
				int i = 7-list.size();
				for(String s1:list1) {
				if(!list.contains(s1)&&i>0) {
					System.out.print(s1+" ");
					//System.out.println(map.get(s));
					i--;
					}
				}
			}
		}
		scanner.close();
	}
}
