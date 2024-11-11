class Solution {
    
    // n = nums.length => max 1000
    // nums[i] => max 1000 => so need to calculate  the sieve of first 1000 numbers
    
    // TC : O(1000*log(log(1000)) + n*1000)
    // SC : O(1000)
     
    // Using the Sieve of Eratosthenes ==> TC : O(n*log(logn))
    // Using Greedy approach ==> store primes & check
    
    private boolean[] isPrime = new boolean[1000];
    
    
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        sieve(); // Populates the isPrime[] with prime indicators
        // isPrime[i] = true  => i is prime no.
        // isPrime[i] = false => i is not a prime no.
        
        // Traverse the nums[] from the second-last element to the start
        // right to left ==> simple to understand => with minimum overhead
        for(int i=n-2; i >= 0; i--) {
            // Check if current element nums[i] is smaller than its next element nums[i+1]
            if(nums[i] < nums[i+1]) {
                continue; // skip it, since it is in its correct increasing order
            }
            
            // Find the largest prime 'p' less than nums[i]
            for(int p=2; p < nums[i]; p++) {
                if(!isPrime[p]) {
                    continue;
                }
                
                if(nums[i] - p < nums[i+1]) {
                    nums[i] = nums[i] - p;
                    break;
                }
            }
            
            // Check if the condition still holds; if not, return falae
            if(nums[i] >= nums[i+1]) {
                return false;
            }
        }
        
        return true;
    }

    
    // Helper function ==> to calculate Sieve of Eratosthenes of first 1000 numbers
    // Sieve of Eratosthenes => to mark prime numbers from 1 to 1000
    private void sieve() {
        // Initialize all values to true
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false; // 0 is not a prime number
        isPrime[1] = false; // 1 is not a prime number
        
        for(int i=2; i*i < 1000; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j < 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }    
    }

}


/*     
    private void sieveOfEratosthenes(List<Integer> primes, int maxVal) {
        boolean[] sieve = new boolean[maxVal + 1];
        Arrays.fill(sieve, true); // Initially mark all as prime
        sieve[0] = sieve[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= maxVal; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= maxVal; j += i) {
                    sieve[j] = false;
                }
            }
        }

        for (int i = 2; i <= maxVal; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
    }

    public boolean primeSubOperation(List<Integer> nums) {
        List<Integer> primes = new ArrayList<>();
        int maxVal = nums.stream().max(Integer::compare).orElse(0);
        sieveOfEratosthenes(primes, maxVal);

        for (int i = 0; i < nums.size(); i++) {
            int diff = (i == 0) ? nums.get(0) - 1 : nums.get(i) - nums.get(i - 1) - 1;
            int lb = lowerBound(primes, diff);

            if (lb == primes.size() || primes.get(lb) > diff) lb--;
            if (lb < 0) {
                if (i == 0 || nums.get(i) > nums.get(i - 1)) continue;
                else return false;
            }
            nums.set(i, nums.get(i) - primes.get(lb));
        }
        return true;
    }

    private int lowerBound(List<Integer> primes, int key) {
        int low = 0, high = primes.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (primes.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
*/

