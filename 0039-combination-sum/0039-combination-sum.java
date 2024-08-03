class Solution {
    
    // Recursion
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        
        return ans;
    }
    
    
    private void findCombinations(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base case
        if(idx == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
        
            return;
        }
        
        // pick
        if(arr[idx] <= target) { // check if we can pick arr[idx]
            ds.add(arr[idx]); // added in data structure 
            
            findCombinations(idx, arr, target - arr[idx], ans, ds); // staying at same index to pick up any number of times
            
            ds.remove(ds.size() - 1);
        }
        
        // not pick  
        findCombinations(idx+1, arr, target, ans, ds);
    }
    
}

