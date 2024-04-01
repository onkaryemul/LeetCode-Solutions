class Solution {
    
    // TC : O(n*logn) -> Due to merge sort -> count inversions
    // SC : O(n)
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        
        int li = 0; // local inversions
        for(int i=0; i < n-1; i++) {
            if(nums[i] > nums[i+1]) {
                li++;
            }
        }
        
        int gi = countInversion(nums, 0, n-1); // global inversions
        
        return gi == li;
    }
    
    
    // Merge sort -> TC : O(n*logn) & SC : O(n)
    private static int countInversion(int[] arr, int l, int r) {
        int res = 0;
        
        if(l < r) {
            int m = (l + r) / 2;
            // count inversion in left half
            res += countInversion(arr, l, m);
            // count inversion in right half
            res += countInversion(arr, m+1, r);
            // count inversion while merging left and right parts
            res += countAndMerge(arr, l, m, r);
        }
        
        return res;
    }
    
    
    private static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i=0; i < n1; i++) {
            left[i] = arr[l+i];
        }
        
        for(int i=0; i < n2; i++) {
            right[i] = arr[m+1+i];
        }
        
        int cnt = 0; // store the count of count inversion
        int i=0, j=0;
        int k = l; // k starts from l
        
        while(i<n1 && j<n2) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
                cnt += (n1-i); // additional code in merge sort -> for counting inversions
            }
        }
        
        while(i < n1) {
            arr[k++] = left[i++];
        }
        
        while(j < n2) {
            arr[k++] = right[j++];
        }
        
        return cnt;
    }
    
}


