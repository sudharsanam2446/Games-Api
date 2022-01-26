package com.bs.codetest.api.service.games.impl;

import com.bs.codetest.api.dao.games.GamesDAO;
import com.bs.codetest.api.exception.NonRecoverableException;
import com.bs.codetest.api.exception.RecoverableException;
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
        return gamesDAO.persistGame(gameInfo);
    }

    @Override
    public GameInfo recoveryHook(RecoverableException e, GameInfo gameInfo) {
        logger.error("Retries exhausted for gameInfo entity with name {} ", gameInfo.getName());
        throw new NonRecoverableException("Retries exhausted for this transaction", e.getCause());
    }
}



