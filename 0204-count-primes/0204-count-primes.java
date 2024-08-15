class Solution {
    
    // TC : O(n*log(logn))
    // SC : O(n)
    
    // Using the concept of "Sieve of Eratosthenes"
    public int countPrimes(int n) {
        // Base case
        if(n < 2) { // if n==0 or n==1, return 0
            return 0;
        }
        
        int[] isPrime = sieveOfEratosthenes(n);
        
        int cnt = 0;
        for(int i=2; i < n; i++) {
            if(isPrime[i] == 1) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    
    // Function to calculate sieve
    private int[] sieveOfEratosthenes(int n) {
        int[] isPrime = new int[n+1];
        
        for(int i=2; i <= n; i++) {
            isPrime[i] = 1; // marking i as a prime
        }
        
        for(int i=2; i*i <= n; i++) {
            // Check if i is a prime
            if(isPrime[i] == 1) { // if yes, then mark all multiples of i as non-prime
                for(int j=i*i; j <= n; j+=i) {
                    isPrime[j] = 0; // marking j as non-prime
                }
            }
        }
        
        return isPrime;
    }
    
}

