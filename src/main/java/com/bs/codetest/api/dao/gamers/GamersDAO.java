package com.bs.codetest.api.dao.gamers;

import com.bs.codetest.api.model.GamersInfo;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

public interface GamersDAO extends BaseServiceDelegateInterface<GamersInfo> {
    GamersInfo persistGamers(GamersInfo gamersInfo);
}
