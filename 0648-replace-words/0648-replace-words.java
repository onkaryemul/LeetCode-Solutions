class Solution {
    
    // n = no. of words in dictionary,
    // w = no. of words in the sentence 
    // l = average length of each word
    
    // TC : O(n*l + w*l*l)   
    // SC : O(n*l)
    
    
    // Approach: Using HashSet and generating all substrings    
    public String replaceWords(List<String> dictionary, String sentence) {
        // Create Hashset from the dictionary list
        HashSet<String> set = new HashSet<>(dictionary); // TC : O(n*l) & SC : O(n*l)
        
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for(String word : words) {
            result.append(findRoot(word, set)).append(" ");
        }
        
        // Remove the trailing space
        return result.toString().trim();
    }
    
    
    // Helper function to find the root of a word in dictionary set
    private String findRoot(String word, HashSet<String> set) {
        int len = word.length();
        
        // Try all length substring starting from 0th index
        for(int l=1; l <= len; l++) {
            String root = word.substring(0, l);
            // Check if root is present in set
            if(set.contains(root)) {
                return root;
            }
        }
        
        // return the given word if the root for given word is not found in set
        return word;
    }
    
}
