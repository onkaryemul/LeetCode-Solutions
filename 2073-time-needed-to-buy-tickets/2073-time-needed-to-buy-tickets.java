class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int timeRequiredToBuy(int[] tickets, int k) {
        int seconds = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int n = tickets.length;
        for(int i=0; i < n; i++) {
            queue.add(i); // adding indices for persons, starting from 0 to n-1
        }
        
        while(!queue.isEmpty()) {
            seconds++;
            
            int person = queue.poll();
            
            if(tickets[person] >= 1) {
                tickets[person]--;
            }
            
            if(person == k && tickets[person] == 0) {
                break;
            }
            
            if(person != k && tickets[person] == 0) {
                continue;
            }
            
            queue.add(person);
        }
        
        return seconds;
    }
    
}

