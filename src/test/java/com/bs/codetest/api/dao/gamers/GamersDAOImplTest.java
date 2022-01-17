package com.bs.codetest.api.dao.gamers;

import com.bs.codetest.api.dao.gamers.impl.GamersDAOImpl;
import com.bs.codetest.api.model.GamersInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

//import static org.mockito.Matchers.anyMap;
//import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

class GamersDAOImplTest {

    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    GamersDAOImpl gamersDAOImpl;

    private GamersInfo gamersInfo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gamersInfo = new GamersInfo();
        gamersInfo.setEmail("sudharsanam.balaji@gmail.com");
        gamersInfo.setName("balaji");
        gamersInfo.setNickname("balaji");
        gamersInfo.setGender(GamersInfo.GenderEnum.MALE);
        gamersInfo.setGeo(GamersInfo.GeoEnum.ASIA);
    }

    @Test
    void persistGamersTest() {
        when(namedParameterJdbcTemplate.update(anyString(), anyMap())).thenReturn(1);
        gamersDAOImpl.persistGamers(gamersInfo);
        verify(namedParameterJdbcTemplate, times(1)).update(anyString(), anyMap());
    }
}
