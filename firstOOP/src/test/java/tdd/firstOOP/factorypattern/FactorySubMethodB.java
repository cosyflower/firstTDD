package tdd.firstOOP.factorypattern;

public class FactorySubMethodB extends FactoryMethod {

    private String subA;
    private String subB;
    private String subC;

    public FactorySubMethodB(String subA, String subB, String subC) {
        this.subA = subA;
        this.subB = subB;
        this.subC = subC;
    }

    @Override
    public String getSubA() {
        return this.subA;
    }

    @Override
    public String getSubB() {
        return this.subB;
    }

    @Override
    public String getSubC() {
        return this.subC;
    }
}
