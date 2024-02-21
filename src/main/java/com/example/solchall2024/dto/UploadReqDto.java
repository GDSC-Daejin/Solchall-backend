package com.example.solchall2024.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UploadReqDto {
    private String localFileLocation;
    private String uploadFileName;
    private String bucketName;
    private String contentType;

    public void setLocalFileLocation(String localFileLocation) {
        this.localFileLocation = localFileLocation;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
