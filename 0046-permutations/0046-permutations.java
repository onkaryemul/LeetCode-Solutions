class Solution {
    
    // TC : O(N! * N)
    // SC : O(1)
    
    // Using "Backtracking" and "Swapping" approach
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        recurPermute(0, nums, ans);
        
        return ans;
    }
    
    
    // Helper function -> recursive 
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        // Base case
        if(index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            
            ans.add(new ArrayList<>(ds));
            
            return;
        }
        
        // Iterate through nums[] from 'index' and put each element at curr index 'index'
        for(int i=index; i < nums.length; i++) {
            swap(i, index, nums);
            
            recurPermute(index+1, nums, ans);
            
            swap(i, index, nums);
        }
    }
    
    
    // Swap function
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}


/*
Solution 1: Recursive

Time Complexity:  N! x N
Space Complexity:  O(N)

    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        
        recurPermute(nums, ds, ans, freq);
        
        return ans;
    }
    
    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                
                recurPermute(nums, ds, ans, freq);
                
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
*/

