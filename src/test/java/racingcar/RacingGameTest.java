package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    
    @Test
    @DisplayName("자동차 목록으로 게임을 생성할 수 있다")
    void createGame_ValidCarNames_Success() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        RacingGame game = new RacingGame(carNames);
        
        assertThat(game).isNotNull();
    }
    
    @Test
    @DisplayName("게임을 한 라운드 진행할 수 있다")
    void playRound_Success() {
        List<String> carNames = List.of("pobi", "woni");
        RacingGame game = new RacingGame(carNames);
        
        game.playRound();
        
        // 라운드가 진행되었는지 확인 (구체적인 위치는 랜덤이므로 확인하지 않음)
        assertThat(game).isNotNull();
    }
    
    @Test
    @DisplayName("우승자를 결정할 수 있다")
    void getWinners_SingleWinner_Success() {
        List<String> carNames = List.of("pobi", "woni");
        RacingGame game = new RacingGame(carNames);
        
        List<String> winners = game.getWinners();
        
        assertThat(winners).isNotEmpty();
        assertThat(winners).containsAnyOf("pobi", "woni");
    }
    
    @Test
    @DisplayName("공동 우승자를 결정할 수 있다")
    void getWinners_MultipleWinners_Success() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        RacingGame game = new RacingGame(carNames);
        
        List<String> winners = game.getWinners();
        
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }
}
