package racingcar.view;

import racingcar.model.dto.FinalWinnersDto;
import racingcar.model.dto.GameResultDto;

public interface OutputView {

    void outputGameRecords(GameResultDto gameResultDto);

    void outputFinalWinners(FinalWinnersDto finalWinnersDto);
}
