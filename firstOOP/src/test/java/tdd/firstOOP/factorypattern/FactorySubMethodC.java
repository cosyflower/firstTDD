package tdd.firstOOP.factorypattern;

public class FactorySubMethodC extends FactoryMethod {

    private String subA;
    private String subB;
    private String subC;

    public FactorySubMethodC(String subA, String subB, String subC) {
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
