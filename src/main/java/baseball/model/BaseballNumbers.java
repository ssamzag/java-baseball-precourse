package baseball.model;

import java.util.Iterator;
import java.util.List;

public class BaseballNumbers implements Iterable<Integer> {
    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    int getRound(int round) {
        return numbers.get(round);
    }

    boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
