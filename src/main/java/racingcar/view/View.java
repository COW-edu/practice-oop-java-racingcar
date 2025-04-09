package racingcar.view;

import java.util.List;

public interface View {
    String[] readCarNames();
    int readAttempts();
    void printRaceStart();
    void printRoundResult(String roundResult);
    void printWinners(List<String> winners);
}