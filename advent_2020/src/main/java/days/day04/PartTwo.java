package days.day04;

import common.ImprovedArrayCreator;

import java.util.regex.Pattern;

public class PartTwo {


    private final String BIRTH = "byr";
    private final String ISSUE = "iyr";// (Issue Year)
    private final String EXPIRE = "eyr";// (Expiration Year)
    private final String HEIGHT = "hgt";// (Height)
    private final String HAIR = "hcl";// (Hair Color)
    private final String EYE = "ecl";// (Eye Color)
    private final String PASSPORT = "pid";// (Passport ID)
    private final String COUNTRY = "cid";// (Country ID)

    private final String BIRTH_REGEX = "^[0-9]{4}$";
    private final String ISSUE_REGEX = "^[0-9]{4}$";
    private final String EXPIRE_REGEX = "^[0-9]{4}$";
    private final String HEIGHT_REGEX = "^[0-9]+[a-z]{2}$";
    private final String HAIR_REGEX = "^[#][0-9 a-f]{6}$";
    private final String EYE_REGEX = "^amb|blu|brn|gry|grn|hzl|oth$";
    private final String PASSPORT_REGEX = "^[0-9]{9}$";

    public void run() {
        ImprovedArrayCreator creator = new ImprovedArrayCreator();
        String[] startArray = creator.createFromFileSplitByLine("src/main/java/days/day04/input", ";");
        int count = 0;
        for (int i = 0; i < startArray.length; i++) {
            String valueToCheck = startArray[i];
            boolean allPresent = validateCategories(valueToCheck);
            if (allPresent) {
                String[] values = valueToCheck.split(" ");

                int countSucces = 0;
                int countFail = 0;
                for (int j = 0; j < values.length; j++) {
                    String[] keyValuePair = values[j].split(":");
                    String key = keyValuePair[0];

                    String value=keyValuePair[1];
                    boolean valid=false;
                    switch (key){
                        case BIRTH:{
                            valid =validateBirth(value);
                            break;
                        }
                        case ISSUE:{
                            valid =validateIssue(value);
                            break;
                        }
                        case EXPIRE:{
                            valid =validateExpire(value);
                            break;
                        }
                        case HEIGHT:{
                            valid =validateHeight(value);
                            break;
                        }
                        case HAIR:{
                            valid =validateHair(value);
                            break;
                        }
                        case EYE:{
                            valid =validateEye(value);
                            break;
                        }
                        case PASSPORT:{
                            valid = validatePassport(value);
                            break;
                        }
                        case COUNTRY:{
                            break;
                        }
                        default:
                            System.out.println("no case "+  key);
                    }
                    if (valid) {countSucces++;}

                }
                if (countSucces == 7) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    boolean validateCategories(String valueToCheck) {
        return (valueToCheck.contains(BIRTH) &&
                valueToCheck.contains(ISSUE) &&
                valueToCheck.contains(EXPIRE) &&
                valueToCheck.contains(HEIGHT) &&
                valueToCheck.contains(HAIR) &&
                valueToCheck.contains(EYE) &&
                valueToCheck.contains(PASSPORT));
    }

     boolean validateBirth(String value){
        return Pattern.matches(BIRTH_REGEX, value) &&
                Integer.parseInt(value) >= 1920 &&
                Integer.parseInt(value) <= 2002;
    }

    boolean validateIssue(String value){
        return Pattern.matches(ISSUE_REGEX, value) &&
                Integer.parseInt(value) >= 2010 &&
                Integer.parseInt(value) <= 2020;
    }

    boolean validateExpire(String value){
        return Pattern.matches(EXPIRE_REGEX, value)
                &&
                Integer.parseInt(value) >= 2020 &&
                Integer.parseInt(value) <= 2030;
    }

    private boolean validateHeight (String value){
      boolean valid =false;
        if (Pattern.matches(HEIGHT_REGEX, value)) {
            String getal = value.substring(0, value.length() - 2);
            int number = Integer.parseInt(getal);
            if (value.contains("in") && number >= 59 &&
                    number <= 76) {
                valid = true;
            } else if (value.contains("cm") && number >= 150 &&
                    number <= 193) {
                valid = true;
            }
        }
        return valid;
    }

    private boolean validateHair (String value){
        return Pattern.matches(HAIR_REGEX, value);
    }

    private boolean validateEye(String value) {
        return Pattern.matches(EYE_REGEX, value);
    }

    private boolean validatePassport(String value){
        return Pattern.matches(PASSPORT_REGEX, value);
    }

}