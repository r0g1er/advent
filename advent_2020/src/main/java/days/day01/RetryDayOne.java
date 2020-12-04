package days.day01;

public class RetryDayOne {
    public static void main(String args[]) {
        PartOne partOne = new PartOne();
        int resultOne = partOne.run();
        System.out.println("Answer of part one is " + resultOne);

        PartTwo partTwo = new PartTwo();
        System.out.println("Answer of part one is " + partTwo.run());

    }
}
