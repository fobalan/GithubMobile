package br.com.test.gold360.githubmobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Flavio on 19/08/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository implements Serializable{
    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("owner")
    private RepOwner owner;

    @JsonProperty("stargazers_count")
    private int starsNumber;

    @JsonProperty("forks")
    private int forksNumber;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RepOwner getOwner() {
        return owner;
    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public int getForksNumber() {
        return forksNumber;
    }

    public String getFullName() {
        return fullName;
    }
}
