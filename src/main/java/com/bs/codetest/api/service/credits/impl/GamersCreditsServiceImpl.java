package com.bs.codetest.api.service.credits.impl;

import com.bs.codetest.api.dao.credits.GamersCreditsDAO;
import com.bs.codetest.api.exception.NonRecoverableException;
import com.bs.codetest.api.exception.RecoverableException;
import com.bs.codetest.api.model.GamersCredits;
import com.bs.codetest.api.service.credits.GamersCreditsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamersCreditsServiceImpl implements GamersCreditsService {

    private static final Logger logger = LoggerFactory.getLogger(GamersCreditsServiceImpl.class);

    @Autowired
    GamersCreditsDAO gamersCreditsDAO;

    @Override
    public GamersCredits persistCreditInfo(GamersCredits gamersCredits) {
        return gamersCreditsDAO.processEntity(gamersCredits, "GAMERS_CREDITS");
    }

    @Override
    public Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId) {
        //todo: handle sql exceptions or make the get calls generic
        return gamersCreditsDAO.getGamersMaxCreditByLevel(levelId);
    }

    @Override
    public GamersCredits recoveryHook(RecoverableException e, GamersCredits gamersCredits) {
        logger.error("Retries exhausted for GamersCredits entity with email {} ", gamersCredits.getGamersEmail());
        throw new NonRecoverableException("Retries exhausted for this transaction",  e.getCause());
    }


}



