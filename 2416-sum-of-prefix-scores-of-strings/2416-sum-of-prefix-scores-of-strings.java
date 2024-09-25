class Solution {
    
    // n = no. of words in words[]
    // l = average length of each word
    

    // TC : O(n * l)
    // SC : O(n * l), need to store all characters of words
    
    
    // Using TRIE (Prefix Tree)
    
    // TrieNode class 
    class TrieNode {
        int countP = 0; // stores the no. of prefixes ending here
        TrieNode[] children = new TrieNode[26]; // array to store children
        
        // Constructor to initialize a new TrieNode
        public TrieNode() {
            for(int i=0; i < 26; i++) {
                children[i] = null;
            }
            countP = 0;
        }
    }

    
    // function to create a new TrieNode (Not needed separately in Java)
    private TrieNode getTrieNode() {
        return new TrieNode();
    }
    
    
    // Main algorithm code
    // Main function to return the sum of prefix scores for each word
    public int[] sumPrefixScores(String[] words) {
        int n = words.length; // no. of words
        
        TrieNode root = getTrieNode();
        
        // Insert all words into the Trie
        for(String word : words) {
            insert(word, root);
        }
        
        // Array to store the result (sum of prefixe scores of each word)
        int[] result = new int[n];
        
        // Calculate the sum of prefix score for each word
        for(int i=0; i < n; i++) {
            result[i] = getScore(words[i], root);
        }
        
        return result;
    }
    
    
    // Helper function -> to insert a word into the trie
    private void insert(String word, TrieNode root) {
        TrieNode crawl = root;
        
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            
            if(crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            
            crawl.children[idx].countP += 1;
            
            crawl = crawl.children[idx];
        }
    }
    
    
    // Helper function -> to get the score for the word
    // sum of scores for all prefixes
    private int getScore(String word, TrieNode root) {
        TrieNode crawl = root;
        
        int score = 0;
        
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            score += crawl.children[idx].countP;
            crawl = crawl.children[idx];
        }
        
        return score;
    }
    
}

