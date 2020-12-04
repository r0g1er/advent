package days.day01;

import common.ArrayCreator;

import java.math.BigInteger;

public class DayOne {

    public static void main(String args[]) {
        partTOne();
        partTwo();
    }

    public static void partTOne() {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/day01/input", ",");

        for (int i = 0; i < startArray.length; i++) {
            for (int j = i + 1; j < startArray.length; j++) {
                if (startArray[i] + startArray[j] == 2020) {
                    System.out.println("gevonden");
                    System.out.println("i" + startArray[i]);
                    System.out.println("j" + startArray[j]);
                    System.out.println(startArray[i] * startArray[j]);
                }
            }
        }


    }

    public static void partTwo() {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/day01/input", ",");

        for (int i = 0; i < startArray.length; i++) {
            for (int j = i + 1; j < startArray.length; j++) {
                for (int k = j + 1; k < startArray.length; k++) {
                    if (startArray[i] + startArray[j] + startArray[k] == 2020) {
                        BigInteger a = new BigInteger( Integer.toString( startArray[i]));
                        BigInteger b = new BigInteger( Integer.toString( startArray[j]));
                        BigInteger c = new BigInteger( Integer.toString( startArray[k]));
                        System.out.println("gevonden");
                        System.out.println("i" + startArray[i]);
                        System.out.println("j" + startArray[j]);
                        System.out.println("k" + startArray[k]);
                        BigInteger answer= a.multiply(b).multiply(c);
                        System.out.println(answer);
                    }
                }
            }

        }

    }
}
