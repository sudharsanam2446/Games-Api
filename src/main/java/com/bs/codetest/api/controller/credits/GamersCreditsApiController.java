package com.bs.codetest.api.controller.credits;

import com.bs.codetest.api.ManageGamersCreditsApi;
import com.bs.codetest.api.model.GamersCredits;
import com.bs.codetest.api.service.credits.GamersCreditsService;
import com.bs.codetest.api.util.ResponseHandler;
import com.bs.codetest.api.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-07T21:08:36.685439100+05:30[Asia/Calcutta]")
@Controller
@RequestMapping("${openapi.bs.base-path:/1.0}")
public class GamersCreditsApiController implements ManageGamersCreditsApi {

    private final NativeWebRequest request;

    @Autowired
    private GamersCreditsService gamersCreditsService;

    @Autowired
    public GamersCreditsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ManageGamersCreditsApi.super.getRequest();
    }


    @Override
    public ResponseEntity<Object> creditsPost(GamersCredits gamersCredits) {
        ValidationUtils.validateGamersCreditsPostRequest(gamersCredits);
        GamersCredits gamersCreditsResponse = gamersCreditsService.persistCreditInfo(gamersCredits);
        //todo: add to constants
        return ResponseHandler.generateResponse("Successfully added a gamer!", HttpStatus.CREATED, gamersCreditsResponse);
    }

    @Override
    public ResponseEntity<List<GamersCredits>> getCredits(String level) {
        ValidationUtils.validateGamersGetMaxCreditsRequest(level);
        Optional<List<GamersCredits>> gamersCreditsResponse = gamersCreditsService.getGamersMaxCreditByLevel(level);
        return new ResponseEntity<List<GamersCredits>>(gamersCreditsResponse.get(), HttpStatus.OK);
    }
}
