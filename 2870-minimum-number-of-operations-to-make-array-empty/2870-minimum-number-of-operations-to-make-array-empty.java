class Solution {
    
    public int minOperations(int[] nums) {
        int cnt = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            
            if(freq == 1) {
                return -1;
            } else {
                if(freq%3 == 0) {
                    cnt += freq/3;
                } 
                else if (freq%3 == 1 || freq%3 == 2) {
                    cnt += (freq/3 + 1);
                } 
                else if (freq%2 == 0) {
                    cnt += freq/2;
                } 
                else {
                    return -1;
                }
            }
        }
        
        return cnt;
    }
    
}

