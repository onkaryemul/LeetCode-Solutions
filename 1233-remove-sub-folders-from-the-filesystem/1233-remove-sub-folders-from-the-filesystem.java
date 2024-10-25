class Solution {
    
    // TC : O(n*logn + n*L)  
    //     ~ O(n*L * log(n*L)), where L = average length of each word
    // SC : O(1)
    
    // Using Sorting
    // For sorting an array of strings, it take n*L*log(n*L) time complexity, where L = average length of each word
    
    public List<String> removeSubfolders(String[] folder) {
        // 1. Sort the folder[] lexicographically
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        
        // the "first folder can never be a sub-folder" after sorting
        result.add(folder[0]);
        
        int n = folder.length;
        // Iterate through the sorted folders starting from index 1
        for(int i=1; i < n; i++) {
            String currFolder = folder[i];
            
            String lastFolder = result.get(result.size() - 1);
            lastFolder += "/"; // Add '/' to the last folder to check for sub-folder
            
            // Check if the current folder does not start with the last folder, then it is not a sub-folder
            if(!currFolder.startsWith(lastFolder)) {
                result.add(currFolder);
            }
        }
        
        return result;
    }
    
}


/*   
// Approach-1 (Using set and substring find)
// T.C : O(n*L^2)
// S.C : O(n) //You can consider the length of each character as well - O(n*L)

    public List<String> removeSubfolders(String[] folder) {
        // Create a set from the folder array
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();

        // Iterate over each folder in the array
        for (String currFolder : folder) {
            boolean isSubFolder = false;
            String tempFolder = currFolder;

            // Continue until currFolder is empty
            while (!currFolder.isEmpty()) {
                int position = currFolder.lastIndexOf('/');  // Find the last occurrence of '/'
                if (position == -1) break;  // Exit if there are no more '/' characters

                currFolder = currFolder.substring(0, position);  // Get the parent folder

                // Check if the parent folder exists in the set
                if (folderSet.contains(currFolder)) {
                    isSubFolder = true;  // It is a sub-folder
                    break;
                }
            }

            // If it's not a sub-folder, add it to the result list
            if (!isSubFolder) {
                result.add(tempFolder);
            }
        }

        return result;
    }
*/

