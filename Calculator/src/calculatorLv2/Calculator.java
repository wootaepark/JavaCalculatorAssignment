package calculatorLv2;

import java.util.LinkedList;


public class Calculator {

    private static LinkedList<Double> dictionary; // 참조 변경 불가
    // <연산 순번, 결과 값>, 저장

    private AbstractCalculator calculator; // 생성과 함께 원하는 계산기 타입 설정 가능

    public Calculator(){
        this.calculator = null; // 일단 null 로 지정

    }
    
    public Calculator(AbstractCalculator abstractCalculator) {
        this.calculator = abstractCalculator; // 지정된 연산 타입의 Calculator 로 생성

    }

    public void setOperation(AbstractCalculator abstractCalculator) {
        this.calculator = abstractCalculator; // 계산기 변경하고 싶을 때 사용
    }

    public LinkedList<Double> getDictionary(){ // getter
            return dictionary;
    }
    public static void setDictionary(LinkedList<Double> dictionary) {
        Calculator.dictionary = dictionary;
    }



    public void printResult() {
        for(int i=0;i<dictionary.size();i++){
            System.out.println(i + "번째 인덱스 : " + dictionary.get(i));
        }
    }


    public void modifyResult(int index, double value) { //setter
        if(index < 0 || index >= dictionary.size()){
            System.out.println("허용되지 않는 인덱스 입니다.");
        }
        else{
            dictionary.set(index, value);
            printResult();
        }


    }



    public void deleteResult() {
        if(dictionary.isEmpty()){
            System.out.println("삭제할 요소가 없습니다.");
        }
        else{
            System.out.println("첫 번째 요소인 " +dictionary.poll() + "을 삭제합니다.");
            printResult();
        }

    }

    public double calculate(int firstNumber, int secondNumber) {
        // 설정된 계산기를 통해 연산을 하고 해당 결과를 리스트에 추가한 후 반환하는 메서드
        double result = calculator.calculator(firstNumber, secondNumber);
        dictionary.add(result);
        return result;


    }

}
