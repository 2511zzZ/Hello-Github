package cn.zzz.finished;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Contains {
	
	//判断所有"有关"单词中哪些是"合法"单词,即存在于词库中的词
	
	public List<String> contains(Set<String> caculateWords,Map<String,Integer> map) throws IOException{
		List<String> containWords = new ArrayList<>();
		for(String s:caculateWords) {
			if(map.containsKey(s)) {
				containWords.add(s);
			}
		}
		
		//按在词库中出现的次数(频率)排序
		Collections.sort(containWords, new Comparator<String>() {
		      @Override
		      public int compare(String s1, String s2) {
		        if(map.get(s1)>=map.get(s2)) {
		          return -1;
		        }
		        else {
		          return 1;
		        }
		      }
		    });
		if(containWords.size() > 7) {
			return containWords.subList(0, 7);
		}
		else {
		return containWords;
		}
	}
}
