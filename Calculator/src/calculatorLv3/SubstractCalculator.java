package calculatorLv3;

public class SubstractCalculator<T extends Number> extends AbstractCalculator<T> {
    @Override
    public double calculator (Number firstNumber, Number secondNumber) {
        return firstNumber.doubleValue() - secondNumber.doubleValue();
    }
}
