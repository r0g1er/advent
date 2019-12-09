package days.Seven;


import days.Three.ArrayCreator;

import static java.lang.System.exit;

public class Amplifier {
    private int inputFirst;
    private int inputSecond;
    private boolean usedInput;
    public int[] delijst;
    private int output;
    int i;
    public boolean kapot;
    String name;

    public Amplifier(int a, int b, int[] dezelijst, String naam) {
        inputFirst = a;
        inputSecond = b;
        usedInput = false;
        kapot = false;
        delijst = dezelijst;
        i = 0;
        name = naam;
    }

    public Amplifier(int a, int b, int[] dezelijst) {
        this(a, b, dezelijst, "niet gedefinieerd");
    }


    public void updateInputB(int nieuweWaarde) {
        inputSecond = nieuweWaarde;
//        inputFirst = nieuweWaarde;
//    usedInput=false;
    }

    public void reset(int a, int b) {
        inputFirst = a;
        inputSecond = b;
//        usedInput = false;
    }

    public void setInputSecond(int b) {
        inputSecond = b;
        inputFirst = b;
    }

    public int run() {
//        System.out.println(i + "dit is i bij de start");
        int increase = -1000;
        boolean nogVerder = true;
//        System.out.println(i);
//        System.out.println("we doen heteven " + name);
        for (; i < delijst.length && nogVerder; i += increase) {
            int instructionsOptcode = delijst[i];
            int whatToDo = instructionsOptcode % 100;

//            System.out.println("instructionsOptcode is " + instructionsOptcode);
//            System.out.println("WhatToDo is " + whatToDo);


            int modeOne = ((instructionsOptcode - whatToDo) % 1000) / 100;
            int modeTwo = ((instructionsOptcode - whatToDo - (modeOne * 100)) % 10000) / 1000;


            switch (whatToDo) {

                case 1: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);
//                    System.out.println("adding " + (valueOne + valueTwo) + " on location  " + three);
                    delijst[three] = valueOne + valueTwo;
                    increase = 4;
                    break;
                }

                case 2: {
                    int one = getOne(i);
                    int two = getTwo(i);
                    int three = getThree(i);
                    int valueOne = calculateValue(one, modeOne);
                    int valueTwo = calculateValue(two, modeTwo);

//                    System.out.println("multiplying storing " + (valueOne * valueTwo) + " on location " + three);
                    delijst[three] = valueOne * valueTwo;
                    increase = 4;
                    break;
                }
                case 3: {
                    int one = getOne(i);
//                    System.out.println("asks for input");
                    int deInput = usedInput ? inputSecond : inputFirst;
                    usedInput = true;
                    delijst[one] = deInput;//never writes in imediate mote
//                    System.out.println(name + " stored input: " + deInput);
                    increase = 2;

                    break;
                }
                case 4: {
                    int one = getOne(i);
                    int valueOne = calculateValue(one, modeOne);

//                    System.out.println("output---------------------------------------------------------");
//                    System.out.println(valueOne);
                    output = valueOne;
                    i = i + 2;
                    return output;
//                    break;
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
                    delijst[three] = upDateValue;
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
                    delijst[three] = upDateValue;
                    increase = 4;
                    break;
                }
                case 99: {
//                    System.out.println("99 is bereikt");
//                    System.out.println(delijst[0]);
//                    System.out.println(delijst[0]);
                    nogVerder = false;
                    i=0;
                    increase=0;
                    ArrayCreator ding = new ArrayCreator();
//                    delijst= ding.createIntArrayFromfile("src/main/java/days/Seven/input", ",");
                    System.out.println("999 is hit it is hit it is hit, i repeat it it hit " + name + " is down");
                    kapot=true;

                    break;
                }
                default:
                    System.out.println("shits gone wrong" + name);
                    System.out.println("shits gone wrong");
//                    return -12345678;
                    exit(1);
//                    break;
            }

        }
        return output;
    }

    int getOne(int i) {
        return delijst[i + 1];
    }

    int getTwo(int i) {
        return delijst[i + 2];
    }

    int getThree(int i) {
        return delijst[i + 3];
    }

    int calculateValue(int waarde, int modus) {
        if (modus == 1) {
            return waarde;
        }
        if (modus == 0) {
            return delijst[waarde];
        }
        System.out.println("kan niet++++++++++++++++++++++++++++++");
        exit(999);
        return 2;
    }

}
