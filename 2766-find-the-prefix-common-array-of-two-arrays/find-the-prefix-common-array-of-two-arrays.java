class Solution {

    // TC : O(n) ==> Optimal approach
    // SC : O(n)

    // Using HashMap 

    // Each array, ie. A[] and B[] are permutation of n integers 
    // Meaning => each one will contain numbers from 1 to n, with each number exactly once

    // If in hashmap, at any moment, a number is occuring twice => it means that number already occurred in both A and B (since, both A and B cannot have more than one occurrence of same num)

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length; // n == A.length == B.length

        int[] result = new int[n];
         
        // key : number from 1 to n
        // value : frequency of that num => if freq of that num is 2, then it means that it has occurred in both A[] and B[]
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int cnt = 0; // count of numbers that occurred in both arrays, at a moment
        // cnt => cumulative count of those numbers that occurred in both arrays
        
        for(int i=0; i < n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if(map.get(A[i]) == 2) {
                cnt++;
            }

            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            if(map.get(B[i]) == 2) {
                cnt++;
            }

            result[i] = cnt;
        }

        return result;
    }

}


/*
// Approach-1 (Brute Force)
// T.C : O(n^3)
// S.C : O(1)

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int x = 0; x <= i; x++) {
                for(int y = 0; y <= i; y++) {
                    if(B[y] == A[x]) {
                        count++;
                        break;
                    }
                }
            }

            result[i] = count;
        }

        return result;
    }

// Approach-2 (Better Approach)
// T.C : O(n^2)
// S.C : O(n)

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        boolean[] isPresentA = new boolean[n+1];
        boolean[] isPresentB = new boolean[n+1];

        for(int i = 0; i < n; i++) {
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;

            int count = 0;
            for(int num = 1; num <= n; num++) {
                if(isPresentA[num] == true && isPresentB[num] == true) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
*/

