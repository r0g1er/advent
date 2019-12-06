package days.Six;

import days.Three.ArrayCreator;
import java.util.ArrayList;
import java.util.List;

public class Six {

    public static void main(String[] args) {
        ArrayCreator ding = new ArrayCreator();

        String[] instap = ding.createFromFile("src/main/java/days/Six/input", ",");
        String[][] kaart = new String[instap.length][2];
        String[][] diepteMap = new String[instap.length + 1][2];
        for (int i = 0; i < instap.length; i++) {
            kaart[i] = instap[i].split("&");
        }


        int gevonden = 0;
        diepteMap[0][0] = "COM";
        diepteMap[0][1] = "0";
        gevonden++;


        for (int i = 0; (i < gevonden && i < kaart.length); i++) {
            String teZoeken = diepteMap[i][0];
            int level = Integer.parseInt(diepteMap[i][1]) + 1;

            for (int j = 0; j < kaart.length; j++) {
                if (kaart[j][0].equals(teZoeken)) {
                    diepteMap[gevonden][0] = kaart[j][1];
                    diepteMap[gevonden][1] = Integer.toString(level);
                    gevonden++;
                }
            }
        }


        int totaal = 0;
        for (int i = 0; i < diepteMap.length; i++) {
            totaal = totaal + Integer.parseInt(diepteMap[i][1]);
        }
        System.out.println(totaal);


        boolean zoekenwenog = true;
        String nuZoekenWeDit = "YOU";
        List <String> youList =new ArrayList();
        while (zoekenwenog) {
            for (int i = 0; i < kaart.length; i++) {
                if (nuZoekenWeDit.equals(kaart[i][1])) {

                    nuZoekenWeDit = kaart[i][0];
                    youList.add(nuZoekenWeDit);
                    if (nuZoekenWeDit.equals("COM")) {
                        zoekenwenog = false;
                    }
                }
            }
        }


        zoekenwenog = true;
        nuZoekenWeDit = "SAN";
        List <String> sanList =new ArrayList();
        while (zoekenwenog) {
            for (int i = 0; i < kaart.length; i++) {
                if (nuZoekenWeDit.equals(kaart[i][1])) {
                    nuZoekenWeDit = kaart[i][0];
                    sanList.add(nuZoekenWeDit);
                    if (nuZoekenWeDit.equals("COM")) {
                        zoekenwenog = false;
                    }
                }
            }
        }


        for (int i=0; i<youList.size() && i< sanList.size(); i++){
            if (youList.get(youList.size()-i-1).equals(sanList.get(sanList.size()-i-1))){
            }     else {
                int anser= (sanList.size()  -i + (youList.size() -i));
                System.out.println(anser);
                break;
            }
        }


//        answer = 247089
    }
}
