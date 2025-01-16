class Solution {

    // TC : O(m + n)
    // SC : O(n) => due to HashMap

    // Using frequency count & XOR property

    // If an element is occurring EVEN no. of times, then its XOR will be 0
    // If an element is occurring ODD no. of times, then its XOR will be that element itself
    
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // key : num
        // value : its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums1) { // every num in nums1[] is paired with every element of nums2[]
            // therefore, every num is nums1[] is occurring 'n' no. of times (size of nums2[])
            map.put(num, map.getOrDefault(num, 0) + n);
        }

        for(int num : nums2) { // every num in nums2[] is paired with every element of nums1[]
            // therefore, every num in nums2[] is occurring 'm' no. of times (size of nums1[])
            map.put(num, map.getOrDefault(num, 0) + m);
        }

        int result = 0; // bitwise XOR of all integers in nums3
        
        for(int num : map.keySet()) {
            if(map.get(num) % 2 != 0) { // ODD
                result = result ^ num; 
            }
        }

        return result;
    }

}


/*  
// Approach-2 (Using Xor property)
// T.C : O(n)
// S.C : O(1)

    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int XOR = 0;

        if(m % 2 != 0) {
            for(int num : nums2) {
                XOR ^= num;
            }
        }

        if(n % 2 != 0) {
            for(int num : nums1) {
                XOR ^= num;
            }
        }
        return XOR;
    }
*/

