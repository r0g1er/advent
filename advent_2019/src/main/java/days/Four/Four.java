package days.Four;

import static java.lang.System.exit;

public class Four {

    public static void main(String[] args) {

        int MINVALUE = 240298;
        int MAXVALUE = 784956;
        int found = 0;


        for (int digitOne=2; digitOne < 10; digitOne++) {
            for (int digitTwo =digitOne; digitTwo < 10; digitTwo++) {
                for (int digitThree=digitTwo; digitThree < 10; digitThree++) {
                    for (int digitFour =digitThree; digitFour < 10; digitFour++) {
                        for (int digitFive =digitFour; digitFive < 10; digitFive++) {
                            for (int digitSix =digitFive; digitSix < 10; digitSix++) {


                                if (ValueCalcualtor(digitOne, digitTwo, digitThree, digitFour, digitFive, digitSix) > MINVALUE) {


                                    if (checkForAtLeastOneEquel(digitOne, digitTwo, digitThree, digitFour, digitFive, digitSix))
                                    //checkforIncreasing digit no longer needed because of the starting values of the digit's
                                    {

                                        found++;
                                    }
                                }
                                if (ValueCalcualtor(digitOne, digitTwo, digitThree, digitFour, digitFive, digitSix) >= MAXVALUE) {
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

// no longer needed, because of the starting values of the digits
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
