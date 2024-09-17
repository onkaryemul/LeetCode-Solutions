class Solution {
    
    // TC : O(n + m)
    // SC : O(n + m)
    
    // Using "HashMap" to store frequency of words in s1 and s2
    public String[] uncommonFromSentences(String s1, String s2) {
        // Create a HashMap to count the frequency of each word
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        // Tokenize the first sentence and update the word count
        countWords(s1, wordCount);
        
        // Tokenize the second sentence and update the word count
        countWords(s2, wordCount);
        
        // Collect words that appear exactly once
        List<String> result = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if(entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Convert the list to an array and return it
        return result.toArray(new String[0]);
    }
    
    
    // Helper function
    private void countWords(String sentence, HashMap<String, Integer> wordCount) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");
        
        // Update the word count in the map
        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }
    
}

