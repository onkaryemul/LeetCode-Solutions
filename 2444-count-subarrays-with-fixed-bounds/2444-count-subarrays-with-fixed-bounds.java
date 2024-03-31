class Solution {
    
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long cnt = 0;
        
        ArrayList<Integer> mina = new ArrayList<>();
        ArrayList<Integer> maxa = new ArrayList<>();
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == minK) {
                mina.add(i);
            }
            if(nums[i] == maxK) {
                maxa.add(i);
            }
        }
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                continue;
            }
            
            int l = i;
            
            while(i < nums.length && nums[i] >= minK && nums[i] <= maxK)  {
                i++;
            }
            
            i--;
            
            int last = l - 1;
            
            for(int j=l; j <= i; j++) {
                if(nums[j] == minK) {
                    int next = Collections.binarySearch(maxa, j);
                    if(next < 0)
                        next = -next - 1;
                    long cnt1 = j - last;
                    if(next == maxa.size()) {
                        continue;
                    }
                    long cnt2 = i - maxa.get(next) + 1;
                    if(cnt2 > 0) {
                        cnt += (cnt1 * cnt2);
                        last = j;
                    }
                }
                else if (nums[j] == maxK) {
                    int next = Collections.binarySearch(mina, j);
                    if(next < 0)
                        next = -next - 1;
                    long cnt1 = j - last;
                    if(next == mina.size()) {
                        continue;
                    }
                    long cnt2 = i - mina.get(next) + 1;
                    if(cnt2 > 0) {
                        cnt += (cnt1 * cnt2);
                        last = j;
                    }
                }
            }
            
        }
        
        return cnt;
    }
    
}

