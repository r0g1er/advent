package days.day03;

import common.ImprovedArrayCreator;

public class PartOne {
    public void run() {
        ImprovedArrayCreator creator = new ImprovedArrayCreator();
        String[] startArray = creator.createFromFileSplitByLine("src/main/java/days/day03/input", ",");
        int size = 31;
        int x = 0;

        int rechts = 3;
        int omlaag = 1;
        int countFreeSpot = 0;
        int countTreeSpot = 0;
        for (int y = 0; y < startArray.length; y = y + omlaag) {
            String regel = startArray[y];
            if (regel.charAt(x) == '.') {
                countFreeSpot++;
            } else if (regel.charAt(x) == '#') {
                countTreeSpot++;
            } else {
                throw new RuntimeException("Encountered Weird Object");
            }
            x = x + rechts;
            if (x >= size) {
                x = x - size;
            }


        }
        System.out.println("Encountered trees " +countTreeSpot);
        System.out.println("Safe spots " + countFreeSpot);
    }
}