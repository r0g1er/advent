package days.day04;

import common.ImprovedArrayCreator;

public class PartOne {
    private final String BIRTH = "byr"; // (Birth Year)
    private final String ISSUE = "iyr";// (Issue Year)
    private final String EXPIRE = "eyr";// (Expiration Year)
    private final String HEIGHT = "hgt";// (Height)
    private final String HAIR = "hcl";// (Hair Color)
    private final String EYE = "ecl";// (Eye Color)
    private final String PASSPORT = "pid";// (Passport ID)
    private final String COUNTRY = "cid";// (Country ID)

    public void run() {
        ImprovedArrayCreator creator = new ImprovedArrayCreator();
        String[] startArray = creator.createFromFileSplitByLine("src/main/java/days/day04/input", ";");
        int count =0;
        for (int i = 0; i < startArray.length; i++) {
            String valueToCheck = startArray[i];
            if (valueToCheck.contains(BIRTH)&&
                    valueToCheck.contains(ISSUE)&&
                    valueToCheck.contains(EXPIRE)&&
                    valueToCheck.contains(HEIGHT)&&
                    valueToCheck.contains(HAIR)&&
                    valueToCheck.contains(EYE)&&
                    valueToCheck.contains(PASSPORT)
            ) {
                count++;
            }

        }
        System.out.println(count);
    }
}