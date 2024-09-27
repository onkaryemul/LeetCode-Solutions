/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

class MyCalendarTwo {

    // TC : O(n*logn)
    // SC : O(n)
    
    // Using TreeMap --> stores keys in sorted order
    
    // Here, treemap stores key(start time & end time) in sorted ascending order 
    
    // event = [start, end)
    
    /*  
        keys => dates  
        values => number of active events occuring on that date. 
       This will keep the dates sorted according to the keys.
    */
    private TreeMap<Integer, Integer> calendarMap;
    
    
    public MyCalendarTwo() {
        calendarMap = new TreeMap<>();
    }

    
    public boolean book(int start, int end) {
        // Increment the count at the start time
        calendarMap.put(start, calendarMap.getOrDefault(start, 0) + 1);
        
        // Decrement the count at the end time
        calendarMap.put(end, calendarMap.getOrDefault(end, 0) - 1);
        
        int cnt = 0; // active booking counts 
        
        for(int val : calendarMap.values()) { // val -> count of bookings at that start/end time
            cnt += val;
            
            if(cnt >= 3) { // activeBookings >= 3
                // If we encounter a triple booking, revert the changes and return false
                calendarMap.put(start, calendarMap.getOrDefault(start, 0) - 1);
                calendarMap.put(end, calendarMap.getOrDefault(end, 0) + 1);
                
                if(calendarMap.get(start) == 0) {
                    calendarMap.remove(start);
                }
                
                if(calendarMap.get(end) == 0) {
                    calendarMap.remove(end);
                }
                
                return false;
            }
        }
        
        return true;
    }
    
}

