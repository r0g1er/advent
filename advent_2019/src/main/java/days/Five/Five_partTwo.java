package days.Five;

import days.Three.ArrayCreator;
import static java.lang.System.exit;

/**
 * @author Rogier
 */
public final class Five_partTwo {
    static int[] startArray;

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        startArray = creator.createIntArrayFromfile("src/main/java/days/Five/input", ",");
        //3970568 is het niet

        //answer might be 7704130
        //answer might be 7704130
//int[] startArray={3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
//        1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
//        999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99};
//        int[] startArray= {3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99};
//        int[] startArray= {3,9,8,9,10,9,4,9,99,-1,8}; // if input is 8, result is 1, orther it is 0
//        int[] startArray= {3,3,1108,-1,8,3,4,3,99}; // if input is 8, result is 1, orther it is 0
//        int[] startArray= {3,9,7,9,10,9,4,9,99,-1,8}; // if input is smaller than 8, result is 1, orther it is 0
//        int[] startArray= {3,3,1107,-1,8,3,4,3,99}; // if input is smaller than 8, result is 1, orther it is 0
//        int[] startArray= {3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9}; // jumptest
//        int[] startArray= {3,3,1105,-1,9,1101,0,0,12,4,12,99,1}; // jumptest
//        int[] startArray= {3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
//        int[] startArray= {1002,4,3,4,33};
//        int[] startArray= {1101,100,-1,4,0};
//


        //answer 3970568 is to low
        int increase=-1000;
        for (int i = 0; i < startArray.length; i += increase) {
            int instructionsOptcode = startArray[i];
            int whatToDo = instructionsOptcode % 100;

//            increase = 4;
            System.out.println("instructionsOptcode is " + instructionsOptcode);
            System.out.println("WhatToDo is " + whatToDo);


            int modeOne = ((instructionsOptcode - whatToDo) % 1000) / 100;
            int modeTwo = ((instructionsOptcode - whatToDo - (modeOne * 100)) % 10000) / 1000;



            switch (whatToDo) {

                case 1: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);
                    System.out.println("adding " + (valueOne + valueTwo) + " on location  " + three);
                    startArray[three] = valueOne + valueTwo;
                    increase = 4;
                    break;
                }

                case 2: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);

                    System.out.println("multiplying storing " + (valueOne * valueTwo) + " on location " + three);
                    startArray[three] = valueOne * valueTwo;
                    increase = 4;
                    break;
                }
                case 3: {
                    int one = getOne(i);
                    System.out.println("asks for input");
                    startArray[one] = 5;//never writes in imediate mote
                    System.out.println("store 5 on location " + one);
                    increase = 2;

                    break;
                }
                case 4: {
                    int one = getOne(i);
                    int valueOne = calculateValue(one, modeOne);

                    System.out.println("output---------------------------------------------------------");
                    System.out.println(valueOne);
                    increase = 2;
                    break;
                }
                case 5: {
                    //Opcode 5 is jump-if-true: if the first parameter is non-zero, it sets the instruction pointer to the value from the second parameter. Otherwise, it does nothing.
                    int one = getOne(i);
                    int two = getTwo(i);
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);
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
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);
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
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);


                    int upDateValue = 0;
                    if (valueOne < valueTwo) {
                        upDateValue = 1;
                    }
                    startArray[three] = upDateValue;
                    increase = 4;
                    break;
                }
                case 8: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);
                    int upDateValue = 0;
                    if (valueOne == valueTwo) {
                        upDateValue = 1;
                    }
                    startArray[three] = upDateValue;
                    increase = 4;
                    break;
                }
                case 99: {
                    System.out.println("99 is bereikt");
                    System.out.println(startArray[0]);
                    System.out.println(startArray[0]);
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

    static int calculateValue(int waarde, int modus) {
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
