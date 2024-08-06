class Solution {
    
    // TC : O(n) + O(26 * log26)
    // SC : O(n)
    
    // Greedy Approach - Using Map & doing as asked in problem
    public int minimumPushes(String word) {
        // String word containing 'distinct' lowercase English letters
        int n = word.length();
        
        // Edge case/Corner case
        if(n <= 8) { // 2, 3, 4, 5, 6, 7, 8, 9
            return n;
        }
        
        int minPushes = 0; // store minimum no. of times the keys will be pushed to type the string word
        // Key: Key of Keypad from 2 to 9 (total keys: 8)
        // Value: No. of characters to each key (choosing greedily)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int assignKey = 2;
        
        for(int i=0; i < n; i++) {
            if(assignKey > 9) {
                assignKey = 2;
            }
            
            map.put(assignKey, map.getOrDefault(assignKey, 0) + 1); 
            
            minPushes += map.get(assignKey); // updating minimum no. of pushes with no. of pushes required for current character from word
            
            assignKey++;
        }
        
        return minPushes;
    }
    
}


/*
//Approach-2 (Simplifying Approach-1 above)
//T.C : O(n) + O(26log26)
//S.C : O(1)

public class Solution {

    public int minimumPushes(String word) {
        int[] mp = new int[26];

        // Generic solution
        for (char ch : word.toCharArray()) {
            mp[ch - 'a'] = 1; // Mentioned in the question, all letters will be distinct
        }

        // Descending order of frequency
        Integer[] mpInteger = Arrays.stream(mp).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += mpInteger[i] * ((i / 8) + 1);
        }
        
        return ans;
    }
}

*/

