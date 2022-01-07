package baseball;

import nextstep.utils.Randoms;

public class Computer {

    protected final String number;

    public Computer(final int start, final int end) {
        this.number = generateRandomNumber(start, end);
    }

    private String generateRandomNumber(final int start, final int end) {
        return String.valueOf(Randoms.pickNumberInRange(start, end))
                + String.valueOf(Randoms.pickNumberInRange(start, end))
                + String.valueOf(Randoms.pickNumberInRange(start, end));
    }

}
