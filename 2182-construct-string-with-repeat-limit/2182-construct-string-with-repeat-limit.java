class Solution {
    
    // TC : O(n)
    // SC : O(26)
    
    // Using pointers & frequency table
    
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26]; // frequency array to store character counts
        
        // Count the frequency of each character
        for(char ch : s.toCharArray()) { // TC : O(n)
            count[ch - 'a']++; 
        }
        
        StringBuilder result = new StringBuilder();
        
        int i = 25; // Start from the largest character (z)
        
        while(i >= 0) { // TC : O(26)
            if(count[i] == 0) {
                i--;
                continue;
            }
            
            char ch = (char)('a' + i); // convert index to character
            
            int freq = Math.min(count[i], repeatLimit); // append up to repeatLimit times
            for(int k=0; k < freq; k++) {
                result.append(ch);
            }
            
            count[i] -= freq;
            
            if(count[i] > 0) {
                // Find the next largest character
                int j = i-1;
                
                while(j >= 0 && count[j] == 0) { // O(26)
                    j--;
                }
                
                if(j < 0) {
                    break; // No more characters left to append
                }
                
                result.append((char)('a' + j)); // append the next largest character once
                count[j]--;
            }
        }
        
        return result.toString();
    }
    
}


/*
// Approach-2 (Using max-heap + frequency table)
// T.C : O(n)
// S.C : O(26)

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26]; // Frequency array to store character counts
        
        // Count the frequency of each character
        for (char ch : s.toCharArray()) { // T.C: O(n)
            count[ch - 'a']++;
        }

        // Max heap (priority queue) to store characters in descending order
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll(); // Get the largest character
            
            int freq = Math.min(count[ch - 'a'], repeatLimit); // Append up to 'repeatLimit' times
            
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
            
            count[ch - 'a'] -= freq;

            // If the current character still has remaining occurrences
            if (count[ch - 'a'] > 0 && !pq.isEmpty()) {
                char nextChar = pq.poll(); // Get the next largest character
                
                result.append(nextChar);
                
                count[nextChar - 'a']--;

                // Reinsert characters into the priority queue if they still have remaining occurrences
                if (count[nextChar - 'a'] > 0) {
                    pq.offer(nextChar);
                }
                
                pq.offer(ch);
            }
        }

        return result.toString();
    }
*/

