package baseball;

import nextstep.utils.Console;

import static java.lang.String.valueOf;

public class Application {

    private static final int ZERO = 0;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int FULL_COUNT = 3;

    public static void main(String[] args) {

        Computer computer = new Computer(START_NUMBER, END_NUMBER);
        BaseballChecker baseballChecker = new BaseballChecker();
        Player player = new Player();

        System.out.println("안녕하세요! 야구 게임을 시작합니다.");
        System.out.println("3자리 숫자를 입력해주세요.");

        while (true) {
            String playerInput = player.generatePlayerInput();

            if (!verifyPlayerInput(playerInput)) {
                System.out.println("[ERROR] : 잘못된 입력값입니다! 다시 입력해주세요!");
                continue;
            }

            baseballChecker.ballCounter(computer.getNumber(), playerInput);

            if (!checkBallCount(baseballChecker)) {
                baseballChecker.resetCounter();
                continue;
            }

            if (again()) {
                System.out.println("게임을 다시 시작합니다!");
                computer = new Computer(START_NUMBER, END_NUMBER);
                baseballChecker.resetCounter();
                continue;
            }

            System.out.println("게임 끝!");
            break;
        }
    }

    /**
     * 게임을 한번 더 하는지를 판단하는 함수
     * 사용자의 입력값을 통해 1이면 새로 시작, 2이면 종료
     *
     * @return 사용자의 입력값이 1이라면 True, 2라면 False
     */
    private static boolean again() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        if (Console.readLine().equals("1")) {
            return true;
        }
        return false;
    }

    /**
     * 사용자의 입력값을 검증하는 함수
     * - 숫자인지?
     * - 3자리로 이루어졌는지?
     *
     * @param playerInput : 사용자의 입력값
     * @return 입력값에 문제가 없다면 True, 문제가 있다면 False
     */
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

    /**
     * BaseballChecker의 판독을 통해 결과를 출력하고 게임의 방향을 알려주는 함수
     *
     * @param baseballChecker : 판독 결과
     * @return 정답을 맞췄다면 True, 오답이라면 False
     */
    private static boolean checkBallCount(final BaseballChecker baseballChecker) {
        if (baseballChecker.getStrike() == FULL_COUNT) {
            System.out.println(baseballChecker.getStrike() + valueOf(Result.스트라이크));
            System.out.println("3개의 숫자를 모두 맞췄습니다! 게임종료");
            return true;
        }

        if (baseballChecker.getBall() == ZERO && baseballChecker.getStrike() == ZERO) {
            System.out.println(Result.낫싱);
            return false;
        }


        System.out.println(baseballChecker.getStrike() + Result.스트라이크.toString() + " " + baseballChecker.getBall() + (Result.볼));
        return false;
    }

}
