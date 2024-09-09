package calculatorLv2;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        LinkedList<Double> dictionary = new LinkedList<>();
        Calculator.setDictionary(dictionary); // setter 이용


        Scanner scanner = new Scanner(System.in);
        double result = 0.0;


        while (true) {
            try {
                // 입력 부분
                System.out.println("===============================");
                System.out.print("첫 번째 숫자를 입력하세요:");
                int firstNumber = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요:");
                int secondNumber = scanner.nextInt();
                if (firstNumber < 0 || secondNumber < 0) {
                    throw new InputMismatchException();
                }


                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = scanner.next().charAt(0);

                scanner.nextLine(); // 버퍼 비움

                // 연산 부분
                switch (operator) { // enhanced switch 문을 써도 된다.
                    case '+':
                        calculator = new Calculator(new AddCalculator());
                        result = calculator.calculate(firstNumber, secondNumber);
                        break;
                    case '-':
                        calculator = new Calculator(new SubtractCalculator());
                        result = calculator.calculate(firstNumber, secondNumber);
                        break;
                    case '*':
                        calculator = new Calculator(new MultiplyCalculator());
                        result = calculator.calculate(firstNumber, secondNumber);
                        break;
                    case '/':
                        calculator = new Calculator(new DivideCalculator());
                        result = calculator.calculate(firstNumber, secondNumber);
                        break;
                    default:
                        throw new InputOperatorException();
                }

                System.out.println("결과: " + result);
                System.out.println("===============================");
                System.out.println("이전 기록 : ");
                System.out.println(calculator.getDictionary()); // calculator 의 dictionary 에 접근하여 정보 출력




                do{
                    System.out.println("===============================");
                    System.out.println("더 계산하시겠습니까?");
                    System.out.println("view : 저장데이터 보기 //delete : 첫 번째 값 삭제 // change : 값 변경하기 // 아무 키 : 계산기로 // exit : 종료  ");
                    String command = scanner.nextLine();
                    if (command.equalsIgnoreCase("view")) {
                        calculator.printResult();
                    }
                    else if(command.equalsIgnoreCase("delete")){
                        calculator.deleteResult();
                    }
                    else if(command.equalsIgnoreCase("change")){
                        System.out.print("원하는  index, value 를 띄어쓰기로 구분하여 입력해주세요 >>");
                        calculator.modifyResult(scanner.nextInt(), scanner.nextDouble());
                        scanner.nextLine();
                    }
                    else if(command.equalsIgnoreCase("exit")){
                        System.out.println("계산기를 종료합니다.");
                        System.exit(0);
                    }

                    else{
                        break;
                    }

                }while(true);


            } catch (InputMismatchException e) {
                System.out.println("===============================");
                System.out.println("올바른 양의 정수를 입력해주세요");
                scanner.nextLine();

            } catch (InputOperatorException | ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
