package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private String number;

    public Computer(final int start, final int end) {
        this.number = generateRandomNumber(start, end);
    }

    private Computer(String number) {
        this.number = number;
    }

    public static Computer of(final String number) {
        return new Computer(number);
    }

    public String getNumber() {
        return number;
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
