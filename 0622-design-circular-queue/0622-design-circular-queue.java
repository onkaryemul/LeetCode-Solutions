/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */


// Design circular queue -> using an array
class MyCircularQueue {

    private int[] cqueue = null;
    private int front;
    private int rear;
    private int capacity; // actual capacity of the queue
    private int size; // total no. of elements present in the queue, initially 0
    
    
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.cqueue = new int[k]; // initializing queue of size k
        
        this.front = 0;
        this.rear = 0;
        
        this.size = 0; // initially, 0 items are present in the queue
    }

    // O(1)
    public boolean enQueue(int value) {
        if(this.isFull()) {
            return false;
        }
        else {
            cqueue[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }
    }
    
    // O(1)
    public boolean deQueue() {
        if(this.isEmpty()) {
            return false;
        }
        else {
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }
    
    // O(1)
    public int Front() {
        if(this.isEmpty()) {
            return -1;
        }
        else {
            return cqueue[front];
        }
    }
    
    // O(1)
    public int Rear() {
        if(this.isEmpty()) {
            return -1;
        }
        else {
            if(rear == 0) {
                return cqueue[cqueue.length - 1];
            }
            else {
                return cqueue[rear - 1];
            }
        }
    }
    
    // O(1)
    public boolean isEmpty() {
        if(size == 0) { // if queue has 0 items, then return true indicating queue is empty
            return true;
        }
        return false; 
    }
    
    // O(1)
    public boolean isFull() {
        if(size == capacity || (front == rear && !this.isEmpty())) {
            return true; // indicating queue is full
        }
        return false;
    }
    
}

