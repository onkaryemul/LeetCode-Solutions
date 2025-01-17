class Solution {
    
    // TC : O(n)  ==> 2 pass solution
    // SC : O(n)

    // Simulation => starting with 0 and starting with 1

    // Using XOR property
    // x ^ y = z  ==> original[i] ^ original[i+1] = derived[i]
    
    // (x ^ y) ^ y = z ^ y
    // x = z ^ y
    // therefore, y ^ z = x  ==> original[i+1] ^ derived[i] = original[i]

    // (x ^ y) ^ x = z ^ x
    //  y = z ^ x
    // therefore, x ^ z = y  ==> original[i] ^ derived[i] = original[i+1]

    // So, original[i+1] = original[i] ^ derived[i]

    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        int[] original = new int[n];
        
        // Try starting with original[0] = 0
        original[0] = 0;
        for(int i=0; i < n-1; i++) {
            original[i+1] = original[i] ^ derived[i]; // using XOR property
        }
         
        if((original[n-1] ^ original[0]) == derived[n-1]) {
            return true;
        }
        
        // Let's try with original[0] = 1
        original[0] = 1;
        for(int i=0; i < n-1; i++) {
            original[i+1] = original[i] ^ derived[i]; // using XOR property
        }

        if((original[n-1] ^ original[0]) == derived[n-1]) {
            return true;
        }

        return false;
    }

}


/* 
// Approach-2 (Simple observation of XOR property)
// T.C : O(n) => single pass solution
// S.C : O(1)

/// derived[] = [1, 1, 0]
// can be written as = [a^b, b^c, c^a], considering original[] = [a, b, c]
// therefore, derived[] = [a^b, b^c, c^a] => each element/num of original[] appears twice in derived[] => so, their XOR is 0
// So, it is obvious that if XOR of derived[] = 0, it means that original[] exits
// otherwise, origianl[] does not exists

    public boolean doesValidArrayExist(int[] derived) {
        int XOR = 0;

        for(int x : derived) {
            XOR = (XOR ^ x);
        }

        return XOR == 0;
    }
*/

