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

    @JsonProperty("html_url")
    private String url;

    public String getTitle() {
        return title;
    }

    public PullReqUser getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public String getUrl() {
        return url;
    }
}
