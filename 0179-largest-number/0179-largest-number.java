class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        String[] s = new String[n];
        for(int i=0; i < n; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(s, (a, b) -> (b+a).compareTo(a+b));
         
        StringBuilder sb = new StringBuilder();
        for(String str : s) {
            sb.append(str);
        }
        
        String result = sb.toString();
        
        return result.startsWith("0") ? "0" : result;
    }
    
}


/*   
//Leetcode Version
//T.C : O(nlogn)
//S.C : O(1) (I am ignoring the space taken by result of size n which we have to return

public class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsAsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsAsInteger, (a, b) -> {
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2 + s1).compareTo(s1 + s2);
        });

        if (numsAsInteger[0] == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int num : numsAsInteger) {
            result.append(num);
        }

        return result.toString();
    }
}
*/

