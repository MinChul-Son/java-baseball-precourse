package baseball;

import nextstep.utils.Console;

public class Application {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static void main(String[] args) {
        boolean isFin = false;

        Computer computer = new Computer(START_NUMBER, END_NUMBER);

        System.out.println("안녕하세요! 야구 게임을 시작합니다.");
        System.out.println("3자리 숫자를 입력해주세요.");
        while (true) {
            String userInput = Console.readLine();
            BaseballChecker baseballChecker = new BaseballChecker();

            if (baseballChecker.ballCounter(computer.number, userInput)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞췄습니다! 게임종료");
                isFin = again();
            } else if (baseballChecker.ball == 0 && baseballChecker.strike == 0) {
                System.out.println("낫싱");
                continue;
            } else {
                System.out.println(baseballChecker.strike + "스트라이크 " + baseballChecker.ball + "볼 ");
                continue;
            }

            if (isFin) {
                System.out.println("게임을 다시 시작합니다!");
                computer = new Computer(START_NUMBER, END_NUMBER);
                continue;
            }
            break;
        }

        System.out.println("게임 끝!");


    }

    private static boolean again() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        if (Console.readLine().equals("1")) {
            return true;
        }

        return false;
    }
}
