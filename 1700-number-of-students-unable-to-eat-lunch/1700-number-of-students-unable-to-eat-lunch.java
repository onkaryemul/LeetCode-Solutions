class Solution {
    
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length; // int len = sandwiches.length;
        
        Queue<Integer> studentQueue = new LinkedList<>();
        for(int student : students) {
            studentQueue.add(student);
        }
        
        Stack<Integer> sandwichStack = new Stack<>();
        for(int i = len-1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }
     
        int served = 0;
        
        while(!studentQueue.isEmpty() && served < studentQueue.size()) {
            if(sandwichStack.peek().equals(studentQueue.peek())) {
                sandwichStack.pop();
                studentQueue.poll();
                served = 0;
            }
            else {
                studentQueue.add(studentQueue.peek());
                studentQueue.poll();
                served++;
            }
        }
        
        return studentQueue.size();
    }
    
}


