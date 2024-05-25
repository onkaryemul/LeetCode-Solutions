class Solution {
    
    private Map<String, List<String>> memoryMap = new HashMap<>();
    
    // Memoization Approach
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        
        // Base case
        if(s==null || s.length()==0) {
            return result;
        }
        
        // Memoize the previous/stored result
        if(memoryMap.containsKey(s)) {
            return memoryMap.get(s);
        }
        
        if(wordDict.contains(s)) {
            result.add(s);
        }
        
        for(int i=1; i < s.length(); i++) {
            String curr = s.substring(i);
            
            if(wordDict.contains(curr)) {
                List<String> tempList = wordBreak(s.substring(0, i), wordDict);
                if(!tempList.isEmpty()) {
                    for(String str : tempList) {
                        result.add(str + " " + curr);
                    }
                }
            }
        }
        
        memoryMap.put(s, result);
        
        return result;
    }
    
}

