class Pair {
    int score;
    int index;
    
    public Pair() {
        this.score = 0;
        this.index = 0;
    }
    
    public Pair(int score, int index) {
        this.score = score;
        this.index = index;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public int getIndex() {
        return this.index;
    }
}


// Solution code
class Solution {
    
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        
        String[] result = new String[n];
        
        Pair[] pairs = new Pair[n];
        for(int i=0; i < n; i++) {
            pairs[i] = new Pair(score[i], i);
        }
        
        // Sort the pairs based on score
        Arrays.sort(pairs, (a, b) -> Integer.compare(b.getScore(), a.getScore()));
        
        for(int i=0; i < n; i++) {
            if(i == 0) {
                result[pairs[i].getIndex()] = "Gold Medal";
            }
            else if (i == 1) {
                result[pairs[i].getIndex()] = "Silver Medal";
            }
            else if (i == 2) {
                result[pairs[i].getIndex()] = "Bronze Medal";
            }
            else {
                result[pairs[i].getIndex()] = Integer.toString(i+1);
            }
        }
        
        return result;
    }
    
}

