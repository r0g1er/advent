package days.Six;

import days.Three.ArrayCreator;

public class Six {

    public static void main(String[] args) {
        ArrayCreator ding = new ArrayCreator();

        String[] instap = ding.createFromFile("src/main/java/days/Six/input", ",");
        String[][] kaart = new String[instap.length][2];
        String[][] diepteMap = new String[instap.length+1][2];
        for (int i = 0; i < instap.length; i++) {
            kaart[i] = instap[i].split("&");
        }



        int gevonden = 0;
        diepteMap[0][0] = "COM";
        diepteMap[0][1] = "0";
        gevonden++;


        for (int i = 0; (i < gevonden && i<kaart.length); i++) {
            String teZoeken = diepteMap[i][0];
            int level = Integer.parseInt(diepteMap[i][1]) + 1;

            for (int j = 0; j < kaart.length; j++){
                if(kaart[j][0].equals(teZoeken)){
                    diepteMap[gevonden][0]=kaart[j][1];
                    diepteMap[gevonden][1]= Integer.toString(level);
                    gevonden++;
                }
            }
        }

        for (int i = 0; i < diepteMap.length; i++) {
            System.out.print(diepteMap[i][0]);
            System.out.print("      ");
            System.out.println(diepteMap[i][1]);


        }




        int totaal=0;
        for (int i = 0; i < diepteMap.length; i++) {
            System.out.println(diepteMap[i][0]+ "   "+ diepteMap[i][1]);
        totaal =totaal + Integer.parseInt(diepteMap[i][1]);
        }
        System.out.println(totaal);

//        answer = 247089
    }
}
