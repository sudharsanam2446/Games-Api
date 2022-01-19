package com.bs.codetest.api.service.credits;

import com.bs.codetest.api.model.GamersCredits;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

public interface GamersCreditsService extends BaseServiceDelegateInterface<GamersCredits> {

    GamersCredits persistCreditInfo(GamersCredits gamersCredits);

}
