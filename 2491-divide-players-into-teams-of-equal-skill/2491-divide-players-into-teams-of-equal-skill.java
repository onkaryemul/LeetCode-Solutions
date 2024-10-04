class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Using sorting
    // Using lowest + highest = SUM % noOfTeams
    // secondLowest + secondHighest = SUM % noOfTeams,  where noOfTeams = n/2
    
    
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        
        // Sort the skill array
        Arrays.sort(skill);
        
        int i = 0;
        int j = n-1;
        
        int s = skill[i] + skill[j]; // lowest + highest => target sum for each team
        
        // Chemistry of a team => product of the skills of the players on that team
        long chem = 0; // hold the sum of the chemistry of all the teams
        
        // Check each pair from both ends of the sorted array
        while(i < j) {
            int currSkill = skill[i] + skill[j];
            
            // If current pair sum is not equal to expected sum(s), return -1
            if(currSkill != s) {
                return -1; // indicating that there is "no way to divide the players into teams" such that the total skill of each team is equal
            }
            
            // Calculate the chemistry of current pair & add it to the chem & move to the next pair
            chem += (long)skill[i] * (long)skill[j];
            
            i++;
            j--;
        }
        
        return chem; // return the sum of the chemistry of all the teams
    }
    
}


/*     
// Approach-2 (Using frequency of skills similar to counting sort)
// T.C : O(n)
// S.C : O(1000) ~= O(1)


    public long dividePlayers(int[] skill) {
        int n = skill.length;

        // Frequency array to keep track of skill counts
        int[] freq = new int[1001];
        int SUM = 0;

        // Calculate the sum and update the frequency array
        for (int s : skill) {
            SUM += s;
            freq[s]++;
        }

        int teams = n / 2;

        // If the total sum cannot be divided evenly into teams, return -1
        if (SUM % teams != 0) {
            return -1;
        }

        int target = SUM / teams;
        long chem = 0;

        // Traverse through the skill array
        for (int currSkill : skill) {
            int remainSkill = target - currSkill;

            // If the remaining skill is not present in the frequency map, return -1
            if (freq[currSkill] <= 0) {
                continue;  // Skip if already used
            }
            if (remainSkill < 0 || remainSkill > 1000 || freq[remainSkill] <= 0) {
                return -1;
            }

            // Calculate the chemistry and update the frequency array
            chem += (long) currSkill * (long) remainSkill;
            freq[currSkill]--;
            freq[remainSkill]--;
        }

        return chem / 2;
    }
*/

