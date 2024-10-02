class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using dummy array & hashmap
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        
        // filling arr[] elements in dummy[], so that we cannot lost our original arr[] 
        int[] dummy = new int[n];
        for(int i=0; i < n; i++) {
            dummy[i] = arr[i];  
        }
        
        // Sorting the dummy array
        Arrays.sort(dummy);
        
        // key : element
        // value : rank
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1; 
        
        for(int i=0; i < n; i++) {
            if(i > 0 && dummy[i] != dummy[i-1]) {
                rank++;
            }
            map.put(dummy[i], rank);
        }
        
        // Putting the ranks from the map into array ranks[]
        int[] ranks = new int[n];
        
        for(int i=0; i < n; i++) {
            ranks[i] = map.get(arr[i]);
        }
        
        return ranks;
    }
    
}

