/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


// Find Median from Data Stream

// TC : O(logN) => for the addNum()
//    : O(1) => for the findMedian()

// SC : O(N) => for using Heap(PriorityQueue)

class MedianFinder {

    // Using Heap(PriorityQueue)
    private PriorityQueue<Integer> leftMaxHeap; // max heap
    private PriorityQueue<Integer> rightMinHeap; // min heap
    

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    // TC : O(logN) => for adding element in to the priority queue
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        }
        else {
            rightMinHeap.add(num);
        }
        
        // always maintain leftMaxHeap size one greater than rightMinHeap size
        // or both sizes should be equal
        if(Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        }
        else if(leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    // TC : O(1)
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()) {
            // even no. of elements
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }
        
        // odd no. of elements
        return (double)leftMaxHeap.peek();
    }
    
}

