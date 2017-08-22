package br.com.test.gold360.githubmobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Flavio on 19/08/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullReqUser {
    @JsonProperty("login")
    private String name;

    @JsonProperty("avatar_url")
    private String avatar;
}
