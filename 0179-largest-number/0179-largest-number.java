class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using custom sort -> Comparator
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        String[] s = new String[n];
        for(int i=0; i < n; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(s, (a, b) -> (b+a).compareTo(a+b));
        
        if(s[0].startsWith("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : s) {
            sb.append(str);
        }
        
        return sb.toString();
    }
    
}

