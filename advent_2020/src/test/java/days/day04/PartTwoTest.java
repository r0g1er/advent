package days.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PartTwoTest {
    static  PartTwo two = new PartTwo();

    @Test
    public void testBirthYear() throws Exception {

        assertTrue(two.validateBirth("1999"));
        assertTrue(two.validateBirth("1920"));
        assertFalse(two.validateBirth("1919"));
        assertTrue(two.validateBirth("2002"));
        assertFalse(two.validateBirth("2003"));
        assertFalse(two.validateBirth("202"));
        assertFalse(two.validateBirth("20200"));
    }

    @Test
    public void testValidateIssue() throws Exception {
        assertFalse(two.validateIssue("2009"));
        assertFalse(two.validateIssue("2021"));
        assertTrue(two.validateIssue("2010"));
        assertTrue(two.validateIssue("2020"));
    }
@Test
    public void validateExpire(){
    assertTrue(two.validateExpire("2020"));
    assertTrue(two.validateExpire("2030"));
    assertFalse(two.validateExpire("2019"));
    assertFalse(two.validateExpire("2031"));
    }
}