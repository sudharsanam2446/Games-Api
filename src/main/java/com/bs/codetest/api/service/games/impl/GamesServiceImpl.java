package com.bs.codetest.api.service.games.impl;

import com.bs.codetest.api.dao.games.GamesDAO;
import com.bs.codetest.api.model.GameInfo;
import com.bs.codetest.api.service.games.GamesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesServiceImpl implements GamesService {

    private static final Logger logger = LoggerFactory.getLogger(GamesServiceImpl.class);

    @Autowired
    GamesDAO gamesDAO;

    @Override
    public GameInfo persistGame(GameInfo gameInfo) {
        logger.info(gameInfo.toString());
        gamesDAO.persistGame(gameInfo);
        return gameInfo;
    }
}



