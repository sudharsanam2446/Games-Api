package com.bs.codetest.api.service.gamers.impl;

import com.bs.codetest.api.dao.gamers.GamersDAO;
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
        logger.info(gamersInfo.toString());
        gamersDAO.persistGamers(gamersInfo);
        return gamersInfo;
    }
}



