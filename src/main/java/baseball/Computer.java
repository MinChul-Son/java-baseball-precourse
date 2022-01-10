package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    protected String number;

    public Computer(final int start, final int end) {
        this.number = generateRandomNumber(start, end);
    }

    private String generateRandomNumber(final int start, final int end) {

        List<Integer> uniqueNumberList = new ArrayList<>();
        int randomNumber;
        StringBuilder stringBuilder = new StringBuilder();


        while (uniqueNumberList.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(start, end);
            if (uniqueNumberList.contains(randomNumber)) {
                continue;
            }
            uniqueNumberList.add(randomNumber);
        }

        for (Integer number : uniqueNumberList) {
            stringBuilder.append(number);
        }

        return stringBuilder.toString();
    }

}
