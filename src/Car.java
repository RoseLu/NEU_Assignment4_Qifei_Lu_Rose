/**
 * Created by qiqi on 2016/10/6.
 */
public class Car {
    private String brand;
    private String year;
    private String type;
    private GasTank car_gasTank;
    private double maximum_gasTank;
    private double emission;
    private int maximum_speed;
    private int current_speed;
    private String direction;

    public Car(String brand, String year, String type, double maximum_gasTank, double emission, int maximum_speed, String direction) {
        this.brand = brand;
        this.year = year;
        this.type = type;
        this.maximum_gasTank = maximum_gasTank;
        this.emission = emission;
        this.maximum_speed = maximum_speed;
        car_gasTank = new GasTank();
        current_speed = 0;
        this.direction = direction;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String newBrand) {
        brand = newBrand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String newYear) {
        year = newYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        type = newType;
    }

    public double getMaximum_gasTank() {
        return maximum_gasTank;
    }

    public void setMaximum_gasTank(double newMaxGasTank) {
        maximum_gasTank = newMaxGasTank;
    }

    public double getEmission() {
        return emission;
    }

    public void setEmission(double newEmission) {
        emission = newEmission;
    }

    public int getMaximum_speed() {
        return getMaximum_speed();
    }

    public void setMaximum_speed(int newMaxSpeed) {
        maximum_speed = newMaxSpeed;
    }

    public int getCurrent_speed() {
        return current_speed;
    }

    public void setSpeed(int newSpeed) {
        current_speed = newSpeed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String newDirection) {
        direction = newDirection;
    }

    public double getGasTank() {
        return car_gasTank.getGasLevel();
    }

    public void setGas(double diff_amount) {
        if (diff_amount > 0) {
            // add gas, but could not excess the maximum amount of gasTank
            if (diff_amount <= maximum_gasTank - car_gasTank.getGasLevel()) {
                car_gasTank.addGas(diff_amount);
                return;
            } else {
                car_gasTank.addGas(maximum_gasTank - car_gasTank.getGasLevel());
            }
        } else {
            // use gas, but could not excess the current gas amount
            if (Math.abs(diff_amount) <= car_gasTank.getGasLevel()) {
                car_gasTank.useGas(Math.abs(diff_amount));
            } else {
                car_gasTank.useGas(car_gasTank.getGasLevel());
            }
        }
    }

    public void accelerate() {
        current_speed += 5;
    }

    public void brake() {
        current_speed -= 5;
    }

}
