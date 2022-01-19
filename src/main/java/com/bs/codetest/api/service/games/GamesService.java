package com.bs.codetest.api.service.games;

import com.bs.codetest.api.model.GameInfo;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

public interface GamesService extends BaseServiceDelegateInterface<GameInfo> {

    GameInfo persistGame(GameInfo gameInfo);

}
