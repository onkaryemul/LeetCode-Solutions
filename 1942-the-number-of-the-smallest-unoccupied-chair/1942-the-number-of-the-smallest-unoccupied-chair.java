class Solution {
    
    // Optimal Approach
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using Min-Heaps (PriorityQueue)
    
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length; // no. of friends
        
        // Given => All arrival times are distinct
        int targetArrivalTime = times[targetFriend][0];
        
        // Sort the times[] based on arrival time
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-Heap (for departure times) => {departureTime, chairNo}
        PriorityQueue<int[]> occupied = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        
        // Min-Heap (for available chairs)
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>(); 
        
        int lastChair = 0; // initially, unoccupied chair with smallest numbert
        
        for(int[] time : times) {
            int arrival = time[0];
            int depart = time[1];
            
            // Check if occupied chairs can be vacated(can be made free)
            while(!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                freeChairs.offer(occupied.poll()[1]); // Add the chair to the free chairs
            }
            
            int currSeat;
            
            if(freeChairs.isEmpty()) { // No free chairs, then use the next available chair
                currSeat = lastChair; 
                lastChair++;
            }
            else {
                currSeat = freeChairs.poll(); // Get the least available chair
            }
            
            // Add the friend with their departure time & chair no.
            occupied.offer(new int[]{depart, currSeat}); 
            
            if(arrival == targetArrivalTime) {
                return currSeat; // Return the chair no. for the target friend
            }
        }
        
        return -1; // Just in case, though it should never reach here
    }
    
}


/*
// Approach-1 (Naive O(n^2) approach that comes to mind first)
//T.C : O(n^2)
//S.C : O(n)
    
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[] endTimes = new int[n]; // Track the end times for each chair

        int targetArrivalTime = times[targetFriend][0];
        
        // Sort based on arrival time
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] time : times) {
            int arrival = time[0];
            int depart = time[1];

            // Find the first unoccupied chair
            for (int i = 0; i < n; i++) {
                if (endTimes[i] <= arrival) {
                    endTimes[i] = depart; // Update with current friend's depart time

                    if (arrival == targetArrivalTime) {
                        return i; // Return the chair number if it's the target friend
                    }
                    break; // Move to the next friend after finding a chair
                }
            }
        }
        
        return -1; // Just in case, though it should never reach here
    }
*/

