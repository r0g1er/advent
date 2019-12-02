import static java.lang.System.exit;

/**
 * @author Rogier
 */
public final class twoB {
    public static void main(String[] args) {
        for (int y=0; y<100;y++)

        {

            for (int z = 0; z < 100; z++) {
        two ding =new two(y,z);
        int result = ding.run();
        if (result == 19690720){
            System.out.println("shit has met his purpose");
            System.out.println(y);
            System.out.println(z);
            System.out.println(100* y + z);
            exit(0);

        }



            }
        }
    }
}
