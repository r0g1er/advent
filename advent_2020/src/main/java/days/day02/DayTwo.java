package days.day02;

import common.ArrayCreator;

public class DayTwo {

    public static void main(String args[]) {
//        partTOne();
        partTwo();
    }

    public static void partTOne() {
        ArrayCreator creator = new ArrayCreator();
        String[] startArray = creator.createFromFile("src/main/java/days/day02/input", ",");
        System.out.println(startArray.length);
        int result = 0;
        for (int i = 0; i < startArray.length; i++) {
            String subject = startArray[i];
            String[] info = subject.split(":");
            System.out.println(info[0]);
            System.out.println(info[1]);
            System.out.println(info[2]);
            System.out.println(info[3]);
            int min = Integer.parseInt(info[0]);
            int max = Integer.parseInt(info[1]);
            char check = info[2].charAt(0);
            String password = info[3];
            System.out.println("max is " + max);
            System.out.println("min is " + min);
            System.out.println("check is " + check);
            System.out.println("password is " + password);
            int count = 0;

            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == check) {
                    count++;
                }
            }
                if (count <= max && count >= min) {
                    result++;
                    System.out.println("is ok");
                } else {
                    System.out.println("is nok");
                }
            }



        System.out.println(result);
    }

    public static void partTwo() {
        ArrayCreator creator = new ArrayCreator();
        String[] startArray = creator.createFromFile("src/main/java/days/day02/input", ",");
        System.out.println(startArray.length);
        int result = 0;
        for (int i = 0; i < startArray.length; i++) {
            String subject = startArray[i];
            String[] info = subject.split(":");
            System.out.println(info[0]);
            System.out.println(info[1]);
            System.out.println(info[2]);
            System.out.println(info[3]);
            int min = Integer.parseInt(info[0]);
            int max = Integer.parseInt(info[1]);
            char check = info[2].charAt(0);
            String password = info[3];
            System.out.println("max is " + max);
            System.out.println("min is " + min);
            System.out.println("check is " + check);
            System.out.println("password is " + password);
            int count = 0;

            if (password.charAt(min-1)==check) count++;
            if (password.charAt(max-1)==check) count++;

            if (count==1) {
                result++;
                System.out.println("is ok");
            } else {
                System.out.println("is nok");
            }
        }



        System.out.println(result);
    }



}
