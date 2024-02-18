package com.example.solchall2024.controller;

import com.example.solchall2024.request.GCSrequest;
import com.example.solchall2024.service.GCSservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GCScontroller {
    private final GCSservice solchallservice;

    @PostMapping("/api/solchall/upload")
    public ResponseEntity<Void> objectUpload(GCSrequest solchallrequest) throws IOException{
        solchallservice.uploadObject(solchallrequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
