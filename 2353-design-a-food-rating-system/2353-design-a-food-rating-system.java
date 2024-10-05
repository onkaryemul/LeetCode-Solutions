/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */


class FoodRatings {

    // TC : 
    //  1. FoodRatings() => O(n)
    //  2. changeRating() => logn, due to remove operation in TreeSet
    //  3. highestRated() => O(1)
    
    // SC : O(n) in all maps
    
    
    // Using Maps/set as per requirement
    
    private Map<String, Integer> foodRating;
    private Map<String, String> foodCuisine;
    private Map<String, TreeSet<Pair<Integer, String>>> cuisineRatingFood;
    
    
    // Construtor to initialize the FoodRatings class object
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineRatingFood = new HashMap<>();
        
        int n = foods.length; // n = cuisines.length or n = ratings.length
        
        for(int i=0; i < n; i++) {
            foodRating.put(foods[i], ratings[i]);
            
            foodCuisine.put(foods[i], cuisines[i]);
            
            if(!cuisineRatingFood.containsKey(cuisines[i])) {
                cuisineRatingFood.put(cuisines[i], new TreeSet<>((a, b) -> {
                    int compareByRating = Integer.compare(a.getKey(), b.getKey());
                    if(compareByRating == 0) {
                        return a.getValue().compareTo(b.getValue());
                    }
                    return compareByRating;
                }));
            }
            
            cuisineRatingFood.get(cuisines[i]).add(new Pair(-ratings[i], foods[i]));
        }
    }
    
    
    public void changeRating(String food, int newRating) {
        String cuisineName = foodCuisine.get(food);
        
        TreeSet<Pair<Integer, String>> cuisineSet = cuisineRatingFood.get(cuisineName);
        
        Pair<Integer, String> oldElement = new Pair<>(-foodRating.get(food), food);
        
        cuisineSet.remove(oldElement);
        
        foodRating.put(food, newRating);
        cuisineSet.add(new Pair<>(-newRating, food));
    }
    
    
    public String highestRated(String cuisine) {
        Pair<Integer, String> highestRated = cuisineRatingFood.get(cuisine).first();
        
        return highestRated.getValue();
    }
    
}

