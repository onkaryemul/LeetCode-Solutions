class Solution {
    // TC : O(n)
    // SC : O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        
        int strlength = s.length();
        
        if(strlength <= 10) {
            return result;
        }
        
        Set<String> one = new HashSet<>();
        Set<String> two = new HashSet<>();
        
        for(int i=0; i<=strlength-10; i++) {
            String possibleDNASequence = s.substring(i, i + 10);
            
            if(!one.add(possibleDNASequence)) {
                two.add(possibleDNASequence);
            }
        }
        
        result.addAll(two);
        
        return result;
    }
    
}

