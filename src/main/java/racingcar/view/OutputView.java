package racingcar.view;

import java.util.Map;
import racingcar.model.dto.GameResultDto;

public interface OutputView {

    void outputGameRecords(GameResultDto gameResultDto);

    void outputFinalWinners(String winners);
}
