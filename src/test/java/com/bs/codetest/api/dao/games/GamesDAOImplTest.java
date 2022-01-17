package com.bs.codetest.api.dao.games;

import com.bs.codetest.api.dao.games.impl.GamesDAOImpl;
import com.bs.codetest.api.model.GameInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

//import static org.mockito.Matchers.anyMap;
//import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

class GamesDAOImplTest {

    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    GamesDAOImpl gamesDAOImpl;

    private GameInfo gameInfo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gameInfo = new GameInfo();
        gameInfo.setName("tic tac toe");
        gameInfo.setDescription("my awesome tic tac toe");
    }

    @Test
    void persistGamersTest() {
        when(namedParameterJdbcTemplate.update(anyString(), anyMap())).thenReturn(1);
        gamesDAOImpl.persistGame(gameInfo);
        verify(namedParameterJdbcTemplate, times(1)).update(anyString(), anyMap());
    }
}
