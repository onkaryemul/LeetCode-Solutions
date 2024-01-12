class Solution {
    // TC : O(n)
    // SC : O(1)
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        
        s = s.toLowerCase();
        
        String a = s.substring(0, len/2);
        String b = s.substring(len/2);
        
        int aCount = countVowels(a);
        int bCount = countVowels(b);
        
        if(aCount == bCount) {
            return true;
        }
        
        return false;
    }
    
    
    // Function to calculate the number of vowels in the input string str
    private int countVowels(String str) {
        int count = 0;
        int n = str.length();
        
        for(int i=0; i<n; i++) {
            char currChar = str.charAt(i);
            if(currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u') {
                count++;
            }
        }
        
        return count;
    }
    
    
}

