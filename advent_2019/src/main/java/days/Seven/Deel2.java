package days.Seven;

/**
 * @noinspection Duplicates
 */
public class Deel2 {

    public static void main(String[] args) {
        int gevonden = 0;
        int sequence = 0;
        ArrayVuller vuller = new ArrayVuller();

        int[] amplifierA;
        int[] amplifierB;
        int[] amplifierC;
        int[] amplifierD;
        int[] amplifierE;


        for (int a = 5; a < 10; a++) {
            for (int b = 5; b < 10; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = 5; c < 10; c++) {
                    if (a == c || b == c) {
                        continue;
                    }


                    for (int d = 5; d < 10; d++) {
                        if (a == d || b == d || c == d) {
                            continue;
                        }

                        for (int e = 5; e < 10; e++) {
                            if (a == e || b == e || c == e || d == e) {
                                continue;
                            }


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


                            for (int i = 0; i < 50; i++) {
                                programmaA.reset(a, antwoordE);
                                programmaB.reset(b, antwoordA);
                                programmaC.reset(c, antwoordB);
                                programmaD.reset(d, antwoordC);
                                programmaE.reset(e, antwoordD);


                                antwoordA = programmaA.run();
                                antwoordB = programmaB.run();
                                antwoordC = programmaC.run();
                                antwoordD = programmaD.run();
                                antwoordE = programmaE.run();


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

                        }


                    }


                }

            }

        }

        System.out.println(gevonden + ", voor sequence " + sequence);
    }


}
