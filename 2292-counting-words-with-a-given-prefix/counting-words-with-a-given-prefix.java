class Solution {
    
    // Brute force approach

    // TC : O(n*m), where n = no. of words, m = length of pref string
    // SC : O(1)

    public int prefixCount(String[] words, String pref) {
        int cnt = 0;

        for(String word : words) {
            if(word.startsWith(pref)) {
                cnt++; // found a string with pref as a prefix
            }
        }

        return cnt;
    }

}


/*
// Approach-2 (Using Trie)
// T.C : O(n*l + m), where n = number of words, m = length of pref, l = average length of word
// S.C : O(n*l)

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        count = 0;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode pCrawl = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
            pCrawl.count++;
        }
        pCrawl.isEndOfWord = true;
    }

    int searchPrefixCount(String pref) {
        TrieNode pCrawl = root;
        for(char ch : pref.toCharArray()) {
            int idx = ch - 'a';
            if(pCrawl.children[idx] == null) {
                return 0;
            }
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.count;
    }
}


class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();

        for(String word : words) {
            trie.insert(word);
        }

        return trie.searchPrefixCount(pref);
    }
}
*/

