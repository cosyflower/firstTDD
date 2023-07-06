package tdd.firstOOP.chapter2;

import org.junit.jupiter.api.Test;
import tdd.firstOOP.chap02.PasswordStrength;
import tdd.firstOOP.chap02.PasswordStrengthMeter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals( expStr, result );
    }

    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength( "ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("abAB!4", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Number_Then_Normal(){
        PasswordStrength result = meter.meter("ab!@^&*A");
        assertStrength("ab!@^&*A", PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("abcd!@#$l1", PasswordStrength.NORMAL);
        assertStrength("abc@34def!fe", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abcdefghijklmnop", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("abc123", PasswordStrength.WEAK);
    }


    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("AB", PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("ab", PasswordStrength.WEAK);
    }
}
