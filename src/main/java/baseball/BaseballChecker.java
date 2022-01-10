package baseball;

public class BaseballChecker {

    private final static int ZERO = 0;
    private final static int LAST_INDEX = 3;

    private int ball;
    private int strike;


    public BaseballChecker() {
        this.ball = ZERO;
        this.strike = ZERO;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    /**
     * 컴퓨터의 값과 사용자의 값을 비교해 볼과 스트라이크를 하나씩 증가시킴
     *
     * @param computer : 컴퓨터가 생성한 난수
     * @param player : 플레이어 입력값
     * @return 모두 맞췄다면 True, 그렇지 않다면 False
     */
    public boolean ballCounter(final String computer, final String player) {
        // 정답! - 얼리 리턴
        if (computer.equals(player)) {
            strike = 3;
            return true;
        }

        // 볼 & 스트라이크
        for (int extractIndex = ZERO; extractIndex < LAST_INDEX; extractIndex++) {
            if (computer.substring(extractIndex, extractIndex + 1).equals(player.substring(extractIndex, extractIndex + 1))) {
                this.strike++;
                continue;
            }

            if (computer.indexOf(player.substring(extractIndex, extractIndex + 1)) >= 0) {
                ball++;
            }
        }
        return false;
    }

    public void resetCounter() {
        this.ball = ZERO;
        this.strike = ZERO;
    }

}
