/**
 * Created by qiqi on 2016/10/6.
 */
public class Driver {
    private String name;
    private String drivingLicenceNumber;
    private Car car;
    private int limitSpeed;

    public Driver(String driverName, String drivingLicenceNumber, int cityLimitSpeed, Car driverCar) {
        this.name = driverName;
        this.drivingLicenceNumber = drivingLicenceNumber;
        this.car = driverCar;
        this.limitSpeed = cityLimitSpeed;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void addGas(double add_amount) {
        car.setGas(add_amount);
        return;
    }

    public void useGas(double use_amount) {
        car.setGas((-1.0) * use_amount);
        return;
    }

    public void accelerateCar() {
        if (car.getCurrent_speed() < limitSpeed) {
            car.accelerate();
            return;
        } else {
            System.out.println("Speed limit warning, could not accelerate car");
            return;
        }
    }

    public void brakeCar() {
        car.brake();
        return;
    }

    public void launchCar(int launchSpeed) {
        car.setSpeed(launchSpeed);
        return;
    }

    public int showCurrentSpeed() {
        return car.getCurrent_speed();
    }

    public double showCurrentGasAmount() {
        return car.getGasTank();
    }

    public void drive(String newDirection) {
        if (!car.getDirection().equals(newDirection)) {
            car.setDirection(newDirection);
            return;
        }
    }

    public static void main(String[] args) {
        Car carNumberOne = new Car("Nissan", "2012", "SUV", 70.0, 2.5, 260, "Go straight head");
        Driver rose = new Driver("Rose", "HA156", 30, carNumberOne);
        rose.launchCar(20);
        rose.accelerateCar();
        rose.accelerateCar();
        rose.drive("Turn left");
        rose.brakeCar();
        rose.addGas(70);
        rose.useGas(20);
        System.out.println(rose.showCurrentSpeed()); //Output: 25
        System.out.println(rose.showCurrentGasAmount()); //Output: 50.0
    }

}
