package repository.persistentclasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FilesPersistentClass {
    @Id
    @Column(name = "FILE_ID")
    private int fileId;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "OWNER")
    private int fileOwner;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "URL")
    private String url;

    public FilesPersistentClass() {
        //Must be
    }

    public FilesPersistentClass(int fileId, String fileName, int fileOwner, String description, String url) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileOwner = fileOwner;
        this.description = description;
        this.url = url;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileOwner() {
        return fileOwner;
    }

    public void setFileOwner(int fileOwner) {
        this.fileOwner = fileOwner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
