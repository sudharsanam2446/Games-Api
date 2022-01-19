package com.bs.codetest.api.service.gamers;

import com.bs.codetest.api.model.GamersInfo;
import com.bs.codetest.api.service.base.BaseServiceDelegateInterface;

public interface GamersService extends BaseServiceDelegateInterface<GamersInfo>  {

    GamersInfo persistGamers(GamersInfo GamersInfo);

}
