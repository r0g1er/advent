package days.Three;

import com.google.common.collect.Table;
import java.util.Set;

/**
 * Version three of day three.
 * can be used to complete both of the daily challenges
 * calculates the  manhattan distance from the origin to nearest intersection and
 * calculates the shortest distance traveled if
 */
public class MoreOfThree {
    static Table<Integer, Integer, Integer> tekenTabel;
    static Table<Integer, Integer, Integer> tekenTabel2;

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        String[] wireOne = creator.createFromFile("src/main/java/days/Three/inputOne");
        String[] wireTwo = creator.createFromFile("src/main/java/days/Three/inputTwo");
        TableDrawer drawer = new TableDrawer();
        tekenTabel = drawer.create(wireOne);
        tekenTabel2 = drawer.create(wireTwo);

        int combinedDistance = Integer.MAX_VALUE;
        int shortestManhattahnDistance = Integer.MAX_VALUE;
        Set<Integer> rijen = tekenTabel.rowKeySet();


        for (Integer getal : rijen) {
            Set<Integer> colommen = tekenTabel.row(getal).keySet();
            for (Integer tweedeGetal : colommen) {
                if (tekenTabel2.contains(getal, tweedeGetal)) {
                    int value = Math.abs(tekenTabel.get(getal, tweedeGetal)) +
                            Math.abs(tekenTabel2.get(getal, tweedeGetal));
                    int tempshortestManahantne= Math.abs(getal)+Math.abs(tweedeGetal);

                    if (value < combinedDistance) {
                        combinedDistance = value;
                    }
                    if (tempshortestManahantne < shortestManhattahnDistance) {
                        shortestManhattahnDistance = tempshortestManahantne;
                    }

                }
            }
        }
        System.out.println("Shortest combined Path = " + combinedDistance);
        System.out.println("Nearest Manhattan distance = "+ shortestManhattahnDistance);
    }

}
