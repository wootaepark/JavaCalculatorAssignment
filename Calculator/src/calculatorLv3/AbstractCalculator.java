package calculatorLv3;

public abstract class AbstractCalculator<T extends Number> {

    public abstract double calculator(T firstNumber,T secondNumber);
}
