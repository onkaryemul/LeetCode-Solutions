/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */


// Design Circular Deque(double-ended queue) --> using an array
class MyCircularDeque {

    private int[] cdeque = null;
    private int front;
    private int rear;
    private int capacity; // actual capacity of the queue
    private int size; // total no. of elements in the queue, initially 0
    
    
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.cdeque = new int[k];
        
        this.front = 0;
        this.rear = k-1;
        
        this.size = 0; // initially, 0 items are present in the queue
    }
    
    // O(1)
    public boolean insertFront(int value) {
        if(this.isFull()) {
            return false;
        }
        
        cdeque[front] = value;
        front = (front + 1) % capacity;
        size++;
        return true;
    }
    
    // O(1)
    public boolean insertLast(int value) {
        if(this.isFull()) {
            return false;
        }
        
        cdeque[rear] = value;
        rear = (rear - 1 + capacity) % capacity;
        size++;
        return true;
    }
    
    // O(1)
    public boolean deleteFront() {
        if(this.isEmpty()) {
            return false;
        }
        
        front = (front - 1 + capacity) % capacity;
        int val = cdeque[front];
        size--;
        return true;
    }
    
    // O(1)
    public boolean deleteLast() {
        if(this.isEmpty()) {
            return false;
        }
        
        rear = (rear + 1) % capacity;
        int val = cdeque[rear];
        size--;
        return true;
    }
        
    // O(1)
    public int getFront() {
        if(this.isEmpty()) {
            return -1;
        }
        
        int val = cdeque[(front - 1 + capacity) % capacity];
        
        return val;
    }
    
    // O(1)
    public int getRear() {
        if(this.isEmpty()) {
            return -1;
        }
        
        int val = cdeque[(rear + 1)%capacity];
        
        return val;
    }
    
    // O(1)
    public boolean isEmpty() {
        if(size == 0) { // If there are 0 items in the queue, then it means queue is empty, 
            return true; // & hence return true
        }
        return false;
    }
    
    // O(1)
    public boolean isFull() {
        if(size == capacity) { // If no. of elements(size) in the queue == size of the queue(capacity), means queue is full
            return true; // & hence return true
        }
        return false;
    }   
    
}

