package com.bs.codetest.api.service.credits;

import com.bs.codetest.api.model.GamersCredits;
import com.bs.codetest.api.model.GamersInfo;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

import java.util.List;
import java.util.Optional;

public interface GamersCreditsService extends BaseServiceDelegateInterface<GamersCredits> {

    GamersCredits persistCreditInfo(GamersCredits gamersCredits);

    Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId);


}
