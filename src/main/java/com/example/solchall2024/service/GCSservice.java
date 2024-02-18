package com.example.solchall2024.service;

import com.example.solchall2024.request.GCSrequest;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;

@Service
public class GCSservice {

    private String bucketName;

    public void uploadObject(GCSrequest solchallrequest)throws IOException{

        String keyFileName = "omega-moonlight-413423-61d3b94a83d8.json";
        InputStream keyFile = ResourceUtils.getURL("classpath:" + keyFileName).openStream();
        
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(keyFile))
                .build()
                .getService();

        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName,solchallrequest.getFile().getOriginalFilename())
                .setContentType(solchallrequest.getFile().getContentType()).build();
        
        BlobInfo blob = ((Storage) storage).create(blobInfo, solchallrequest.getFile().getInputStream());
    }
}
