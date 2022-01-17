package com.bs.codetest.api.dao.gamers.impl;

import com.bs.codetest.api.dao.gamers.GamersDAO;
import com.bs.codetest.api.model.GamersInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GamersDAOImpl implements GamersDAO {

    private static final Logger logger = LoggerFactory.getLogger(GamersDAOImpl.class);

    public static final String INSERT_GAMERS_INFO_QUERY = "INSERT INTO t_gamers (name, nick_name, gender, email, geo) "
            + "VALUES (:name, :nickName, :gender, :email, :geo)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public GamersInfo persistGamers(GamersInfo gamersInfo) {
        Map<String, Object> insertGamersParams = new HashMap<>();
        insertGamersParams.put("name", gamersInfo.getName());
        insertGamersParams.put("nickName", gamersInfo.getNickname());
        insertGamersParams.put("gender", gamersInfo.getGender());
        insertGamersParams.put("email", gamersInfo.getEmail());
        insertGamersParams.put("geo", gamersInfo.getGeo());
        namedParameterJdbcTemplate.update(INSERT_GAMERS_INFO_QUERY, insertGamersParams);
        return gamersInfo;
    }
}
