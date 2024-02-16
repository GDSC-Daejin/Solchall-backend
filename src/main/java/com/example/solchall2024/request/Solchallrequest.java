package com.example.solchall2024.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Solchallrequest {
    private String name;
    private MultipartFile file;
}
