class Solution {

    // TC : O(log(n))
    // SC : O(1)

    // Using Greedy approach + Bit Manipulation
    // Starting from num1 & then forming result

    public int minimizeXor(int num1, int num2) {
        int x = num1;

        int requiredSetBitCount = Integer.bitCount(num2); // O(log(n)) => return the no. of set bits
        int currSetBitCount = Integer.bitCount(x); // O(log(n)) => return the no.of set bits

        // apply greedy approach => to SET or UNSET bit from LSB(least significant bit) 
        int bit = 0; // least significant bit => 0

        if(currSetBitCount < requiredSetBitCount) {
            // Greedily, We need to SET bits from least significant bit 0 => to minimize XOR of x and num1
            while(currSetBitCount < requiredSetBitCount) {
                if(!isSet(x, bit)) {
                    x = setBit(x, bit);
                    currSetBitCount++;
                }
                bit++;
            }
        }
        else if(currSetBitCount > requiredSetBitCount) {
            // Greedily, we need to UNSET bits from least significant bit => to minimize XOR of num1 and x
            while(currSetBitCount > requiredSetBitCount) {
                if(isSet(x, bit)) {
                    x = unsetBit(x, bit);
                    currSetBitCount--;
                }
                bit++;
            }
        }

        return x;
    }
    
    // Helper functions
    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    private int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

}


/*  
// Approach-2 (Directly build result)
// T.C : O(log(n))
// S.C : O(1)

    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

    public boolean isUnSet(int x, int bit) {
        return (x & (1 << bit)) == 0;
    }

    public int minimizeXor(int num1, int num2) {
        int x = 0;

        int requiredSetBitCount = Integer.bitCount(num2);
        
        for(int bit = 31; bit >= 0 && requiredSetBitCount > 0; bit--) {
            if(isSet(num1, bit)) {
                x |= (1 << bit);
                requiredSetBitCount--;
            }
        }

        for(int bit = 0; bit < 32 && requiredSetBitCount > 0; bit++) {
            if(isUnSet(num1, bit)) {
                x |= (1 << bit);
                requiredSetBitCount--;
            }
        }
        
        return x;
    }
*/

