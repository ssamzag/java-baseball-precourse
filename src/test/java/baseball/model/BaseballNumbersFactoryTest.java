package baseball.model;

import baseball.exception.BaseballIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumbersFactoryTest {

    @Test
    @DisplayName("String 인자로 Factory 메소드로 객체를 생성한다 ")
    void createFromString() {
        BaseballNumbers integers = BaseballNumbersFactory.create("123");
        assertThat(integers.getRound(0)).isEqualTo(1);
        assertThat(integers.getRound(1)).isEqualTo(2);
        assertThat(integers.getRound(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("List<Integer> 인자로 Factory 메소드로 객체를 생성한다 ")
    void createFromIntegerList() {
        BaseballNumbers integers = BaseballNumbersFactory.create(Arrays.asList(1, 2, 3));
        assertThat(integers.getRound(0)).isEqualTo(1);
        assertThat(integers.getRound(1)).isEqualTo(2);
        assertThat(integers.getRound(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("4개의 숫자 입력시 예외가 발생한다")
    void overNumbersException() {
        assertThatExceptionOfType(BaseballIllegalArgumentException.class).isThrownBy(() -> {
            BaseballNumbersFactory.create("1234");
        });
    }

    @Test
    @DisplayName("숫자 외 문자 입력시 예외가 발생한다")
    void wrongStringException() {
        assertThatExceptionOfType(BaseballIllegalArgumentException.class).isThrownBy(() -> {
            BaseballNumbersFactory.create("12a");
        });
    }

    @Test
    @DisplayName("중복숫자 입력시 예외가 발생한다")
    void duplicatedNumbersException() {
        assertThatExceptionOfType(BaseballIllegalArgumentException.class).isThrownBy(() -> {
            BaseballNumbersFactory.create("122");
        });
    }
}
