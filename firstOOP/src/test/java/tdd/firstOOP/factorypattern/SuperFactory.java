package tdd.firstOOP.factorypattern;

// 객체 생성을 담당하는 Factory 클래스가 존재
// 기존에 슈퍼 - 서브 관계를 이루는 클래스들을 먼저 정의한 이후에 static 메서드를 활용해서 각각의 객체를 생성하고 반환해주는 역할을 수행


public class SuperFactory {
    // 정적 메서드로 정의( 생성자 처럼 활동하지만 정적 메서드로 동작한다 )
    // SubClass가 무엇인지 알지 못한 상황에서도 생성이 가능하다
    // 더 많은 SubClass가 추가된다고 하더라도 아래의 코드 상에는 변화가 없다

    public static FactoryMethod getSubABC(String type, String subA, String subB, String subC){
        // tpye 정보를 확인해서 각각의 상황에 맞게 객체를 반환해준다고 생각하면 되곘다
        if ("subA".equalsIgnoreCase(type)) {
            return new FactorySubMethodA(subA, subB, subC);
        } else if ("subB".equalsIgnoreCase(type)) {
            return new FactorySubMethodB(subA, subB, subC);
        } else {
            return new FactorySubMethodC(subA, subB, subC);
        }

    }
}
