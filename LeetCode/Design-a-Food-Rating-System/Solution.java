class FoodRatings {
    // maps
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, PriorityQueue<Food>> cuisineToPQ;

    // Food class
    private static class Food {
        String name;
        int rating;
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToPQ = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToPQ.putIfAbsent(cuisine, new PriorityQueue<>(
                (a, b) -> {
                    if (b.rating != a.rating) return b.rating - a.rating; // high rating first
                    return a.name.compareTo(b.name); // lexicographically smaller first
                }
            ));

            cuisineToPQ.get(cuisine).offer(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        // push new Food into the PQ (lazy removal)
        cuisineToPQ.get(cuisine).offer(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToPQ.get(cuisine);
        // lazy removal of outdated entries
        while (!pq.isEmpty()) {
            Food top = pq.peek();
            int currentRating = foodToRating.get(top.name);
            if (top.rating == currentRating) {
                return top.name;
            } else {
                pq.poll(); // outdated entry
            }
        }
        return null; // should never happen
    }
}