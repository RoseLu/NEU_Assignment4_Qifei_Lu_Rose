/**
 * Created by qiqi on 2016/10/6.
 */
public class GasTank {
    private Double amount;

    public GasTank() {
        amount = 0.0;
    }

    public void addGas(Double add_amount) {
        amount += add_amount;
    }

    public void useGas(Double use_amount) {
        amount -= use_amount;
    }

    public Double getGasLevel() {
        return amount;
    }

}
