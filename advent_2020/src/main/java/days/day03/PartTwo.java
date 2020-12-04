package days.day03;

import common.ImprovedArrayCreator;

import java.math.BigInteger;

public class PartTwo {
    public void run() {
        ImprovedArrayCreator creator = new ImprovedArrayCreator();
        String[] startArray = creator.createFromFileSplitByLine("src/main/java/days/day03/input", ",");


        int first = countTrees(1, 1, startArray);
        int second = countTrees(3, 1, startArray);
        int third = countTrees(5, 1, startArray);
        int fourth = countTrees(7, 1, startArray);
        int fifth = countTrees(1, 2, startArray);

        BigInteger a = BigInteger.valueOf(first);
        BigInteger b = BigInteger.valueOf(second);
        BigInteger c = BigInteger.valueOf(third);
        BigInteger d = BigInteger.valueOf(fourth);
        BigInteger e = BigInteger.valueOf(fifth);

        BigInteger answer = a.multiply(b).multiply(c).multiply(d).multiply(e);
        System.out.println("the answer is");
        System.out.println(answer);


    }

    public int countTrees(int rechts, int omlaag, String[] startArray) {
        int size = 31;
        int x = 0;

        int countFreeSpot = 0;
        int countTreeSpot = 0;
        for (int y = 0; y < startArray.length; y = y + omlaag) {
            String regel = startArray[y];
            if (regel.charAt(x) == '#') {
                countTreeSpot++;
            }

            x = x + rechts;
            if (x >= size) {
                x = x - size;
            }
        }

        return countTreeSpot;

    }
}