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
    public GameInfo persistMessage(GameInfo modelClass) {
        return persistGame(modelClass);
    }

    @Override
    public GameInfo persistGame(GameInfo gameInfo) {
        return gamesDAO.persistGame(gameInfo);
    }
}



