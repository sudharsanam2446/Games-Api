package com.bs.codetest.api.dao.games;

import com.bs.codetest.api.model.GameInfo;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

public interface GamesDAO extends BaseServiceDelegateInterface<GameInfo> {
    GameInfo persistGame(GameInfo gameInfo);
}
