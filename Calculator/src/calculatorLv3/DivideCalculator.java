package calculatorLv3;

public class DivideCalculator<T extends Number> extends AbstractCalculator<T> {

    @Override
    public double calculator(Number firstNumber, Number secondNumber) {
        if(secondNumber.doubleValue() == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return   firstNumber.doubleValue() / secondNumber.doubleValue();
    }
}

//트러블 슈팅
