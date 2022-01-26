package com.bs.codetest.api.dao.games.impl;

import com.bs.codetest.api.dao.games.GamesDAO;
import com.bs.codetest.api.model.GameInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GamesDAOImpl implements GamesDAO {

    private static final Logger logger = LoggerFactory.getLogger(GamesDAOImpl.class);

    public static final String INSERT_GAMEINFO_QUERY = "INSERT INTO t_games (name, description) "
            + "VALUES (:name, :description)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public GameInfo persistMessage(GameInfo gameInfo) {
        return persistGame(gameInfo);
    }

    @Override
    public GameInfo persistGame(GameInfo gameInfo) {
        Map<String, Object> insertGameParams = new HashMap<>();
        insertGameParams.put("name", gameInfo.getName());
        insertGameParams.put("description", gameInfo.getDescription());
        namedParameterJdbcTemplate.update(INSERT_GAMEINFO_QUERY, insertGameParams);
        return gameInfo;
    }
}
