package days.Eight;

import days.Three.ArrayCreator;

/**
 * @noinspection Duplicates
 */
public class Eifht_PartTwo {
    static int imageWidth = 25;
    static int imageHight = 6;

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/Eight/input", "");

        int amountOfPixels = startArray.length;
        int amountOflayaers = amountOfPixels / (imageWidth * imageHight);
        System.out.println(amountOflayaers);
        System.out.println(amountOfPixels % (imageWidth * imageHight));
        int[][] tussenstand = new int[imageHight][imageWidth];
        for (int teller = 0; teller < imageHight; teller++) {
            for (int counterr = 0; counterr < imageWidth; counterr++) {
                tussenstand[teller][counterr] = 2;
            }
        }
int pixelounter=0;

        for (int i = 0; i < amountOflayaers; i++) {

            for (int j = 0; j < (imageHight); j++) {

                for (int k = 0; k < (imageWidth); k++) {

                    if (tussenstand[j][k] == 2) {
                        tussenstand[j][k] = startArray[pixelounter];
                    }
                    pixelounter++;
                }// end of k loop
            }// end if j loop

        } // end of i loop

        System.out.println("uitslag");
        for (int teller = 0; teller < imageHight; teller++) {
            System.out.println("");
            for (int counterr = 0; counterr < imageWidth; counterr++) {
                if (tussenstand[teller][counterr]==1){
                    System.out.print("8");
                }
                else System.out.print(" ");
//                System.out.print(tussenstand[teller][counterr]);
            }
        }



    }
}
