/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */


class SeatManager {
    
    // TC : O(n*logn + m*logn), where n = no. of seats
    // SC : O(n)
    
    // Using Min-Heap (PriorityQueue)

    private PriorityQueue<Integer> pq;
    
    // Constructor to initialize SeatManager object ==> that manage n seats numbered from 1 to n
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        // TC : O(n*logn)
        for(int i=1; i <= n; i++) { // seats are numbered from 1 to n
            pq.add(i); // All seats are initially available
        }
    }
    
    // TC : O(m*logn), m = no. of calls made to the reserve()
    public int reserve() {
        int seat = pq.poll(); // pop the "smallest numbered unreserved seat"
        return seat;
    }
    
    // TC : O(m*logn)
    public void unreserve(int seatNumber) {
        pq.add(seatNumber); // add given seatNumber to the priorityQueue pq => indicating that this seatNumber is now unreserved and it is available for reserve
    }
    
}


/* 
//Approach-3 (Improving Approach-2) - Avoiding pre-initialising of heap
//T.C : O(m* log(n)) , where m = number of reserve calls
//S.C : O(n)

class SeatManager {
    private PriorityQueue<Integer> pq;
    private int seatMarker;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        seatMarker = 1;
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            int seat = pq.poll();
            return seat;
        }

        int seat = seatMarker;
        seatMarker++;
        return seat;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
*/

