package com.bs.codetest.api.controller.gamers;

import com.bs.codetest.api.ManageGamersApi;
import com.bs.codetest.api.model.GamersInfo;
import com.bs.codetest.api.service.gamers.GamersService;
import com.bs.codetest.api.util.ResponseHandler;
import com.bs.codetest.api.util.ValidationUtils;
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
public class GamersApiController implements ManageGamersApi {

    private final NativeWebRequest request;

    @Autowired
    private GamersService gamersService;

    @Autowired
    public GamersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ManageGamersApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Object> gamersPost(GamersInfo gamersInfo) {
        //todo: add to constants
        ValidationUtils.validateGamersRequest(gamersInfo);
        GamersInfo gamersInfoResponse = gamersService.persistGamers(gamersInfo);
        return ResponseHandler.generateResponse("Successfully added a gamer!", HttpStatus.CREATED, gamersInfoResponse);
    }
}
