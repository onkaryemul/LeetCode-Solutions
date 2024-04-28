class Solution {
    
    // TC : O(n) + O(n) --> O(n)
    // SC : O(n)
    
    private int[] res;
    private int[] count;
    private List<HashSet<Integer>> tree;
    
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Initialise global variables
        res = new int[n];
        count = new int[n];
        
        tree = new ArrayList<HashSet<Integer>>();
        
        for(int i=0; i < n; i++) {
            tree.add(new HashSet<Integer>());
        }
        
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        postOrder(0, -1);
        preOrder(0, -1);
        
        return res;
    }
    
    
    private void postOrder(int root, int pre) {
        for(int i : tree.get(root)) {
            if(i == pre) {
                continue;
            }
            
            postOrder(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        
        count[root]++;
    }
    
    
    private void preOrder(int root, int pre) {
        for(int i : tree.get(root)) {
            if(i == pre) {
                continue;
            }
            res[i] = res[root] - count[i] + (count.length - count[i]);
            preOrder(i, root);
        }
    } 
    
}

