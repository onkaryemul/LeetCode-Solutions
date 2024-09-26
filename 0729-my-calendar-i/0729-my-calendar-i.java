/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

// Design a Calendar
class MyCalendar {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using TreeMap 
    // stores all events(start, end) in sorted order of their start time

    // floorEntry => Lower Entry value
    // ceilingEntry => High Entry value
    
    private TreeMap<Integer, Integer> calendar = null;
    
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Condition around start time 
        // If 'start' of current event is less than 'end' of existing floorEntry, then return false (since overlap)
        // start < Lower Entry End time
        if(calendar.floorEntry(start) != null && start < calendar.floorEntry(start).getValue()) {
            return false; // overlap
        }
        
        // Condition around end time
        // If 'end' of current event is greater than 'start' of existing ceilingEntry, then return false (since overlap)
        // end > Higher Entry Start time
        if(calendar.ceilingEntry(start) != null && end > calendar.ceilingEntry(start).getKey()) {
            return false; // overlap
        }
        
        calendar.put(start, end);
        
        return true;
    }
    
}

