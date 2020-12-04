package days.day01;

import common.ArrayCreator;

import java.math.BigInteger;

public class PartTwo {
    int[] startArray;

    public BigInteger run() {


        ArrayCreator creator = new ArrayCreator();
        startArray = creator.createIntArrayFromfile("src/main/java/days/day01/input", ",");
        return calculate(2020);

    }


    BigInteger calculate(int neededValue) {

        for (int i = 0; i < startArray.length; i++) {
            for (int j = i + 1; j < startArray.length; j++) {
                for (int k = j + 1; k < startArray.length; k++) {
                    if (startArray[i] + startArray[j] + startArray[k] == neededValue) {
                        BigInteger a = new BigInteger(Integer.toString(startArray[i]));
                        BigInteger b = new BigInteger(Integer.toString(startArray[j]));
                        BigInteger c = new BigInteger(Integer.toString(startArray[k]));
                        return a.multiply(b).multiply(c);
                    }
                }
            }
        }
        throw new RuntimeException("No answer found");
    }

}