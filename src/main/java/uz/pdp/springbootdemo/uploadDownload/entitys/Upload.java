package uz.pdp.springbootdemo.uploadDownload.entitys;

import lombok.Data;

@Data
public class Upload {
    private String originalName;
    private String generatedName;
    private long size;
    private String mimeType;
    private String uploadedPath;
}
