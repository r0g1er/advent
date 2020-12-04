package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public final class ImprovedArrayCreator {

    public ImprovedArrayCreator() {

    }

    public int[] createIntArrayFromfile(String fileinput, String regex) {
        String[] stringArray = createFromFileSplitByLine(fileinput, regex);
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {

            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        System.out.println("array has length: " + intArray.length);
        return intArray;
    }

    public String[] createFromFileSplitByLine(String fileinput, String regex) {
        StringBuilder input = new StringBuilder();
        try {
            Scanner in = new Scanner(new FileReader(fileinput));
            while (in.hasNextLine()) {
                input.append(in.nextLine()).append(regex);
            }
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("fuuuu" + e);
        }
        return create(input.toString(), regex);
    }

    public String[] create(String input, String regex) {
        return input.split(regex);
    }

}
