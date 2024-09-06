package calculatorLv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArithmeticalCalculator<Number> arithmeticalCalculator;
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;


        while (true) {
            try {
                // 입력 부분
                System.out.println("===============================");
                System.out.print("첫 번째 숫자를 입력하세요:");
                Number firstNumber= readNumber(scanner);
                System.out.print("두 번째 숫자를 입력하세요:");
                Number secondNumber= readNumber(scanner);
                if (firstNumber.doubleValue() < 0 || secondNumber.doubleValue() < 0) {
                    throw new InputMismatchException();
                }


                System.out.print("사칙연산 기호를 입력하세요: ");
                String operatorInput = scanner.next();
                OperatorType operator = getOperatorType(operatorInput);

                scanner.nextLine(); // 버퍼 비움

                // 연산 부분
                switch (operator) { // enhanced switch 문을 써도 된다.
                    case ADD:
                        arithmeticalCalculator = new ArithmeticalCalculator<>(new AddCalculator<>());
                        result = arithmeticalCalculator.calculate(firstNumber, secondNumber);
                        break;
                    case SUB:
                        arithmeticalCalculator = new ArithmeticalCalculator<>(new SubstractCalculator<>());
                        result = arithmeticalCalculator.calculate(firstNumber, secondNumber);
                        break;
                    case MUL:
                        arithmeticalCalculator = new ArithmeticalCalculator<>(new MultiplyCalculator<>());
                        result = arithmeticalCalculator.calculate(firstNumber, secondNumber);
                        break;
                    case DIV:
                        arithmeticalCalculator = new ArithmeticalCalculator<>(new DivideCalculator<>());
                        result = arithmeticalCalculator.calculate(firstNumber, secondNumber);
                        break;
                    default:
                        throw new InputOperatorException();
                }

                System.out.println("결과: " + result);


                System.out.println("===============================");
                arithmeticalCalculator.printResultsGreaterThan(result); // 저장된 값중 현재 입력 값 보다 큰 값


                do {
                    System.out.println("===============================");
                    System.out.println("더 계산하시겠습니까?");
                    System.out.println("view : 저장데이터 보기 //delete : 첫 번째 값 삭제 // change : 값 변경하기 // 아무 키 : 계산기로 // exit : 종료  ");
                    String command = scanner.nextLine();
                    if (command.equalsIgnoreCase("view")) {
                        arithmeticalCalculator.getResult();
                    } else if (command.equalsIgnoreCase("delete")) {
                        arithmeticalCalculator.deleteResult();
                    } else if (command.equalsIgnoreCase("change")) {
                        System.out.print("원하는  index, value 를 띄어쓰기로 구분하여 입력해주세요 >>");
                        arithmeticalCalculator.modifyResult(scanner.nextInt(), scanner.nextDouble());
                        scanner.nextLine();
                    } else if (command.equalsIgnoreCase("exit")) {
                        System.out.println("계산기를 종료합니다.");
                        System.exit(0);
                    } else {
                        break;
                    }

                } while (true);


            } catch (InputMismatchException e) {
                System.out.println("===============================");
                System.out.println("올바른 양의 정수를 입력해주세요");
                scanner.nextLine();

            } catch (InputOperatorException | ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    // 입력이 정수인지 실수인지 구분하는 함수
    public static Number readNumber(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            throw new InputMismatchException();
        }
    }
    public static OperatorType getOperatorType(String operator) throws InputOperatorException {
        for (OperatorType op : OperatorType.values()) {
            if (op.getOperator().equals(operator)) {
                return op;
            }
        }
        throw new InputOperatorException();
    }
}

