package package_in_201906;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	class WordCount{
		String word;
		int count;
	}
	public List<String> topKFrequent(String[] words, int k) {
		Map<String,WordCount>map=new HashMap<>();
		for (String word : words) {
			if(map.containsKey(word)) {
				WordCount wordCount=map.get(word);
				wordCount.count=wordCount.count+1;
			}else {
				WordCount wordCount=new WordCount();
				wordCount.word=word;
				wordCount.count=1;
				map.put(word, wordCount);
			}
		}
		Collection<WordCount>wordCounts=map.values();
		List<WordCount>ws=new ArrayList<>(wordCounts);
		Collections.sort(ws, new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				if(o1.count>o2.count) {
					return 1;
				}else  if(o1.count==o2.count) {
					return o1.word.compareTo(o2.word);
				}else {
					return -1;
				}
			}
		});
		List<String>result=new ArrayList<>();
		for(WordCount wordCount:ws) {
			if(result.size()<=k) {
				result.add(wordCount.word);
			}else {
				break;
			}
		}
		return result;
	}
}
