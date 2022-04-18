package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Random {
    public static List<Integer> pickUniqueNumbersInRange(final int startInclusive, final int endInclusive, final int count) {
        HashSet<Integer> randomNumbers = new LinkedHashSet<>();

        do {
            randomNumbers.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        } while (count != randomNumbers.size());

        return new ArrayList<>(randomNumbers);
    }
}
