class Solution {
    
    // TC: O(n), where n => no of elements in the version part
    // SC: O(n)
    
    public int compareVersion(String version1, String version2) {
        // Note: You can't directly use str.split(".") because if will treat the regex as any character
        String[] version1List = version1.split("\\.");
        String[] version2List = version2.split("\\.");
        
        int s1 = 0;
        int s2 = 0;
        
        int len1 = version1List.length;
        int len2 = version2List.length;
        
        while(s1<len1 && s2<len2) {
            int val1 = Integer.parseInt(version1List[s1]);
            int val2 = Integer.parseInt(version2List[s2]);
            
            if(val1 > val2) {
                return 1;
            }
            else if (val1 < val2) {
                return -1;
            }
            else {
                // continue;
            }
            
            s1++;
            s2++;
        }
        
        while(s1<len1) {
            int val1 = Integer.parseInt(version1List[s1]);
            if(val1 > 0) {
                return 1;
            }
            s1++;
        }
        
        while(s2<len2) {
            int val2 = Integer.parseInt(version2List[s2]);
            if(val2 > 0) {
                return -1;
            }
            s2++;
        }
        
        return 0;
    }
    
}

