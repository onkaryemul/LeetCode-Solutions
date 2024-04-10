class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        
        Arrays.sort(deck); // sorting -> TC : O(n*logn)
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < n; i++) {
            queue.add(i);
        }
        
        int i = 0;
        
        while(!queue.isEmpty()) {
            int k = queue.peek();
            
            ans[k] = deck[i];
            
            queue.remove();
            
            if(!queue.isEmpty()) {
                int x = queue.peek();
                queue.add(x);
                queue.remove();
            }
            
            i++;
        }
        
        return ans;
    }
    
}

