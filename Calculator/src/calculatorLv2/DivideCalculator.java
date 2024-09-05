package calculatorLv2;

public class DivideCalculator extends AbstractCalculator{
    @Override
    public double calculator(int firstNumber, int secondNumber) {
        if(secondNumber == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return  (double)firstNumber / secondNumber;
    }
}
