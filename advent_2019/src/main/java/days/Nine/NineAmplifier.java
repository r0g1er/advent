package days.Nine;

import days.Three.ArrayCreator;
import java.math.BigInteger;
import static java.lang.System.exit;

/**
 * @author Rogier
 */
public final class NineAmplifier {
    static BigInteger[] startArray;
    static int relativeMode = 0;
    static int inputValue = 1;

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();


//        startArray = creator.createIntArrayFromfile("src/main/java/days/Nine/input", ",");

        //tests
//        startArray = new int[]{109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 990,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        startArray = new BigInteger[]{BigInteger.valueOf(104l),BigInteger.valueOf(1125899906842624l),BigInteger.valueOf(99l)};
//        startArray = new int[]{104,55,99};


        int increase = -1000;
        for (BigInteger i = BigInteger.valueOf(0l); i < startArray.length; i += increase) {
            int instructionsOptcode = startArray[i];
            int whatToDo = instructionsOptcode % 100;

//            increase = 4;
            System.out.println("instructionsOptcode is " + instructionsOptcode);
            System.out.println("WhatToDo is " + whatToDo);


            int modeOne = ((instructionsOptcode - whatToDo) % 1000) / 100;
            int modeTwo = ((instructionsOptcode - whatToDo - (modeOne * 100)) % 10000) / 1000;
            int modeThree = ((instructionsOptcode - whatToDo - (modeOne * 100) - (modeTwo * 1000)) % 100000) / 10000;
            System.out.println(modeOne+ " " + modeTwo+ " " + modeThree);

            switch (whatToDo) {

                case 1: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    int valueTwo = calculateValue(two, modeTwo, 2);
                    int valueTree = calculateValue(three, modeThree, 3);
                    System.out.println("adding " + (valueOne + valueTwo) + " on location  " + valueTree);
                    startArray[valueTree] = valueOne + valueTwo;
                    increase = 4;
                    break;
                }

                case 2: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    int valueTwo = calculateValue(two, modeTwo, 2);
                    int valueThree = calculateValue(three, modeThree, 3);
                    System.out.println("multiplying storing " + (valueOne * valueTwo) + " on location " + valueThree);
                    startArray[valueThree] = valueOne * valueTwo;
                    increase = 4;
                    break;
                }
                case 3: {
                    int one = getOne(i);
                    int valueOne = calculateValue(one, modeOne, 3);
                    System.out.println("asks for input");
                    startArray[valueOne] = inputValue;//never writes in imediate mote
                    System.out.println("store 5 on location " + valueOne);
                    increase = 2;

                    break;
                }
                case 4: {
                    int one = getOne(i);
                    int valueOne = calculateValue(one, modeOne, 1);

                    System.out.println("output---------------------------------------------------------");
                    System.out.println(valueOne);
                    increase = 2;
                    break;
                }
                case 5: {
                    //Opcode 5 is jump-if-true: if the first parameter is non-zero, it sets the instruction pointer to the value from the second parameter. Otherwise, it does nothing.
                    int one = getOne(i);
                    int two = getTwo(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    int valueTwo = calculateValue(two, modeTwo, 2);
                    if (valueOne != 0) {
                        i = valueTwo;//denk dat dit hem moet zijn
                        increase = 0;
                    } else {
                        increase = 3;
                    }
                    break;
                }
                case 6: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    int valueTwo = calculateValue(two, modeTwo, 2);
                    if (valueOne == 0) {
                        i = valueTwo;//denk dat dit hem moet zijn
                        increase = 0;
                    } else {
                        increase = 3;
                    }

                    break;
                }
                case 7: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    int valueTwo = calculateValue(two, modeTwo, 2);
                    int valueThree = calculateValue(three, modeThree, 3);

                    int upDateValue = 0;
                    if (valueOne < valueTwo) {
                        upDateValue = 1;
                    }
                    startArray[valueThree] = upDateValue;
                    increase = 4;
                    break;
                }
                case 8: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    int valueTwo = calculateValue(two, modeTwo, 2);
                    int valueThree = calculateValue(three, modeThree, 3);
                    int upDateValue = 0;
                    if (valueOne == valueTwo) {
                        upDateValue = 1;
                    }
                    startArray[valueThree] = upDateValue;
                    increase = 4;
                    break;
                }
                case 9: {
                    int one = getOne(i);
                    int valueOne = calculateValue(one, modeOne, 1);
                    relativeMode = relativeMode + valueOne;
                    increase = 2;
                    break;
                }
                case 99: {
                    System.out.println("99 is bereikt");
                    exit(0);
//                    break;
                }
                default:
                    System.out.println("shits gone wrong");
                    System.out.println("shits gone wrong");
                    exit(1);
                    break;
            }

        }
    }

    static int getOne(int i) {
        return startArray[i + 1];
    }

    static int getTwo(int i) {
        return startArray[i + 2];
    }

    static int getThree(int i) {
        return startArray[i + 3];
    }

    static int calculateValue(int waarde, int modus, int position) {
        if (position == 3) {
            if (modus == 2) {
                return startArray[waarde] + relativeMode;
                //only mode 2 or 3 are options
            } else {
                return waarde;
            }
        }
        if (modus == 2) {
            return startArray[waarde + relativeMode];
        }
        if (modus == 1) {
            return waarde;
        }
        if (modus == 0) {
            return startArray[waarde];
        }
        System.out.println("kan niet++++++++++++++++++++++++++++++");
        exit(999);
        return 2;
    }

}
