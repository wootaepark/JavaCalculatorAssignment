package calculatorLv2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private static final LinkedList<Double> dictionary = new LinkedList<>(); // 참조 변경 불가
    // <연산 순번, 결과 값>, 저장

    private AbstractCalculator calculator; // 생성과 함께 원하는 계산기 타입 설정 가능


    public Calculator(AbstractCalculator abstractCalculator) {
        this.calculator = abstractCalculator;

    }


    public void setOperation(AbstractCalculator abstractCalculator) {
        this.calculator = abstractCalculator;
    }

    public void deleteResult() {
        if(dictionary.isEmpty()){
            System.out.println("삭제할 요소가 없습니다.");
        }
        else{
            System.out.println("첫 번째 요소인 " +dictionary.poll() + "을 삭제합니다.");
            getResult();
        }

    }


    public void modifyResult(int index, double value) { //setter
        if(index < 0 || index >= dictionary.size()){
            System.out.println("허용되지 않는 인덱스 입니다.");
        }
        else{
            dictionary.set(index, value);
            getResult();
        }


    }

    public void getResult() { //getter
        for(int i=0;i<dictionary.size();i++){
            System.out.println(i + "번째 인덱스 : " + dictionary.get(i));
        }


    }

    public double calculate(int firstNumber, int secondNumber) {

        double result = calculator.calculator(firstNumber, secondNumber);
        dictionary.add(result);
        return result;


    }

}
