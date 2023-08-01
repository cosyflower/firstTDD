package tdd.firstOOP.builderpattern;


public class Computer {

    //required args
    private String ram;
    private String hdd;

    //optional args
    private Boolean isGraphicsEnabled;
    private Boolean isNetworkEnabled;

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public Boolean isGraphicsEnabled() {
        return isGraphicsEnabled;
    }

    public Boolean isNetworkEnabled() {
        return isNetworkEnabled;
    }

    private Computer(ComputerBuilder computerBuilder) {
        // Builder 객체를 인자로 받고
        // 인자로 받는 객체 내의 필드 값을 모두 동일하게 맞춰주면 된다
        this.ram = computerBuilder.RAM;
        this.hdd = computerBuilder.HDD;
        this.isGraphicsEnabled = computerBuilder.isGraphicsCardEnabled;
        this.isNetworkEnabled = computerBuilder.isNetworkEnabled;
    }

    // Static Nested Class를 활용해서 객체를 생성합니다
    public static class ComputerBuilder {
        // required parameters
        private String HDD;
        private String RAM;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isNetworkEnabled;

        public ComputerBuilder(String hdd, String ram){
            this.HDD=hdd;
            this.RAM=ram;
        }

        // optional 한 값들은 set.. 시리즈 메서드들로 값을 전달받는다
        // 결과적으로 static 빌더 객체를 최종적으로 형성한 이후에
        // build() 메서드를 통해서 만들고자 한 객체의 생성자의 인자로 전달된다고 생각하면 되겠다

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isNetworkEnabled) {
            this.isNetworkEnabled = isNetworkEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }

}
