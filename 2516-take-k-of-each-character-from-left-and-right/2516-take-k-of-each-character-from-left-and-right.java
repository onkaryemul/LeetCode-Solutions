// class Solution {
    
//     // TC : O(n)
//     // SC : O(1)
    
//     // Using Sliding window technique
    
//     public int takeCharacters(String s, int k) {
//         int[] leftCounts = new int[3];
//         int[] rightCounts = new int[3];
        
//         int n = s.length();
        
//         int r = n;
        
//         // Traverse from right => till freq of a, b,and c becomes atleast k
//         while(rightCounts[0] < k || rightCounts[1] < k || rightCounts[2] < k) {
//             r--;
            
//             if(r < 0) {
//                 return -1;
//             }
            
//             rightCounts[s.charAt(r) - 'a']++;
//         }
        
//         // Initialise, the result with the total no. of characters that are taken from right such that freq of a, b, and c is atleat k
//         int res = n - r;
        
//         // apply sliding window technique
//         // take the character from left, and check if freq of character of left and right > k, then we can shrink the right side
//         for(int l=0; l < n; l++) {
//             int leftChar = s.charAt(l) - 'a';
            
//             leftCounts[leftChar]++;
            
//             while(r < n) {
//                 int rightChar = s.charAt(r) - 'a';
                
//                 if(rightCounts[rightChar] + leftCounts[leftChar] > k) {
//                     rightCounts[rightChar]--;
//                     r++;
//                 } 
//                 else {
//                     break;
//                 }
//             }
            
//             res = Math.min(res, l + 1 + n - r);
//         }        
        
//         return res;
//     }
    
// }

class Solution {
    
    // time O(n)
    // space O(1)
    
    public int takeCharacters(String s, int k) {
        int[] leftCounts = new int[3];
        int[] rightCounts = new int[3];
        
        int r = s.length();
        
        while (rightCounts[0] < k || rightCounts[1] < k || rightCounts[2] < k) {
            r--;
            if (r < 0)
                return -1;
            rightCounts[s.charAt(r) - 'a']++;
        }
        
        int res = s.length() - r;
        
        for (int l = 0; l < s.length(); l++) {
            int leftChar = s.charAt(l) - 'a';
            leftCounts[leftChar]++;
            
            while (r < s.length()) {
                int rightChar = s.charAt(r) - 'a';
                
                if (rightCounts[rightChar] + leftCounts[rightChar] > k) {
                    rightCounts[rightChar]--;
                    r++;
                } 
                else {
                    break;
                }
            }
            
            res = Math.min(res, l + 1 + s.length() - r);
        }
        
        return res;
    }
    
}

