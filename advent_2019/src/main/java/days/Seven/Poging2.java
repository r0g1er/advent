package days.Seven;

public class Poging2 {

    public static void main(String[] args) {
        // variabelen om status bij te houden
        int gevonden = 0;
        int sequence = 0;
        int run = 0;

        //configuratie
        int min = 5;
        int max = 9;


        for (int a = min; a <= max; a++) {
            for (int b = min; b <= max; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = min; c <= max; c++) {
                    if (a == c || b == c) {
                        continue;
                    }


                    for (int d = min; d <= max; d++) {
                        if (a == d || b == d || c == d) {
                            continue;
                        }

                        for (int e = min; e <= max; e++) {
                            if (a == e || b == e || c == e || d == e) {
                                continue;
                            }

                            ArrayVuller vullerA = new ArrayVuller();
                            ArrayVuller vullerB = new ArrayVuller();
                            ArrayVuller vullerC = new ArrayVuller();
                            ArrayVuller vullerD = new ArrayVuller();
                            ArrayVuller vullerE = new ArrayVuller();


                            int[] arrayForA = vullerA.run();
                            int[] arrayForB = vullerB.run();
                            int[] arrayForC = vullerC.run();
                            int[] arrayForD = vullerD.run();
                            int[] arrayForE = vullerE.run();
                            System.out.println("arrays gevuld");

                            Amplifier programmaA = new Amplifier(a, 0, arrayForA, "AmplifierA");
                            int antwoordA = programmaA.run();

                            Amplifier programmaB = new Amplifier(b, antwoordA, arrayForB, "AmplifierB");
                            int antwoordB = programmaB.run();


                            Amplifier programmaC = new Amplifier(c, antwoordB, arrayForC, "AmplifierC");
                            int antwoordC = programmaC.run();


                            Amplifier programmaD = new Amplifier(d, antwoordC, arrayForD, "AmplifierD");
                            int antwoordD = programmaD.run();


                            Amplifier programmaE = new Amplifier(e, antwoordD, arrayForE, "AmplifierE");
                            int antwoordE = programmaE.run();

//                            System.out.println("                      " + antwoordE);


                            if (antwoordE > gevonden) {
                                gevonden = antwoordE;
                                sequence = a * 10000 + b * 1000 + c * 100 + d * 10 + e;
                            }

//                            System.out.println("voor de lus is dit het antwoord van E " + antwoordE+ " tot nu toe is het hoogste " +gevonden);

                            for (int i = 0; i < 100; i++) {
                                System.out.println(i);
                                programmaA.updateInputB(antwoordE);
                                antwoordA = programmaA.run();
//                                System.out.println("a gehad");
                                if (programmaA.kapot) {
                                    break;
                                }
                                programmaB.updateInputB(antwoordA);
                                antwoordB = programmaB.run();
//                                System.out.println("b gehad");
                                if (programmaB.kapot) {
                                    break;
                                }
                                programmaC.updateInputB(antwoordB);
                                antwoordC = programmaC.run();
                                if (programmaC.kapot) {
                                    break;
                                }
                                programmaD.updateInputB(antwoordC);
                                antwoordD = programmaD.run();
                                if (programmaD.kapot) {
                                    break;
                                }
                                programmaE.updateInputB(antwoordD);
                                antwoordE = programmaE.run();
                                if (programmaE.kapot) {
                                    break;
                                }
                                if (antwoordE > gevonden) {
                                    gevonden = antwoordE;

                                    sequence = a * 10000 + b * 1000 + c * 100 + d * 10 + e;
                                    run = i;
                                }
//                                System.out.println("after i " + i + " " + antwoordE+ " tot nu toe is het hoogste " +gevonden);

                            }//loop of amplifiers feedback


//68815 is wrong


                        }// E (laatste) counter
                    } //d counter
                } //c counter
            }
        }

        System.out.println(gevonden + ", voor sequence " + sequence + "aantal herhalinginen is " + run);
    }


}

