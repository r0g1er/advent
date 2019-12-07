package days.Seven;


import static java.lang.System.exit;

public class Amplifier {
    private int inputFirst;
    private int inputSecond;
    private boolean usedInput;
    public int[] delijst;
    private int output = -1000;

    public Amplifier(int a, int b, int[] dezelijst) {
        inputFirst = a;
        inputSecond = b;
        usedInput = false;
        delijst = dezelijst;
    }
public void updateInputB(int nieuweWaarde){
        inputSecond = nieuweWaarde;
}
    public void reset(int a, int b){
        inputFirst = a;
        inputSecond = b;
//        usedInput = false;
    }

    public int run() {
        int increase = -1000;
        boolean nogVerder = true;
        for (int i = 0; i < delijst.length && nogVerder; i += increase) {
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
//                    System.out.println("store 5 on location " + one);
                    increase = 2;

                    break;
                }
                case 4: {
                    int one = getOne(i);
                    int valueOne = calculateValue(one, modeOne);

//                    System.out.println("output---------------------------------------------------------");
//                    System.out.println(valueOne);
                    output = valueOne;
                    increase = 2;
//                    return output;
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
                    break;
                }
                default:
                    System.out.println("shits gone wrong");
                    System.out.println("shits gone wrong");
                    exit(1);
                    break;
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
