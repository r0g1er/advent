package days.Four;

import static java.lang.System.exit;

public class Four {

    public static void main(String[] args) {

        int MINVALUE = 240298;
        int MAXVALUE = 784956;
        int found = 0;
//        int digitone = 2;
//        int digitTwo = 4;
//        int digitThree = 4;
//        int digitFour = 4;
//        int digitFive = 4;
//        int digitSix = 4;
        int minimaldigitValue = 2;
        for (int digitone=2; digitone < 10; digitone++) {
            for (int digitTwo =0; digitTwo < 10; digitTwo++) {
                for (int digitThree=0; digitThree < 10; digitThree++) {
                    for (int digitFour =0; digitFour < 10; digitFour++) {
                        for (int digitFive =0; digitFive < 10; digitFive++) {
                            for (int digitSix =0; digitSix < 10; digitSix++) {


                                if (ValueCalcualtor(digitone, digitTwo, digitThree, digitFour, digitFive, digitSix) > MINVALUE) {


                                    if (checkForAtLeastOneEquel(digitone, digitTwo, digitThree, digitFour, digitFive, digitSix) &&
                                            checkIncreasingValues(digitone, digitTwo, digitThree, digitFour, digitFive, digitSix)) {

                                        found++;
                                    }
                                }
                                if (ValueCalcualtor(digitone, digitTwo, digitThree, digitFour, digitFive, digitSix) >= MAXVALUE) {
                                    System.out.println(found);
                                    exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }




    static boolean checkForAtLeastOneEquel(int een, int twee, int drie, int vier, int vijf, int zes) {
        if (een == twee ||
                twee == drie ||
                drie == vier ||
                vier == vijf ||
                vijf == zes)
        {
            if ((een == twee && twee !=drie)||
                    (twee == drie && drie!= vier && twee != een)||
                    (drie == vier && drie !=twee && vier != vijf)||
                    (vier == vijf && vier != drie && vijf != zes)||
                    (vijf == zes && vijf != vier)){return true;}
        }

                return  false;
    }


    static boolean checkIncreasingValues(int een, int twee, int drie, int vier, int vijf, int zes) {
        return (een <= twee &&
                twee <= drie &&
                drie <= vier &&
                vier <= vijf &&
                vijf <= zes);
    }


    static int ValueCalcualtor(int een, int twee, int drie, int vier, int vijf, int zes) {


          int x =(      100000 * een +
                        10000 * twee +
                        1000 * drie +
                        100 * vier +
                        10 * vijf +
                        zes);
//        System.out.println(x);
        return x;
    }

    //it is not 1675
}
