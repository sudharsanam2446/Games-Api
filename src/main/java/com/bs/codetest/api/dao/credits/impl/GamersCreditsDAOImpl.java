package com.bs.codetest.api.dao.credits.impl;

import com.bs.codetest.api.dao.credits.GamersCreditsDAO;
import com.bs.codetest.api.exception.RecoverableException;
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

    /*public static final String FETCH_GAMERS_MAX_CREDIT_BY_LEVEL_QUERY  = "SELECT gamers_credits_id, games_id, gamer_email, credits, level FROM t_gamers_credits "
    + " where (games_id,credits) in (select games_id, max(credits) from t_gamers_credits group by games_id) and level = (:level) ";*/

    public static final String FETCH_GAMERS_MAX_CREDIT_BY_LEVEL_QUERY = "SELECT t.gamers_credits_id, t.games_id,t.gamer_email,t.credits, t.level FROM "
            + "      (SELECT MAX(credits) AS credits, games_id FROM t_gamers_credits where level = (:level) GROUP BY games_id) AS tempInner "
            + "    Inner Join t_gamers_credits t ON tempInner.games_id=t.games_id "
            + "    and tempInner.credits=t.credits "
            + "    where level = (:level) "
            + "    ORDER BY t.games_id DESC";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public GamersCredits persistMessage(GamersCredits modelClass) {
        return persistGamersCredits(modelClass);
    }


    @Override
    public GamersCredits persistGamersCredits(GamersCredits gamersCreditsInfo) {
        throw new RecoverableException("Connection to the database failed, while processing the event. No worries it will be retried !");
        /*Map<String, Object> insertGamersCreditParams = new HashMap<>();
        insertGamersCreditParams.put("level", gamersCreditsInfo.getLevel());
        insertGamersCreditParams.put("credits", gamersCreditsInfo.getCredits());
        insertGamersCreditParams.put("gamesId", gamersCreditsInfo.getGamesId());
        insertGamersCreditParams.put("gamersEmail", gamersCreditsInfo.getGamersEmail());
        namedParameterJdbcTemplate.update(INSERT_GAMERS_CREDIT_INFO_QUERY, insertGamersCreditParams);
        return gamersCreditsInfo;*/
    }

    @Override
    public Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId) throws RecoverableException {
        List<GamersCredits> gamersMaxCreditsList = null;
        Map<String, Object> insertGamersMaxCreditParams = new HashMap<>();
        insertGamersMaxCreditParams.put("level", levelId);
        gamersMaxCreditsList = namedParameterJdbcTemplate.query(FETCH_GAMERS_MAX_CREDIT_BY_LEVEL_QUERY, insertGamersMaxCreditParams, new GamersCreditsMapper());
        return Optional.ofNullable(gamersMaxCreditsList);
    }


}
