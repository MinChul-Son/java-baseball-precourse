package baseball;

import nextstep.utils.Console;

public class Application {

    private static final int ZERO = 0;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public static void main(String[] args) {
        boolean isFin = false;

        Computer computer = new Computer(START_NUMBER, END_NUMBER);

        System.out.println("안녕하세요! 야구 게임을 시작합니다.");
        System.out.println("3자리 숫자를 입력해주세요.");

        while (true) {
            Player player = new Player();
            String playerInput = player.generatePlayerInput();
            BaseballChecker baseballChecker = new BaseballChecker();

            if (!verifyPlayerInput(playerInput)) {
                System.out.println("[ERROR] : 잘못된 입력값입니다! 다시 입력해주세요!");
                continue;
            }

            if (baseballChecker.ballCounter(computer.number, playerInput)) {
                System.out.println(baseballChecker.strike + STRIKE);
                System.out.println("3개의 숫자를 모두 맞췄습니다! 게임종료");
                isFin = again();
            } else if (baseballChecker.ball == ZERO && baseballChecker.strike == ZERO) {
                System.out.println("낫싱");
                continue;
            } else {
                System.out.println(baseballChecker.strike + STRIKE + " " + baseballChecker.ball + BALL);
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

    private static boolean verifyPlayerInput(final String playerInput) {
        // 1. 숫자인지 검증

        if (!playerInput.chars().allMatch(Character::isDigit)) {
            return false;
        }

        // 2. 입력값 길이 검증
        if (playerInput.length() > 3) {
            return false;
        }

        return true;
    }
}
