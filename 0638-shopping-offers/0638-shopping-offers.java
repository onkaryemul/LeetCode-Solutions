class Solution {
    
    // Main algorithm code --> Return the lowest price you have to pay for exactly certain items as given
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return calculateMinCost(price, special, needs, new HashMap<>());
    }
    
    
    // recursive function -> DP and Backtracking
    private int calculateMinCost(List<Integer> price, List<List<Integer>> specials, List<Integer> needs, Map<List<Integer>, Integer> dp) {
        
        // Memoization
        if(dp.containsKey(needs)) {
            return dp.get(needs);
        }
        
        // Calculate direct cost that you can pay
        int cost = calculateCost(price, needs);
        
        // Calculate cost that you can pay using specials
        for(List<Integer> special : specials) {
            // check if special offer is applicable for our current needs
            if(isSpecialApplicable(special, needs)) {
                List<Integer> updatedNeeds = new ArrayList<>(needs);
                
                int n = needs.size();
                
                for(int i=0; i<n; i++) {
                    updatedNeeds.set(i, needs.get(i) - special.get(i));
                }
                
                int offerCost = special.get(special.size()-1);
                
                cost = Math.min(cost, offerCost + calculateMinCost(price, specials, updatedNeeds, dp));
            }
        }
        
        
        dp.put(needs, cost); // storing min-cost to pay for particular need
        
        return cost;
    }
    
    
    // function to calculate direct cost to pay for the needs
    private int calculateCost(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        int n = needs.size();
        for(int i=0; i<n; i++) {
            cost += (needs.get(i) * price.get(i));
        }
        return cost;
    }
    
    
    // Function to check if is special offer applicable on needs
    private boolean isSpecialApplicable(List<Integer> special, List<Integer> needs) {
        int n = needs.size();
        for(int i=0; i<n; i++) {
            if(special.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }
    
}


