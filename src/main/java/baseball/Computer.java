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

    /**
     * 각 자리수의 범위를 지정받아 그에 따른 난수 생성(1 ~ 9)
     * 한자리씩 생성해 유니크한 난수인지를 판단하고 유니크하다면 StringBuilder로 문자열 합침
     *
     * @param start : 숫자 범위
     * @param end : 숫자 범위
     * @return 생성된 난수(String)
     */
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
