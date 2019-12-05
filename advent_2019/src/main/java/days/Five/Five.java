package days.Five;

import days.Three.ArrayCreator;
import static java.lang.System.exit;

/**
 * @author Rogier
 */
public final class Five {
    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        int[] startArray = creator.createIntArrayFromfile("src/main/java/days/Five/input", ",");
//        int[] startArray= {1002,4,3,4,33};
//        int[] startArray= {1101,100,-1,4,0};
//
//        startArray[1]=12;
//        startArray[2]=2;

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
            if (instructionsOptcode == 99) {
                exit(0);
            }

            int one = startArray[i + 1];

            int two = startArray[i + 2];
            int three = startArray[i + 3];
            System.out.println("First value to use = " + one);
            System.out.println("Second value to use = " + two);
            System.out.println("Third value to use = " + three);
            int valueOne;
            int valueTwo=0;
            int valueThree=0;

            if (modeOne == 1) {
                valueOne = one;
            } else {
                valueOne = startArray[one];
            }
            System.out.println("First value results in " + valueOne);
            if (whatToDo == 1 || whatToDo == 2) {
                if (modeTwo == 1) {
                    valueTwo = two;
                } else {
                    valueTwo = startArray[two];
                }
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
                    startArray[one] = 1;//never writes in imediate mote
                    System.out.println("store 1 on location " + startArray[one]);
                    increase = 2;
                    break;
                }
                case 4: {
                    System.out.println("output");
                    System.out.println(valueOne);
                    increase = 2;
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
    //444 is too low
}
