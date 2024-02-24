class Pair {
    int first, second;
    
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


// Greedy Approach:  Min-heap(Priority Queue)
class Solution {
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Make the bidirectional graph
        List<List<Pair>> g = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            g.add(new ArrayList<>());
        }
        
        for(int[] meeting : meetings) {
            g.get(meeting[0]).add(new Pair(meeting[1], meeting[2]));
            g.get(meeting[1]).add(new Pair(meeting[0], meeting[2]));
        }
        
        
        // Make min-heap (Priority Queue) -> Pair with minimum meeting time will be given more priority
        // (t, x) : t -> time at which secret is known & x -> to whom secret is known at that time
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        pq.add(new Pair(0,0)); // at time 0, 0 knows secret
        pq.add(new Pair(0, firstPerson)); // at time 0, firstPerson knows secret
        
        
        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int t = current.first; // time at which secret is known
            int x = current.second; // to whom secret is known at that time
            
            if(visited[x]) {
                continue;
            }
            
            visited[x] = true;
            
            for(Pair it : g.get(x)) {
                if(visited[it.first]) {
                    continue;
                }
                
                if(it.second >= t) {
                    pq.add(new Pair(it.second, it.first));
                }
            }
        }
        
        
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            if(visited[i]) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
}

