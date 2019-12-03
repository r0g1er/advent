package days.One;

import days.Three.ArrayCreator;

/**
 * @author Rogier
 */
public final class one {
    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/One/inputDayOne", ",");

        int totataal = 0;
        for (int i = 0; i < startArray.length; i++) {
            int input = startArray[i];
            int fuel = startArray[i] / 3 - 2;
            int nextfuel = 0;
            int answer = fuel;

            while (true) {

                if (i == 1) {
                    System.out.println(fuel + "  " + answer);
                }

                nextfuel = fuel / 3 - 2;
                if (nextfuel > 0) {
                    answer = answer + nextfuel;
                    fuel = nextfuel;
                } else {

                    break;
                }


            }
            if (i == 1) {
                System.out.println("fianlly " + fuel + "  " + answer);
            }


            totataal = totataal + answer;

        }
        System.out.println(totataal);

    }

}
