package tdd.firstOOP.chapter2;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() == 100000?
                12 : payData.getPayAmount() / 10000;
        if(payData.getFirstBillingDate() != null ) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        }else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2){
        return date1.getDayOfMonth() != date2.getDayOfMonth();

    }

    private int lastDayOfMonth(LocalDate date){
        return YearMonth.from(date).lengthOfMonth();
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        // 후보 만료 일자를 먼저 정해둔 상황에서 일자만 수정하는 로직이 되겠다
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        // 서로 다른 일자를 지니고 있는 상황이라면 먼저 비교를 해줘야 한다
        if( isSameDayOfMonth(payData.getFirstBillingDate(),candidateExp)){ // 만료 일자가 서로 다른 경우에는
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);

            if( dayLenOfCandiMon < dayOfFirstBilling){ // 먼저 만료 일자를 서로 비교를 하고 난 후에 결정
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        }else{
            return candidateExp;
        }
    }
}
