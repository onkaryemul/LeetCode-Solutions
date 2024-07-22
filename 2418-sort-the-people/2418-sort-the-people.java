class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    public String[] sortPeople(String[] names, int[] heights) {
        // key: height
        // Value: name
        Map<Integer, String> map = new HashMap<>();
        
        int n = names.length; //  n = heights.length
        for(int i=0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        
        Arrays.sort(heights); // sort the heights array in ascending order, with largest heights at the end
        
        String[] sortedNames = new String[n];
        int index = 0;
        // Traverse the heights array from the end to get largest height first
        for(int i=n-1; i >= 0; i--) {
            sortedNames[index] = map.get(heights[i]);
            index++;
        }
        
        return sortedNames;
    }
    
}

