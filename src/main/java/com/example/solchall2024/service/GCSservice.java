package com.example.solchall2024.service;

import com.example.solchall2024.dto.DownloadReqDto;
import com.example.solchall2024.dto.UploadReqDto;
import com.google.cloud.storage.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class GCSservice {

    private final Storage storage;

    public BlobInfo uploadFileToGCS(UploadReqDto uploadReqDto) throws IOException {
        String localFileLocation = uploadReqDto.getLocalFileLocation();
        String uploadFileName = uploadReqDto.getUploadFileName();
        String bucketName = uploadReqDto.getBucketName();
        String contentType = uploadReqDto.getContentType();

        try {
            BlobInfo blobInfo = storage.create(
                    BlobInfo.newBuilder(bucketName, uploadFileName)
                            .setContentType(contentType)
                            .build(),
                    new FileInputStream(localFileLocation));
            return blobInfo;
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // 업로드 실패 시 IOException 예외 전파
        }
    }

    public Blob downloadFileFromGCS(DownloadReqDto downloadReqDto, String localFileLocation) throws IOException {
        String bucketName = downloadReqDto.getBucketName();
        String downloadFileName = downloadReqDto.getDownloadFileName();

        Blob blob = storage.get(bucketName, downloadFileName);
        if (blob == null) {
            throw new FileNotFoundException("Blob not found: " + downloadFileName);
        }

        blob.downloadTo(Paths.get(localFileLocation));
        return blob;
    }

}
