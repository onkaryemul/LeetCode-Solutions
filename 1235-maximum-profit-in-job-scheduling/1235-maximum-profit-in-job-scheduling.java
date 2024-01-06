class Solution {
    
    private class Job {
        private int startTime;
        private int endTime;
        private int profit;
        
        public Job(int sT, int eT, int p) {
            this.startTime = sT;
            this.endTime = eT;
            this.profit = p;
        }
    }
    
    // Main algorithm code
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int noOfJobs = startTime.length;
        
        List<Job> jobs = new ArrayList<>();
        
        for(int i=0; i<noOfJobs; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        Collections.sort(jobs, (a, b) -> (a.endTime - b.endTime));
        
        int ans = 0;
        // Key => Time, Value => profitTillTime
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(Job currJob : jobs) {
            Integer entryTillStartTime = map.floorKey(currJob.startTime);
            
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            
            ans = Math.max(ans, maxProfitTillStartTime + currJob.profit);
            
            map.put(currJob.endTime, ans);
        }
        
        return ans;
    }
    
}

