package common;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * ArrayCreator class can be used to create an Array from input. The input can be a file or a string
 * the input should be comma separated. No quotation marks.
 *
 * @author Rogier
 */
public final class ArrayCreator {

    public ArrayCreator() {

    }

    public int[] createIntArrayFromfile(String fileinput, String regex) {
        String[] stringArray = createFromFile(fileinput, regex);
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        System.out.println("array has length: " + intArray.length);
        return intArray;
    }

    public String[] createFromFile(String fileinput, String regex) {
        StringBuilder input = new StringBuilder();
        try {


            Scanner in = new Scanner(new FileReader(fileinput));
            while (in.hasNext()) {
                input.append(in.next());
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
