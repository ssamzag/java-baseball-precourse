package baseball.model;

import baseball.exception.BaseballIllegalArgumentException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbersFactory {
    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력해 주세요.";
    private static final String NUMBER_LENGTH_MESSAGE = "3자리를 입력해 주세요.";
    private static final int NUMBER_COUNT = 3;

    public static BaseballNumbers create(String numbers) {
        return new BaseballNumbers(toBaseballNumbers(split(numbers)));
    }

    public static BaseballNumbers create(List<Integer> numbers) {
        validateDuplicatedNumber(numbers);
        return new BaseballNumbers(numbers);
    }

    private static String[] split(String numbers) {
        validateNumbers(numbers);
        return numbers.split("");
    }

    private static void validateNumbers(String inputStringNumbers) {
        if (!isNumber(inputStringNumbers)) {
            throw new BaseballIllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
        if (inputStringNumbers.length() != NUMBER_COUNT) {
            throw new BaseballIllegalArgumentException(NUMBER_LENGTH_MESSAGE);
        }
    }

    private static boolean isNumber(String s) {
        return s.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static List<Integer> toBaseballNumbers(String[] numbersArray) {
        List<Integer> numbers = createIntegerList(numbersArray);
        validateDuplicatedNumber(numbers);
        return numbers;
    }

    private static List<Integer> createIntegerList(String[] numbersArray) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : numbersArray) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() < NUMBER_COUNT) {
            throw new BaseballIllegalArgumentException("중복된 숫자를 입력하셨습니다.");
        }
    }

}
