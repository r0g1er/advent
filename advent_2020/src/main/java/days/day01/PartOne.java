package days.day01;

import common.ImprovedArrayCreator;

public class PartOne {

    public int run() {
        System.out.println("go");
        ImprovedArrayCreator creator = new ImprovedArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/day01/original", ",");
        return calculate(startArray, 2020);
    }

    private int calculate(int[] sameArray, int neededValue) {
        for (int i = 0; i < sameArray.length; i++) {
            for (int j = i + 1; j < sameArray.length; j++) {
                if (sameArray[i] + sameArray[j] == neededValue) {
                    return sameArray[i] * sameArray[j];
                }
            }
        }
        throw new RuntimeException("No Solution found");
    }
}
