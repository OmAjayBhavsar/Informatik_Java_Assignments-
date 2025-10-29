public class Food implements Comparable<Food> {

    private static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};
    String type;
    int calories;

    public Food(String type, int calories) {
        for (String s : TYPES) {
            try {
                if (type.equals(s)) {
                    this.type = s;
                    this.calories = calories;
                }
            } catch (Exception exception) {
                System.err.println("Type not found!");
            }
        }
    }

    public String toString() {
        return "Type: " + type + ", Calories: " + calories;
    }

    public int compareTo(Food o) {
        int food = getType().length() * getCalories();
        int food2 = o.getType().length() * o.getCalories();
        return Integer.compare(food, food2);
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public static Food[] createSortedRandomList(int n) {
        Food[] food = new Food[n];
        for (int i = 0; i < food.length; i++) {
            food[i] = new Food(TYPES[(int) (4.0 * Math.random())], (int) (60 * Math.random())); // random type form TYPE and random calories b/w 0-59
        }
        java.util.Arrays.sort(food);
        return food;
    }

    public static void main(String[] args) {
        Food apple = new Food("Apple", 50);
        Food grape = new Food("Grape", 60);


        int comparisonAppleWithGrape = apple.compareTo(grape);
        System.out.println(apple);
        System.out.println("Type: " + apple.getType());
        System.out.println("Comparison of Apple with Grape: " + comparisonAppleWithGrape);
        System.out.println("Calories: " + apple.getCalories());
        System.out.println("\n");


        int comparisonGrapeWithApple = grape.compareTo(apple);
        System.out.println(apple);
        System.out.println("Type: " + grape.getType());
        System.out.println("Comparison of Grape with Apple: " + comparisonGrapeWithApple);
        System.out.println("Calories: " + grape.getCalories());
        System.out.println("\n");

        Food[] array = createSortedRandomList(5);
        for (Food food : array) System.out.println(food);


    }

}