package com.algonquin.loggy;

import java.util.Arrays;
import java.util.List;

public class File implements Processable, Attachable {

    private String name;
    private String type;
    private String content;
    private Long size;

    public static final List<String> contentTypes = Arrays.asList("MP3", "WAV", "AAC", "PNG", "JPG", "GIF", "SVG", "DOC", "TXT", "PDF");
    
    public File() {
    }

    public File(String name, String type, String content, Long size) {
        this.name = name;
        this.type = type;
        this.content = content;
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public void postProcess() {
        System.out.println("Default post processing");
    }

    @Override
    public void attachFile(String name, String type, String content, Long size) throws Exception {
        if (!isValidContentType(type)) {
            System.out.println("ContentType " + type + " can not be attached");
            throw new Exception("ContentType " + type + " can not be attached");
        }
    }

    @Override
    public void attachFile(File file) throws Exception {
        String type = file.getType();
        if (!isValidContentType(type)) {
            System.out.println("ContentType " + type + " can not be attached");
            throw new Exception("ContentType " + type + " can not be attached");
        }
      //  this.setAttachment(file);
        file.postProcess();
    }

    @Override
    public boolean isValidContentType(String type) {
        return false;
    }

}
