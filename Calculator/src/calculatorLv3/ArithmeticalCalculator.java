package calculatorLv3;

import java.util.LinkedList;

public class ArithmeticalCalculator<T extends Number> {
    private static LinkedList<Double> dictionary; // 참조 변경 불가
    // <연산 순번, 결과 값>, 저장

    private AbstractCalculator<T> calculator; // 생성과 함께 원하는 계산기 타입 설정 가능



    public ArithmeticalCalculator() {
        this.calculator = null; // 일단 null 로 지정
    }
    public ArithmeticalCalculator(AbstractCalculator<T> abstractCalculator) {
        this.calculator = abstractCalculator; // 지정된 연산 타입의 ArithmeticalCalculator 생성

    }

    public void setOperation(AbstractCalculator<T> abstractCalculator) {
        this.calculator = abstractCalculator;
    }

    public LinkedList<Double> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(LinkedList<Double> dictionary) {
        ArithmeticalCalculator.dictionary = dictionary; // setter
    }


    public void deleteResult() {
        if (dictionary.isEmpty()) {
            System.out.println("삭제할 요소가 없습니다.");
        } else {
            System.out.println("첫 번째 요소인 " + dictionary.poll() + "을 삭제합니다.");
            printResult();
        }

    }

    public void printResult() { //getter
        for (int i = 0; i < dictionary.size(); i++) {
            System.out.println(i + "번째 인덱스 : " + dictionary.get(i));
        }


    }


    public void modifyResult(int index, double value) { //setter
        if (index < 0 || index >= dictionary.size()) {
            System.out.println("허용되지 않는 인덱스 입니다.");
        } else {
            dictionary.set(index, value);
            printResult();
        }


    }

    public double calculate(T firstNumber, T secondNumber) {

        double result = calculator.calculator(firstNumber, secondNumber);
        dictionary.add(result);
        return result;

    }

    // 입력 받은 값보다 큰 연산 결과들 출력
    public void printResultsGreaterThan(double value) {
        System.out.println("입력 값 " + value + "보다 큰 결과들:");
        dictionary.stream()
                .filter(result -> result > value)
                .forEach(System.out::println);
    }
}
