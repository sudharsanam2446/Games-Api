package com.bs.codetest.api.dao.credits;

import com.bs.codetest.api.exception.RecoverableException;
import com.bs.codetest.api.model.GamersCredits;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

import java.util.List;
import java.util.Optional;

public interface GamersCreditsDAO extends BaseServiceDelegateInterface<GamersCredits> {

    GamersCredits persistGamersCredits(GamersCredits gamersCreditsInfo);

    Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId) throws RecoverableException;
}
