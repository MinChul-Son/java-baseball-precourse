package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Test
    @DisplayName("컴퓨터가 생성하는 난수는 유니크한 서로 다른 숫자로 이루어져야한다.")
    void 난수() {
        Computer computer = new Computer(1, 9);
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int index = 0; index < computer.getNumber().length(); index++) {
            list.add(String.valueOf(computer.getNumber().charAt(index)));
            set.add(String.valueOf(computer.getNumber().charAt(index)));
        }

        assertThat(list.size()).isEqualTo(set.size());
    }

    @DisplayName("정답을 맞추지못했으므로 볼카운터는 false를 반환해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "923", "64", "237"})
    void 볼카운터_오답(String playerInput) {
        Computer computer = Computer.of("935");
        BaseballChecker checker = new BaseballChecker();

        assertThat(checker.ballCounter(computer.getNumber(), playerInput)).isFalse();
    }

    @Test
    @DisplayName("정답을 맞췄으므로 볼카운터는 true를 반환해야한다.")
    void 볼카운터_정답() {
        Computer computer = Computer.of("935");
        BaseballChecker checker = new BaseballChecker();

        assertThat(checker.ballCounter(computer.getNumber(), "935")).isTrue();
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
