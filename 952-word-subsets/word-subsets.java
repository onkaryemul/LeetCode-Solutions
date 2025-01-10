class Solution {
    
    // n = no. of words in words2[] 
    // k = avg. length of word in words2[]
    // m = no. of words in words1[]
    // l = avg. length of word in words1[]

    // TC : O(n * k) + O(m * l)
    // SC : O(26) ~ O(1)

    // Universal string s => if for every string str in words2[], str is subset of a, including multiplicity

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>(); // universal strings in words1 
 
        int[] combinedMaxFreqArray = new int[26]; // max frequency across words2[]

        for(String word : words2) {
            int[] count = new int[26]; // freq count of all characters in current string word 
            
            for(char ch : word.toCharArray()) {
                count[ch-'a']++;
            }
            
            for(int i=0; i < 26; i++) {
                combinedMaxFreqArray[i] = Math.max(combinedMaxFreqArray[i], count[i]);
            }
        }

        // Look for universal string in words1[]
        for(String word : words1) {
            int[] count = new int[26]; // freq of all characters in current string word
            
            for(char ch : word.toCharArray()) {
                count[ch-'a']++;
            }
            
            // Check if current string word is universal string for all string in words2[]
            if(checkSubset(combinedMaxFreqArray, count)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper function
    private boolean checkSubset(int[] combinedMaxFreq, int[] count) {
        for(int i=0; i < 26; i++) {
            if(count[i] < combinedMaxFreq[i]) {
                return false;
            }
        }

        return true;
    }

}

