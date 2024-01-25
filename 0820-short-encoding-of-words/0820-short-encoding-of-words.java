class Solution {
    
    public int minimumLengthEncoding(String[] words) {
        // Sort the words array
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        
        List<String> encodingsList = new ArrayList<>();
        encodingsList.add(words[0]);
        
        int length = words[0].length();
        
        
        for(int i=1; i<words.length; i++) {
            boolean suffixFound = false;
            
            for(String encoding : encodingsList) {
                if(encoding.endsWith(words[i])) {
                    suffixFound = true;
                    break;
                }    
            }
            
            if(!suffixFound) {
                encodingsList.add(words[i]);
                length += words[i].length();
            }
        }
        
        
        return length + encodingsList.size();
    }
    
}

