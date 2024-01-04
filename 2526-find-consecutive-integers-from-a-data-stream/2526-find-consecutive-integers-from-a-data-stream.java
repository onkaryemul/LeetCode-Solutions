class DataStream {

    private final int value;
    private final int k;

    private int lastElement;
    private int timesSeen;
    
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if(lastElement == num) {
            timesSeen++;
        } else {
            timesSeen = 1;
        }
        
        lastElement = num;
        
        return lastElement == value && timesSeen>=k;
    }
    
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */