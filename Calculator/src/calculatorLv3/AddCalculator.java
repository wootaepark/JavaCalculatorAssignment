package calculatorLv3;

public class AddCalculator<T extends Number> extends AbstractCalculator<T> {
    
    
    @Override // 오버라이딩
    public double calculator(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() + secondNumber.doubleValue();
    }

}
