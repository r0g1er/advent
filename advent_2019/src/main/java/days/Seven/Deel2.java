package days.Seven;

/**
 * @noinspection Duplicates
 */
public class Deel2 {

    public static void main(String[] args) {
        int gevonden = 0;
        int sequence = 0;
        int min = 5;
        int max = 9;
        ArrayVuller vuller = new ArrayVuller();

        int[] amplifierA;
        int[] amplifierB;
        int[] amplifierC;
        int[] amplifierD;
        int[] amplifierE;


        for (int a = max; a>= min; a++) {
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
                            System.out.println();

                            amplifierA = vuller.run();
                            amplifierB = vuller.run();
                            amplifierC = vuller.run();
                            amplifierD = vuller.run();
                            amplifierE = vuller.run();

                            Amplifier programmaA = new Amplifier(a, 0, amplifierA);
                            int antwoordA = programmaA.run();

                            Amplifier programmaB = new Amplifier(b, antwoordA, amplifierB);
                            int antwoordB = programmaB.run();


                            Amplifier programmaC = new Amplifier(c, antwoordB, amplifierC);
                            int antwoordC = programmaC.run();


                            Amplifier programmaD = new Amplifier(d, antwoordC, amplifierD);
                            int antwoordD = programmaD.run();


                            Amplifier programmaE = new Amplifier(e, antwoordD, amplifierE);
                            int antwoordE = programmaE.run();

                            System.out.println("                      " + antwoordE);


                            if (antwoordE > gevonden) {
                                gevonden = antwoordE;
                                sequence = a * 10000 +
                                        b * 1000 +
                                        c * 100 +
                                        d * 10 +
                                        e;
                            }
//

                            for (int i = 0; i < 40; i++) {
                                programmaA.updateInputB(antwoordE);
                                antwoordA = programmaA.run();
                                programmaB.updateInputB(antwoordA);

                                antwoordB = programmaB.run();
                                programmaC.updateInputB(antwoordB);


                                antwoordC = programmaC.run();
                                programmaD.updateInputB(antwoordC);


                                antwoordD = programmaD.run();

                                programmaE.updateInputB(antwoordD);

                                antwoordE = programmaE.run();


                                System.out.println("                      " + antwoordE);

                                if (antwoordE > gevonden) {
                                    gevonden = antwoordE;
                                    sequence = a * 10000 +
                                            b * 1000 +
                                            c * 100 +
                                            d * 10 +
                                            e;
                                }
                            }
//                            255590 is te laag
//2147483641 is gelukkig te hoog
                            // 58285150
                        }


                    }


                }

            }

        }

        System.out.println(gevonden + ", voor sequence " + sequence);
    }


}
