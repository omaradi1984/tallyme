package com.algonquin.loggy;

public class AudioFile extends File {

    /**
     *
     */
    public AudioFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        System.out.println("This audio file is going to be transcoded and then closed captioned");
    }
    
    @Override
    public boolean isValidContentType(String type) {
        return AudioFile.contentTypes.contains(type);
    }

   /* @Override
    public void attachFile(String name, String type, String content, Long size) throws Exception {
        super.attachFile(name, type, content, size);
        System.out.println("Attaching " + name + " to " + this.getName());
        this.setAttachment(new AudioFile(name, type, content, size));
        AudioFile attachment = (AudioFile) this.getAttachment();
        attachment.postProcess();
    }*/
}
