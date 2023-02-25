package com.bolton.patpat.controller;

import com.bolton.patpat.dto.json.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bolton.patpat.constant.ResponseCodes.OPERATION_SUCCESS;
import static com.bolton.patpat.constant.ResponseCodes.SUCCESS_RESPONSE;

@RestController
@CrossOrigin
@RequestMapping("server/status/check")
public class ServerStatusController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> serverStatusCheck() {
        return new ResponseEntity<>(new CommonResponse(OPERATION_SUCCESS, "Server Status : RUNNING"), HttpStatus.OK);
    }
}
