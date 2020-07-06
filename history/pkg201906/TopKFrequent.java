package history.pkg201906;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    class WordCount {

        String word;
        int count;
    }

    public List<String> topKFrequent(final String[] words, final int k) {
        final Map<String, WordCount> map = new HashMap<>();
        for (final String word : words) {
            if (map.containsKey(word)) {
                final WordCount wordCount = map.get(word);
                wordCount.count = wordCount.count + 1;
            }
            else {
                final WordCount wordCount = new WordCount();
                wordCount.word = word;
                wordCount.count = 1;
                map.put(word, wordCount);
            }
        }
        final Collection<WordCount> wordCounts = map.values();
        final List<WordCount> ws = new ArrayList<>(wordCounts);
        Collections.sort(ws, new Comparator<WordCount>() {

            @Override
            public int compare(final WordCount o1, final WordCount o2) {
                if (o1.count > o2.count) {
                    return 1;
                }
                else if (o1.count == o2.count) {
                    return o1.word.compareTo(o2.word);
                }
                else {
                    return -1;
                }
            }
        });
        final List<String> result = new ArrayList<>();
        for (final WordCount wordCount : ws) {
            if (result.size() <= k) {
                result.add(wordCount.word);
            }
            else {
                break;
            }
        }
        return result;
    }
}
