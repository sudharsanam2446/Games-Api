package com.bs.codetest.api.dao.games;

import com.bs.codetest.api.model.GameInfo;

public interface GamesDAO {
    GameInfo persistGame(GameInfo gameInfo);
}
