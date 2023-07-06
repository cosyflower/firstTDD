package tdd.firstOOP.chapter2;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    public void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals( expectedExpiryDate, realExpiryDate );
    }

    @Test
    public void 만원납부하면_한달_뒤가_만료일(){
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 4, 1));
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 5, 5))
                        .payAmount(10000)
                        .build(),
                LocalDate.of(2019, 6, 5));
    }

    @Test
    public void 납부일_만료일이_한달_뒤가_다른_경우(){
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10000)
                                .build(),
                LocalDate.of(2019, 2, 28));

        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10000)
                                .build(),
                LocalDate.of(2019, 6, 30));
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10000).build(),
                LocalDate.of(2020, 2, 29));
    }

    @Test
    public void 첫_납부일과_만료일_일자가_다른경우(){
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 31))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2019,3,31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 30))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2019,3,30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 5, 31))
                .billingDate(LocalDate.of(2019, 6, 30))
                .payAmount(10000)
                .build();

        assertExpiryDate(payData3, LocalDate.of(2019,7,31));
    }

    @Test
    void 이만원_내면_비례해서_만료일_계산하기(){
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20000)
                        .build(),
                LocalDate.of(2019, 5, 1));

        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 8, 1))
                        .payAmount(30000)
                        .build(),
                LocalDate.of(2019, 11, 1));

        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 8, 1))
                        .payAmount(70000)
                        .build(),
                LocalDate.of(2020, 3, 1));
    }

    @Test
    void 첫_납부일_만료일자가_다른경우_이만원_이상_납부(){
        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(20000)
                        .build(),
                LocalDate.of(2019, 4, 30));

        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 3, 31))
                        .payAmount(50000)
                        .build(),
                LocalDate.of(2019, 8, 31));

        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 2, 28))
                        .billingDate(LocalDate.of(2019, 3, 28))
                        .payAmount(60000)
                        .build(),
                LocalDate.of(2019, 9, 28));
    }

    @Test
    void 십만원을_납부하면_1년_제공(){
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100000)
                        .build(),
                LocalDate.of(2020, 1, 28));
    }



}
