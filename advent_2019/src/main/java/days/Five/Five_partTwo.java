package days.Five;

import days.Three.ArrayCreator;
import static java.lang.System.exit;

/**
 * @author Rogier
 */
public final class Five_partTwo {
    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/Five/input", ",");

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
//        startArray[1]=12;
//        startArray[2]=2;


        //answer 3970568 is to low
        int increase;
        for (int i = 0; i < startArray.length; i += increase) {
            System.out.println("start op loop---");
            System.out.println("i is " + i);
            int instructionsOptcode = startArray[i];
            int whatToDo = instructionsOptcode % 10;

            increase = 4;
            System.out.println("instructionsOptcode is " + instructionsOptcode);
            System.out.println("WhatToDo is " + whatToDo);


            int modeOne = ((instructionsOptcode - whatToDo) % 1000) / 100;
            int modeTwo = ((instructionsOptcode - whatToDo - modeOne * 100) % 10000) / 1000;
            int modeThree = ((instructionsOptcode - whatToDo - modeOne * 100 - modeTwo * 1000) % 100000) / 10000;

            System.out.println("instructionsOptcode = is " + instructionsOptcode);
            System.out.println("modes:  " + modeOne + " " + modeTwo + " " + modeThree);
            if (whatToDo== 99 ||whatToDo==9) {
                exit(0);
            }
            int one = startArray[i + 1];

            int two = startArray[i + 2];
            int three = 0;
            if (whatToDo == 4 || whatToDo == 5 || whatToDo == 6) {

            } else {
                three = startArray[i + 3];
            }
            System.out.println("First value to use = " + one);
            System.out.println("Second value to use = " + two);
            System.out.println("Third value to use = " + three);
            int valueOne;
            int valueTwo = 0;
            int valueThree = 0;

            if (modeOne == 1) {
                valueOne = one;
            } else {
                valueOne = startArray[one];
            }
            System.out.println("First value results in " + valueOne);
            if (whatToDo == 1 || whatToDo == 2 || whatToDo == 5 || whatToDo == 6 || whatToDo == 7 || whatToDo == 8) {
                if (modeTwo == 1) {
                    valueTwo = two;
                } else {
                    valueTwo = startArray[two];
                }
            }
            if (whatToDo == 1 || whatToDo == 2 || whatToDo == 7 || whatToDo == 8) {
                if (modeThree == 1) {
                    valueThree = three;
                } else {
                    valueThree = startArray[three];
                }
                System.out.println("Second value results in " + valueTwo);
                System.out.println("Third value results in " + valueThree);
            }

            switch (whatToDo) {

                case 1: {
                    System.out.println("adding " + (valueOne + valueTwo) + " on location  " + three);
                    startArray[three] = valueOne + valueTwo;
                    break;
                }

                case 2: {
                    System.out.println("multiplying storing " + (valueOne * valueTwo) + " on location " + three);
                    startArray[three] = valueOne * valueTwo;
                    break;
                }
                case 3: {
                    System.out.println("asks for input");
                    startArray[one] = 5;//never writes in imediate mote
                    System.out.println("store 5 on location " + one);
//                    System.out.println("store ZERRRO on location " + one);
                    increase = 2;
                    break;
                }
                case 4: {
                    System.out.println("output---------------------------------------------------------");
                    System.out.println(valueOne);
//                    System.out.println(one);
//                    System.out.println(startArray[one]);
//                    System.out.println(startArray[valueOne]);
                    increase = 2;
                    break;
                }
                case 5: {
                    //Opcode 5 is jump-if-true: if the first parameter is non-zero, it sets the instruction pointer to the value from the second parameter. Otherwise, it does nothing.


//                    if (startArray[valueOne]!=0){
                    if (valueOne != 0) {
//                        i=startArray[two];
//                        i=startArray[valueTwo];
                        i = valueTwo;//denk dat dit hem moet zijn
//                        i=two;

                        increase = 0;
                    } else {
                        increase = 3;
                    }
                    break;
                }
                case 6: {
//                    if (startArray[valueOne]==0){
                    if (valueOne == 0) {

//                        i=startArray[two];
//                        i=startArray[valueTwo];
                        i = valueTwo;//denk dat dit hem moet zijn
//                        i=two;
                        increase = 0;
                    } else {
                        increase = 3;
                    }

                    break;
                }
                case 7: {
                    int upDateValue = 0;
                    if (startArray[valueOne] < startArray[valueTwo]) {
                        upDateValue = 1;
                    }
                    startArray[three] = upDateValue;
                    break;
                }
                case 8: {
                    int upDateValue = 0;
                    if (startArray[valueOne] == startArray[valueTwo]) {
                        upDateValue = 1;
                    }
                    startArray[three] = upDateValue;
                    break;
                }
                case 9:
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

            System.out.println("increase is " + increase);
            System.out.println("End of loop---");
        }
    }
}
