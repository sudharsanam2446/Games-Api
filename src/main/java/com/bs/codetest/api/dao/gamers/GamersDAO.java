package com.bs.codetest.api.dao.gamers;

import com.bs.codetest.api.model.GamersInfo;

public interface GamersDAO {
    GamersInfo persistGamers(GamersInfo gamersInfo);
}
