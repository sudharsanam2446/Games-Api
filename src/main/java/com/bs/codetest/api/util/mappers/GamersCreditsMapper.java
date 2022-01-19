package com.bs.codetest.api.util.mappers;

import com.bs.codetest.api.model.GamersCredits;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GamersCreditsMapper implements RowMapper<GamersCredits> {


    @Override
    public GamersCredits mapRow(ResultSet rs, int rowNum) throws SQLException {
        GamersCredits gc = new GamersCredits();
        gc.setGamersCreditsId(rs.getInt("gamers_credits_id"));
        gc.setLevel(rs.getString("level"));
        gc.setCredits(rs.getInt("credits"));
        gc.setGamesId(rs.getString("games_id"));
        gc.setGamersEmail(rs.getString("gamer_email"));
        return gc;
    }
}
