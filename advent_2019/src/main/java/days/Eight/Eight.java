package days.Eight;

import days.Three.ArrayCreator;

public class Eight {
    static int imageWidth = 25;
    static int imageHight = 6;

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/Eight/input", "");

        int amountOfPixels = startArray.length;
        int amountOflayaers = amountOfPixels / (imageWidth * imageHight);
        System.out.println(amountOflayaers);
        System.out.println(amountOfPixels % (imageWidth * imageHight));
        int[][] tussenstand = new int[amountOflayaers][3];
        for (int i = 0; i < amountOflayaers; i++) {
            int startPixel = i * (imageWidth * imageHight);
            int zero = 0;
            int one = 0;
            int two = 0;
            for (int j = 0; j < (imageWidth * imageHight); j++) {
                int pixel = startArray[startPixel + j];
                switch (pixel) {
                    case 0: {
                        zero++;
                        break;
                    }
                    case 1: {
                        one++;
                        break;
                    }
                    case 2: {
                        two++;
                        break;
                    }

                } // end of switch

            }// end if j loop
            tussenstand[i][0] = zero;
            tussenstand[i][1] = one;
            tussenstand[i][2] = two;

        } // end of i loop
        int uitslag = 0;
        int kleinste = 1000;
        for (int i = 0; i < tussenstand.length; i++) {
            System.out.println(tussenstand[i][0] + " " + tussenstand[i][1] + " " + tussenstand[i][2]);
            if (tussenstand[i][0] < kleinste) {
                kleinste = tussenstand[i][0];
                uitslag = tussenstand[i][1] * tussenstand[i][2];
            }
        }
        System.out.println(uitslag);
    }
}
