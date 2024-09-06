package calculatorLv3;

public class MultiplyCalculator<T extends Number> extends AbstractCalculator<T> {

    @Override
    public double calculator(Number firstNumber, Number secondNumber){
        return  firstNumber.doubleValue() * secondNumber.doubleValue();
    }
}
