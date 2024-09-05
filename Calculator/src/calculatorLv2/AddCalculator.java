package calculatorLv2;

public class AddCalculator extends AbstractCalculator{
    
    
    @Override // 오버라이딩
    public double calculator(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

}
