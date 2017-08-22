package br.com.test.gold360.githubmobile.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import br.com.test.gold360.githubmobile.model.Repository;

/**
 * Created by Flavio on 20/08/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositorySync {

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("items")
    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }
}
