package baseball;

import nextstep.utils.Randoms;

public class Computer {

    protected final int number;

    public Computer(final int start, final int end) {
        this.number = generateRandomNumber(start, end);
    }

    private int generateRandomNumber(final int start, final int end) {
        return Integer.valueOf(String.valueOf(Randoms.pickNumberInRange(start, end))
                + String.valueOf(Randoms.pickNumberInRange(start, end))
                + String.valueOf(Randoms.pickNumberInRange(start, end)));
    }

}
