
class WordFrequency {
    String word;
    int count;
    
    public WordFrequency(String key, int value) {
        this.word = key;
        this.count = value;
    }
}



class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        // O(n)
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<WordFrequency> pq = new PriorityQueue<WordFrequency>(
           (a, b) -> a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count
        );
        
        // O(n*logk)
        for(String key : map.keySet()) {
            pq.offer(new WordFrequency(key, map.get(key))); // logk
        }
        
        
        List<String> ans = new ArrayList<String>();
        
        for(int i=0; i<k; i++) {
            WordFrequency wf = pq.poll(); // logk
            ans.add(wf.word);
        }
        
        return ans;
    }
    
}

