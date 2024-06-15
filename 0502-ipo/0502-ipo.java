class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using Max-Heap & Greedily picking up projects
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length; // n = capital.length
        
        List<int[]> projects = new ArrayList<>();
        for(int i=0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        
        // Sort the list using capital in ascending order 
        projects.sort(Comparator.comparingInt(a -> a[0]));
        
        // Make Max-Heap and store the profit in descending order
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        
        while(k > 0) {
            while(i<n && projects.get(i)[0] <= w) {
                maxProfitHeap.add(projects.get(i)[1]); // adding profit of project to max heap
                i++;
            }
            
            if(maxProfitHeap.isEmpty()) {
                break;
            }
            
            w += maxProfitHeap.poll();
            
            k--;
        }
        
        return w; // final maximized capital
    }
    
}

