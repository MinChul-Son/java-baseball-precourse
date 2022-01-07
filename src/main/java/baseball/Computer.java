package baseball;

import nextstep.utils.Randoms;

public class Computer {

    private final int number;

    public Computer(final int start, final int end) {
        this.number = Randoms.pickNumberInRange(start, end);
    }

}
