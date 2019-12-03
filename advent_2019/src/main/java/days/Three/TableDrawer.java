package days.Three;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @author Rogier
 */
public final class TableDrawer {
    static final int OORSPRONG = 0;

    public Table<Integer, Integer, Integer> create(String[] input) {
        Table<Integer, Integer, Integer> tekenTabel = HashBasedTable.create();
        int x = 0;
        int y = 0;
        int count = 1;
        for (String s : input) {
            String letter = s.substring(0, 1);
            String getal = s.substring(1);

            int beweging = Integer.parseInt(getal);
            switch (letter) {
                case "R": {
                    for (int j = 0; j < beweging; j++) {
                        x++;
                        count = writeArray(x, y, count, tekenTabel);
                    }
                    break;
                }
                case "L": {
                    for (int j = 0; j < beweging; j++) {
                        x--;
                        count = writeArray(x, y, count, tekenTabel);
                    }
                    break;
                }
                case "U": {
                    for (int j = 0; j < beweging; j++) {
                        y++;
                        count = writeArray(x, y, count, tekenTabel);
                    }
                    break;
                }
                case "D": {
                    for (int j = 0; j < beweging; j++) {
                        y--;
                        count = writeArray(x, y, count, tekenTabel);
                    }
                    break;
                }
                default: {
                    System.out.println("fail. Verkeerde letter");
                }
            }
        }

        return tekenTabel;
    }

    static int writeArray(int x, int y, int teller, Table<Integer, Integer, Integer> tekenTabel) {
        if (x != OORSPRONG || y != OORSPRONG) {
            tekenTabel.put(x, y, teller);
        }
        teller++;
        return teller;
    }
}
