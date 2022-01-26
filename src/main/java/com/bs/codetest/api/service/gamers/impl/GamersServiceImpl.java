package com.bs.codetest.api.service.gamers.impl;

import com.bs.codetest.api.dao.gamers.GamersDAO;
import com.bs.codetest.api.exception.NonRecoverableException;
import com.bs.codetest.api.exception.RecoverableException;
import com.bs.codetest.api.model.GamersInfo;
import com.bs.codetest.api.service.gamers.GamersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamersServiceImpl implements GamersService {

    private static final Logger logger = LoggerFactory.getLogger(GamersServiceImpl.class);

    @Autowired
    GamersDAO gamersDAO;

    @Override
    public GamersInfo persistGamers(GamersInfo gamersInfo) {
        return gamersDAO.processEntity(gamersInfo, "GAMERS_INFO");
    }

    @Override
    public GamersInfo recoveryHook(RecoverableException e, GamersInfo gamersInfo) {
        logger.error("Retries exhausted for GamersCredits entity with email {} ", gamersInfo.getEmail());
        throw new NonRecoverableException("Retries exhausted for this transaction", e.getCause());
    }


}



