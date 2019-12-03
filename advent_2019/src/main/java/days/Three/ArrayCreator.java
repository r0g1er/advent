package days.Three;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Rogier
 */
public final class ArrayCreator {

     public ArrayCreator(){

     }

     public String[] createFromFile(String fileinput) {
        StringBuilder input = new StringBuilder();
         try {


             Scanner in = new Scanner(new FileReader(fileinput));
             while (in.hasNext()) {
                 input.append(in.next());
             }
             in.close();
         }catch (FileNotFoundException e){
             System.out.println("fuuuu" + e);
         }
         return create(input.toString());
     }

     public String[] create(String input){
         return input.split(",");
     }

}
