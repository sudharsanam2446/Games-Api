package com.bs.codetest.api.controller.gamers;


import com.bs.codetest.api.model.GamersInfo;
import com.bs.codetest.api.service.gamers.GamersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.NativeWebRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@SpringBootTest
public class GamersApiControllerTest {

    @InjectMocks
    GamersApiController gamersApiController;

    @Mock
    GamersService gamersService;

    @Mock
    NativeWebRequest request;

    private GamersInfo gamersInfo;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() throws Exception {
        gamersInfo=new GamersInfo();
        mockMvc= MockMvcBuilders.standaloneSetup(gamersApiController).build();
        ReflectionTestUtils.setField(gamersApiController, "gamersService", gamersService);
    }

    @Test
    void gamersPostTest() throws Exception {
        gamersInfo.setEmail("sudharsanam.balaji@gmail.com");
        gamersInfo.setName("balaji");
        gamersInfo.setNickname("balaji");
        gamersInfo.setGender(GamersInfo.GenderEnum.MALE);
        gamersInfo.setGeo(GamersInfo.GeoEnum.ASIA);
        mockMvc.perform(post("/1.0/gamers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(gamersInfo)))
                .andExpect(status().isCreated());
    }


}
