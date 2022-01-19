package com.bs.codetest.api.dao.credits;

import com.bs.codetest.api.model.GamersCredits;

import java.util.List;
import java.util.Optional;

public interface GamersCreditsDAO {
    GamersCredits persistGamersCredits(GamersCredits gamersCreditsInfo);

    Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId);
}
