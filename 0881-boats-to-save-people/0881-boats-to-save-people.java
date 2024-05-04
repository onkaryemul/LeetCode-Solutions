class Solution {
    
    // TC : O(nlogn)
    // SC : O(1)
    
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        
        int boatCnt = 0;
        
        while(start <= end) {
            if(people[end] == limit) {
                end--;
                boatCnt++;
            }
            else if (people[start] + people[end] <= limit) {
                start++;
                end--;
                boatCnt++;
            }
            else {
                end--;
                boatCnt++;
            }
        }
        
        return boatCnt;
    }
    
}

