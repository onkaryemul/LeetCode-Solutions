class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Greedy approach
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        
        String str1 = strs[0];
        String strN = strs[strs.length-1];
        
        int index = 0;
        int lenStr1 = str1.length();
        
        while(index < lenStr1) {
            if(str1.charAt(index) == strN.charAt(index)) {
                index++;
            }
            else {
                break;
            }
        }
        
        return index == 0 ? "" : str1.substring(0, index);
    }
    
}

