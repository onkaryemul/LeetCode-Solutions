class Solution {
    
    // TC : O(n*logn), due to custom sorting
    // SC : O(n)
    
    // Using lambda
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to store the index of each element in arr2
        Map<Integer, Integer> map = new HashMap<>();
        // <element, index>
        for(int i=0; i < arr2.length; i++) {
            map.put(arr2[i], i); // since each element in arr2 is unique
        }
        
        // Mark elements in arr1 that are not in arr2 with a large number value (to be sorted at the end)
        int largeValue = 1000000000; 
        
        for(int i=0; i < arr1.length; i++) {
            if(!map.containsKey(arr1[i])) {
                map.put(arr1[i], largeValue);
            }
        }
        
        // Convert arr1 into list for sorting
        List<Integer> arr1List = new ArrayList<>();
        
        for(int num : arr1) {
            arr1List.add(num);
        }
        
        // Sort the list using the custom defined comparator (using lamba expression)
        Comparator<Integer> comparator = (num1, num2) -> {
            int index1 = map.get(num1);
            int index2 = map.get(num2);
            
            if(index1 == index2) {
                return Integer.compare(num1, num2);
            }
            
            return Integer.compare(index1, index2);
        };
        
        Collections.sort(arr1List, comparator);
        
        // Convert the sorted list back to an array
        int[] sortedArray = new int[arr1.length];
        for(int i=0; i < arr1.length; i++) {
            sortedArray[i] = arr1List.get(i);
        }
        
        return sortedArray;
    }
     
}


/*   
// Using counting sort
// T.C : O(nlogn)
// S.C : O(n)

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to count the occurrences of each number in arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Create a list to store the result
        List<Integer> result = new ArrayList<>();

        // Add elements of arr2 to the result list in the order and number of times they appear in arr1
        for (int num : arr2) {
            if (countMap.containsKey(num)) {
                for (int i = 0; i < countMap.get(num); i++) {
                    result.add(num);
                }
                // Remove the element from the map after adding to result list
                countMap.remove(num);
            }
        }

        // Add the remaining elements from arr1 (those not in arr2) in ascending order
        List<Integer> remaining = new ArrayList<>();
        for (int num : countMap.keySet()) {
            for (int i = 0; i < countMap.get(num); i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);
        result.addAll(remaining);

        // Convert the result list to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}

*/

