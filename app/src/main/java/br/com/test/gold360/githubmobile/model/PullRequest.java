package br.com.test.gold360.githubmobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Flavio on 19/08/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("user")
    private PullReqUser user;

    @JsonProperty("created_at")
    private String date;

    @JsonProperty("body")
    private String body;
}
