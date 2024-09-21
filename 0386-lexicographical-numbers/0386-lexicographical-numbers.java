class Solution {
    
    // TC : O(n)
    // SC : O(1), not including the result list which we have to return
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        
        while(res.size() < n) {
            int curr = res.getLast();
            
            if(curr * 10 <= n) {
                res.add(curr * 10);
                continue;
            }
            
            while(curr % 10 == 9 || curr + 1 > n) {
                curr /= 10;
            }
            
            res.add(curr + 1);
        }
        
        return res;
    }
    
}

