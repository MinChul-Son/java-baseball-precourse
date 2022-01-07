package baseball;

public class BaseballChecker {

    protected int ball;
    protected int strike;

    private final static int ZERO = 0;
    private final static int LAST_INDEX = 3;

    public BaseballChecker() {
        this.ball = ZERO;
        this.strike = ZERO;
    }


    public boolean ballCounter(final String computer, final String player) {
        // 정답! - 얼리 리턴
        if (computer.equals(player)) {
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
}
