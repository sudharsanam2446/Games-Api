package com.bs.codetest.api.controller.games;

import com.bs.codetest.api.ManageGamesApi;
import com.bs.codetest.api.model.GameInfo;
import com.bs.codetest.api.service.games.GamesService;
import com.bs.codetest.api.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-07T21:08:36.685439100+05:30[Asia/Calcutta]")
@Controller
@RequestMapping("${openapi.bs.base-path:/1.0}")
public class GamesApiController implements ManageGamesApi {

    private final NativeWebRequest request;

    @Autowired
    private GamesService gamesService;

    @Autowired
    public GamesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ManageGamesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Object> gamesPost(GameInfo gameInfo) {
        //todo: add validations
        GameInfo gameInfoResponse = gamesService.processEntity(gameInfo, "GAMES_INFO");
        return ResponseHandler.generateResponse("Successfully added a game!", HttpStatus.CREATED, gameInfoResponse);
    }
}
