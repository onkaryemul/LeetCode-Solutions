class Solution {
    
    // Brute force
    
    // TC : O(m*log10(M) + n*log10(N)), where log10(M) = maximum no. of digits in any number of arr1  &  log10(N) = maximum no. of digits in any number of arr2
    // SC : O(m*log10(M))
    
    // Using set & counting no.of digits using log10(n) + 1
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>(); // set to store all prefixes of every number num in arr1
        
        // Insert all prefixes of elements from arr1 into the set
        for(int val : arr1) {
            while(!set.contains(val) && val > 0) {
                set.add(val);
                val = val / 10; // trim last digit
            }
        }
        
        int result = 0; // store the "length of Longest common prefix(LCP)" between all pairs of integers (x, y) such that x belongs to arr1 & y belongs to arr2
        
        for(int num : arr2) {
            while(!set.contains(num) && num > 0) {
                num /= 10; // trim last digit
            }
            
            if(num > 0) {
                result = Math.max(result, (int)(Math.log10(num) + 1));
            }
        }
        
        return result;
    }
    
}


/*   
//Approach 2 - Using Prefix Tree (TRIE)
//T.C : O(m⋅d+n⋅d)
//S.C : O(m⋅d)

class TrieNode {
    TrieNode[] children = new TrieNode[10];  // 0, 1, 2...9
}


class Solution {

    public TrieNode getTrieNode() {
        return new TrieNode();
    }

    public void insert(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    // Returns the length of the longest prefix
    public int search(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] != null) {
                length++;
                crawl = crawl.children[idx];
            } else {
                break;
            }
        }

        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getTrieNode();  // TRIE

        // Insert all elements of arr1 into the trie
        for (int num : arr1) {
            insert(num, root);
        }

        int result = 0;
        // Search for the longest common prefix in arr2
        for (int num : arr2) {
            result = Math.max(result, search(num, root));
        }

        return result;
    }
}
*/

