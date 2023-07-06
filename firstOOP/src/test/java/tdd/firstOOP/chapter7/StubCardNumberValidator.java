package tdd.firstOOP.chapter7;

public class StubCardNumberValidator extends CardNumberValidator {
    private String invalidNo;
    private String theftNo;

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }

    @Override
    public CardValidity validate(String cardNumber){
        // 실질적으로 카드 번호가 유효한지를 검사하지 않음
        // invalidNo 가 존재하는 상황에서 검사하려고 하는 카드 번호와 invalidNo가 일치한다면 INVALID 상태
        // 그렇지 아니한 경우에는 VALID 한 상태라고 할 수 있다
        if( invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT;
        }
        return CardValidity.VALID;
    }

}
