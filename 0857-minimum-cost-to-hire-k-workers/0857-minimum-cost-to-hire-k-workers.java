class Solution {
    
    // T.C : O(nlogn + klogk + n*log(k))
    // S.C : O(n+k)
    
    public double mincostToHireWorkers(int[] quality, int[] min_wage, int k) {
        int n = quality.length;

        // Calculate the wage-to-quality ratio for each worker and store in a pair
        double[][] worker_ratio = new double[n][2];
        for (int worker = 0; worker < n; worker++) {
            worker_ratio[worker][0] = (double) min_wage[worker] / quality[worker];
            worker_ratio[worker][1] = quality[worker];
        }
        // Sort the workers based on their wage-to-quality ratio
        Arrays.sort(worker_ratio, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum_quality = 0;
        for (int i = 0; i < k; i++) {
            pq.offer((int) worker_ratio[i][1]); // Push all qualities in max-heap
            sum_quality += worker_ratio[i][1]; // Find sum of qualities
        }

        double managerRatio = worker_ratio[k - 1][0];
        double result = managerRatio * sum_quality;

        for (int manager = k; manager < n; manager++) {
            managerRatio = worker_ratio[manager][0];

            pq.offer((int) worker_ratio[manager][1]); // Push all qualities in max-heap
            sum_quality += worker_ratio[manager][1]; // Find sum of qualities

            if (pq.size() > k) {
                sum_quality -= pq.poll();
            }

            result = Math.min(result, managerRatio * sum_quality);
        }

        return result;
    }
    
}

