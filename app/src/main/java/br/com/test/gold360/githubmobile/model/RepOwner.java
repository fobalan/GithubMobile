package br.com.test.gold360.githubmobile.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Flavio on 19/08/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepOwner implements Serializable {

    @JsonProperty("login")
    private String name;

    @JsonProperty("avatar_url")
    private String avatarUrl;


    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }


}
