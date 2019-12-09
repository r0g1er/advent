package days.Seven;

public class Seven {

    public static void main(String[] args) {
        int gevonden = 0;
        int sequence = 0;
        ArrayVuller vuller = new ArrayVuller();

        int[] amplifierA;
        int[] amplifierB;
        int[] amplifierC;
        int[] amplifierD;
        int[] amplifierE;


        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = 0; c < 5; c++) {
                    if (a == c || b == c) {
                        continue;
                    }


                    for (int d = 0; d < 5; d++) {
                        if (a == d || b == d || c == d) {
                            continue;
                        }

                        for (int e = 0; e < 5; e++) {
                            if (a == e || b == e || c == e || d==e ) {
                                continue;
                            }


                            amplifierA = vuller.run();
                            amplifierB = vuller.run();
                            amplifierC = vuller.run();
                            amplifierD = vuller.run();
                            amplifierE = vuller.run();

                            Amplifier programmaA = new Amplifier(a, 0, amplifierA, "AmplifierA");
                            int antwoordA = programmaA.run();

                            Amplifier programmaB = new Amplifier(b, antwoordA, amplifierB, "AmplifierB");
                            int antwoordB = programmaB.run();


                            Amplifier programmaC = new Amplifier(c, antwoordB, amplifierC, "AmplifierC");
                            int antwoordC = programmaC.run();


                            Amplifier programmaD = new Amplifier(d, antwoordC, amplifierD, "AmplifierD");
                            int antwoordD = programmaD.run();


                            Amplifier programmaE = new Amplifier(e, antwoordD, amplifierE, "AmplifierE");
                            int antwoordE = programmaE.run();

                            System.out.println("                      " +antwoordE);
if (a == 0
     && b ==1
        && c ==2
        && d ==3
        &&  e==4        ){
    System.out.println("deze moet het zijn");
    System.out.println(antwoordE);
}

                            if (antwoordE > gevonden) {
                                gevonden = antwoordE;
                                sequence = a*10000 +
                                        b *1000 +
                                        c *100 +
                                        d *10 +
                                        e;
                            }
//68815 is wrong


                        }


                    }


                }

            }

        }

        System.out.println(gevonden+ ", voor sequence " +sequence);
    }


}
