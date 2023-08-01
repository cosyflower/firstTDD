package tdd.firstOOP.refactor1;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // 1. 메서드 추출한 구간이 되겠다 (switch 문 관련해서)
            // 2. thisAmount는 each.getCharge() 를 저장하는 변수로만 활동한다. 불필요한 중복이 발생하고 있는 상황이다
            // thisAmount = each.getCharge();
            // 적립포인트 증가시킨다
            frequentRenterPoints++;
            // 최신물 && 2일 이상 대여하는 경우에는 보너스 포인트를 지급한다
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // 대여하는 비디오 정보 그리고 대여료를 출력해보자
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + '\n';
            // 누적된 총 대여료까지 합해주면
            totalAmount += each.getCharge();

        }

        // Footer 행 추가하기
        result += "누적 대여료 : " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);
        return result;
    }

    /*
    Refactoring을 모두 진행한 다음에 본래의 메서드를 삭제하는 것이 올바른 방법이다 ]

    public double amountFor(Rental aRental) {
        return aRental.getCharge();
    }
     */
}