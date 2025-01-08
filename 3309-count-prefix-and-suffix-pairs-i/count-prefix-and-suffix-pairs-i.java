class Solution {
    
    // Brute force approach

    // TC : O(n^2 * k), where n = no. of words, k = average length of word
    // SC : O(1)

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;

        int cnt = 0;

        for(int i=0; i < n; i++) {
            for(int j=i+1; j < n; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // Helper function
    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

}


/*
// Approach-1 Brute Force
// T.C : O(n^2 * l)
// S.C : O(n^2 * l)

// You can use startsWith() and endsWith() methods as well

    public int countPrefixSuffixPairs(List<String> words) {
        int count = 0;

        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (isPrefix(words.get(i), words.get(j)) && isSuffix(words.get(i), words.get(j))) {
                    count++;
                }
            }
        }

        return count;
    }
    
    private boolean isPrefix(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) 
           return false;

        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) 
               return false;
        }

        return true;
    }

    private boolean isSuffix(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        for (int i = m - 1; i >= 0; i--) {
            if (s1.charAt(i) != s2.charAt(n - (m - i))) 
               return false;
        }

        return true;
    }

------------------------------------------------------------------------------

// Approach-2 - Using TRIE
// T.C : ~O(n^2*l), n = number of words, l = average length of each word
// S.C : ~O(n*l), need to store all characters of words

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode pCrawl = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
        }
        pCrawl.isEndOfWord = true;
    }

    public boolean searchPrefix(String prefix) {
        TrieNode pCrawl = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (pCrawl.children[idx] == null) {
                return false;
            }
            pCrawl = pCrawl.children[idx];
        }
        return true;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int j = 0; j < n; j++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();

            prefixTrie.insert(words[j]);
            String reversed = new StringBuilder(words[j]).reverse().toString();
            suffixTrie.insert(reversed);

            for (int i = 0; i < j; i++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }

                String rev = new StringBuilder(words[i]).reverse().toString();

                if (prefixTrie.searchPrefix(words[i]) && suffixTrie.searchPrefix(rev)) {
                    count++;
                }
            }
        }

        return count;
    }
}
*/

