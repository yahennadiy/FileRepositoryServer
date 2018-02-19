package repository.persistentclasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FilesPersistentClass {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "URL")
    private String url;

    public FilesPersistentClass() {
        //Must be
    }

    public FilesPersistentClass(String fileName, String description, String url) {
        this.fileName = fileName;
        this.description = description;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
