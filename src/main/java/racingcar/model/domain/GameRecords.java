package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;

public class GameRecords {

    private final Map<Integer, Game> gameRecords = new HashMap<>();

    public void record(int round, Game game) {
        gameRecords.put(round, game);
    }
}
