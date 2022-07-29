package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private String name;
    private String yearReleased;
    private String description;
    private String url;


    public Movie() {}

    public Movie(String name, String yearReleased, String description, String url){

        this.name = name;
        this.yearReleased = yearReleased;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYearReleased() {
        return yearReleased;
    }
    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Name:'" + name + '\'' +
                "Released:'" + yearReleased + '\'' +
                "Description:'" + description + '\'' +
                "Link:'" + url + '\'';

    }


}
