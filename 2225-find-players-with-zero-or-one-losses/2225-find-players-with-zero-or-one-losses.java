class Solution {
    
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        
        Map<Integer, Integer> losers = new HashMap<>();
        for(int[] match : matches) {
            int currLoser = match[1];
            losers.put(currLoser, losers.getOrDefault(currLoser, 0) + 1);
        }
            
        
        for(int[] match : matches) {
            int currWinner = match[0];
            
            if(!losers.containsKey(currWinner)) {
                winners.add(currWinner);
            }
        }
        
        List<Integer> winnersList = new ArrayList<>(winners);
        List<Integer> losersList = new ArrayList<>();
        
        for(int loser : losers.keySet()) {
            if(losers.get(loser) == 1) {
                losersList.add(loser);
            }
        }
        
        
        Collections.sort(winnersList);
        Collections.sort(losersList);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(winnersList);
        result.add(losersList);
        
        return result;
    }
    
}


