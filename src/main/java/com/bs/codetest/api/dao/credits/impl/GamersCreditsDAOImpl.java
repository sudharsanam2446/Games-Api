package com.bs.codetest.api.dao.credits.impl;

import com.bs.codetest.api.dao.credits.GamersCreditsDAO;
import com.bs.codetest.api.model.GamersCredits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GamersCreditsDAOImpl implements GamersCreditsDAO {

    private static final Logger logger = LoggerFactory.getLogger(GamersCreditsDAOImpl.class);

    public static final String INSERT_GAMERS_CREDIT_INFO_QUERY = "INSERT INTO t_gamers_credits (level, credits, games_id, gamer_email) "
            + "VALUES (:level, :credits, :gamesId, :gamersEmail)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public GamersCredits persistGamersCredits(GamersCredits gamersCreditsInfo) {
        Map<String, Object> insertGamersCreditParams = new HashMap<>();
        insertGamersCreditParams.put("level", gamersCreditsInfo.getLevel());
        insertGamersCreditParams.put("credits", gamersCreditsInfo.getCredits());
        insertGamersCreditParams.put("gamesId", gamersCreditsInfo.getGamesId());
        insertGamersCreditParams.put("gamersEmail", gamersCreditsInfo.getGamersEmail());
        namedParameterJdbcTemplate.update(INSERT_GAMERS_CREDIT_INFO_QUERY, insertGamersCreditParams);
        return gamersCreditsInfo;
    }

}
