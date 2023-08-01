package tdd.firstOOP.factorypattern;

// 인터페이스로 해도 되고
// 추상 클래스로 진행해도 상관 없다
public abstract class FactoryMethod {

    public abstract String getSubA();
    public abstract String getSubB();
    public abstract String getSubC();

    @Override
    public String toString() {
        return "SubA is " + getSubA() + "\n" + "SubB is " + getSubB() + "\n"
                + "SubC is " + getSubC() + "\n";
    }
}
