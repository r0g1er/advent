package days.Six;

import days.Three.ArrayCreator;

public class Six {

    public static void main(String[] args) {
        ArrayCreator ding = new ArrayCreator();

        String[] instap = ding.createFromFile("src/main/java/days/Six/input", ",");
        String[][] kaart = new String[instap.length][2];
        String[][] diepteMap = new String[instap.length][2];
        for (int i = 0; i < instap.length; i++) {
            kaart[i] = instap[i].split("&");
        }

//        for (int i = 0; i < kaart.length; i++) {
//
//            System.out.print(kaart[i][0] + "    ");
//            System.out.println(kaart[i][1]);
//        }


        String center = "COM";
        int level = 0;
        int gevonden = 1;
        diepteMap[0][0] = "COM";
        diepteMap[0][1] = "0";
        int verwerkt = 0;
        for (int j = 0; gevonden <= kaart.length; j++) {
            for (int i = 0; i < kaart.length; i++) {
//                System.out.println(i);
//                System.out.println(kaart[i][0]);
//                System.out.println(center);
                if (center.equals(kaart[i][0])) {
                    String plek0=kaart[i][1];
                    diepteMap[gevonden][0] = plek0;
                    diepteMap[gevonden][1] = Integer.toString(level);
                    gevonden++;

                    if (gevonden >= kaart.length) {
                        System.out.println("lengte beriekt");
                        break;
                    }
                }

                center = diepteMap[verwerkt] [0];

                level = Integer.parseInt(diepteMap[verwerkt][1]) + 1;

            }
            if (gevonden >= kaart.length) {
                System.out.println("lengte beriekt");
                break;
            }
            System.out.println(diepteMap[verwerkt][0]);
            System.out.println(diepteMap[verwerkt][1]);
            verwerkt++;
        }
        int totaal=0;
        for (int i = 0; i < diepteMap.length; i++) {
            System.out.println(diepteMap[i][0]+ "   "+ diepteMap[i][1]);
        totaal =totaal + Integer.parseInt(diepteMap[i][1]);
        }
        System.out.println(totaal);

//246796 is too low
    }
}
