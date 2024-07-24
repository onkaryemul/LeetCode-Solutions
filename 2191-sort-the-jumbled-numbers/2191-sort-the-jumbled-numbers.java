class Solution {
    
    private static class Pair {
        long mappedValue;
        int originalNumber;
        
        public Pair(long mappedValue, int originalNumber) {
            this.mappedValue = mappedValue;
            this.originalNumber = originalNumber;
        }
    }
    
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create a list of pairs where each pair consists of a mapped value and the original number
        List<Pair> mappedNums = new ArrayList<>();
        
        for(int num : nums) { // iterate through original numbers
            // calculate the mapped value of the current number
            long mappedValue = getMappedValue(num, mapping);
            // Add the pair (mapped value, original number) to the list
            mappedNums.add(new Pair(mappedValue, num));
        }
        
        // Sort the list of pairs based on the mapped values
        Collections.sort(mappedNums, Comparator.comparingLong(pair -> pair.mappedValue));
        
        // Extract the sorted original numbers from the list of pairs
        int[] result = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            result[i] = mappedNums.get(i).originalNumber;
        }
        
        return result;
    }
    
    
    private long getMappedValue(int num, int[] mapping) {
        // base case
        if(num == 0) {
            return mapping[0];
        }
        
        long mappedValue = 0;
        long place = 1;
        
        while(num > 0) {
            int digit = num % 10;
            mappedValue += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
        
        return mappedValue;
    }
    
}


/* 
     public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Long, List<Integer>> mp = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == 0) {
                mp.computeIfAbsent((long)mapping[0], k -> new ArrayList<>()).add(x);
                continue;
            }
            
            List<Integer> temp = new ArrayList<>();
            while (x > 0) {
                temp.add(x % 10);
                x /= 10;
            }
            
            long num = 0;
            for (int j = temp.size() - 1; j >= 0; j--) {
                num = num * 10 + mapping[temp.get(j)];
            }
            
            mp.computeIfAbsent(num, k -> new ArrayList<>()).add(nums[i]);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Long, List<Integer>> entry : mp.entrySet()) {
            ans.addAll(entry.getValue());
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

*/

