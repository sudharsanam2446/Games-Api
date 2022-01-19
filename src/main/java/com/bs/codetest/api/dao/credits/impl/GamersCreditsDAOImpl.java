package com.bs.codetest.api.dao.credits.impl;

import com.bs.codetest.api.dao.credits.GamersCreditsDAO;
import com.bs.codetest.api.model.GamersCredits;
import com.bs.codetest.api.util.mappers.GamersCreditsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class GamersCreditsDAOImpl implements GamersCreditsDAO {

    private static final Logger logger = LoggerFactory.getLogger(GamersCreditsDAOImpl.class);

    public static final String INSERT_GAMERS_CREDIT_INFO_QUERY = "INSERT INTO t_gamers_credits (level, credits, games_id, gamer_email) "
            + "VALUES (:level, :credits, :gamesId, :gamersEmail)";

    public static final String FETCH_GAMERS_MAX_CREDIT_BY_LEVEL_QUERY  = "SELECT gamers_credits_id, games_id, gamer_email, credits, level FROM t_gamers_credits "
    + " where (games_id,credits) in (select games_id, max(credits) from t_gamers_credits group by games_id) and level = (:level) ";

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

    @Override
    public Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId) {
        List<GamersCredits> gamersMaxCreditsList = null;
        Map<String, Object> insertGamersMaxCreditParams = new HashMap<>();
        insertGamersMaxCreditParams.put("level", levelId);
        gamersMaxCreditsList = namedParameterJdbcTemplate.query(FETCH_GAMERS_MAX_CREDIT_BY_LEVEL_QUERY, insertGamersMaxCreditParams, new GamersCreditsMapper());
        return Optional.ofNullable(gamersMaxCreditsList);
    }

}
