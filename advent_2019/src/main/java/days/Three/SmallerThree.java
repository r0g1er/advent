package days.Three;

import com.google.common.collect.Table;
import java.time.Instant;
/**
 * Version two of day three. Only to complete the first part of the daily challenge.
 */

public class SmallerThree {
    static final int OORSPRONG = 0;
    static Table<Integer, Integer, Integer> tekenTabel;

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        String[] wireOne = creator.createFromFile("src/main/java/days/Three/inputOne", ",");
        String[] wireTwo = creator.createFromFile("src/main/java/days/Three/inputTwo",",");
        TableDrawer drawer = new TableDrawer();
        tekenTabel = drawer.create(wireOne);



        int tussenstand = Integer.MAX_VALUE;
        int x = OORSPRONG;
        int y = OORSPRONG;
        for (int i = 0; i < wireTwo.length; i++) {
            String letter = wireTwo[i].substring(0, 1);
            String getal = wireTwo[i].substring(1);
            int beweging = Integer.parseInt(getal);

            if (letter.equals("R")) {
                for (int j = 0; j < beweging; j++) {
                    x++;
                    tussenstand = checkTable(x, y, tussenstand);
                }

            } else if (letter.equals("L")) {
                for (int j = 0; j < beweging; j++) {
                    x--;
                    tussenstand = checkTable(x, y, tussenstand);
                }

            } else if (letter.equals("U")) {
                for (int j = 0; j < beweging; j++) {
                    y++;
                    tussenstand = checkTable(x, y, tussenstand);
                }
            } else if (letter.equals("D")) {
                for (int j = 0; j < beweging; j++) {
                    y--;
                    tussenstand = checkTable(x, y, tussenstand);
                }
            } else {
                System.out.println("fail. Verkeerde letter");
            }
        }
//        answer should be 1064
        System.out.println(tussenstand);
        System.out.println(Instant.now());
    }

    static int checkTable(int x, int y, int tussenstand) {
        int wat;
        if (tekenTabel.contains(x, y)) {
            wat = tekenTabel.get(x, y);
            int nieuweWaarde = Math.abs(y) + Math.abs(x);
            if (wat != 0 && nieuweWaarde < tussenstand) {
                tussenstand = nieuweWaarde;
            }
        }
        return tussenstand;
    }

    static void writeArray(int x, int y) {
        if (x != OORSPRONG || y != OORSPRONG) {
            tekenTabel.put(x, y, 1);
        }
    }
}
