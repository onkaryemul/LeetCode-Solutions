class Solution {
    
    //Approach-1 (Using simple Heap solution as it's asking for kth smallest)
    //T.C : O(n^2 * log(k))
    //S.C : O(k)

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double div = (double) arr[i] / arr[j];
                pq.offer(new double[]{div, (double) arr[i], (double) arr[j]});
                if (pq.size() > k)
                    pq.poll();
            }
        }

        double[] vec = pq.peek();
        int[] result = new int[2];
        result[0] = (int) vec[1];
        result[1] = (int) vec[2];
        return result;
    }
    
}


