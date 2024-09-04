package calculatorLv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int firstNumber, secondNumber;
        double result = 0;
        String operator, command; // 연산자, 유저가 계속할 지 입력 받는 필드

        while (true) {
            try {

                System.out.println("=========================");
                System.out.print("첫 번째 숫자를 입력하세요: ");
                firstNumber = scanner.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNumber = scanner.nextInt();

                if(firstNumber < 0 || secondNumber < 0){
                    System.out.println("음의 정수를 입력함. 양의 정수를 입력해주세요");
                    continue;
                }

                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.next();

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if(secondNumber == 0){
                            throw new ArithmeticException();
                        }
                        result = (double) firstNumber / secondNumber;
                        break;
                    default:
                        System.out.println("올바른 연산자를 입력해주세요");
                        continue;

                }

                System.out.println("결과: " + result);
                scanner.nextLine(); // 버퍼 비우기
                System.out.println("=========================");
                System.out.println("더 계산하시겠습까? (exit 입력 시 종료, 계속하려면 아무 문자 입력)");
                command = scanner.nextLine(); // 커맨드 입력


                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("계산기 종료");
                    break;
                }
            }
            catch(ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다.");
            }
            catch(InputMismatchException e){
                System.out.println("올바른 형태의 양의 정수를 입력해주세요.");
                scanner.nextLine(); // 버퍼 비움 (안 그러면 무한 루프 발생)
            }
        }


        scanner.close();
    }
}
