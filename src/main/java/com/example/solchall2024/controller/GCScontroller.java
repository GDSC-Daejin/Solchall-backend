package com.example.solchall2024.controller;

import com.example.solchall2024.dto.DownloadReqDto;
import com.example.solchall2024.dto.UploadReqDto;
import com.example.solchall2024.service.GCSservice;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class GCScontroller {

    private final GCSservice gcsservice;

    @PostMapping("gcs/download")
    public ResponseEntity localDownloadFromStorage(@RequestBody DownloadReqDto downloadReqDto) throws IOException {
        String localFileLocation = "C:\\github\\solutionchallenge";
        Blob fileFromGCS = gcsservice.downloadFileFromGCS(downloadReqDto, localFileLocation);
        return ResponseEntity.ok(fileFromGCS.toString());
    }
    @PostMapping("gcs/upload")
    public <uploadReqDto, UploadDto> ResponseEntity localUploadToStorage(@RequestBody UploadReqDto uploadReqDto) throws IOException {
        BlobInfo fileFromGCS = gcsservice.uploadFileToGCS(uploadReqDto);
        return ResponseEntity.ok(fileFromGCS.toString());
    }

}
