package br.com.test.gold360.githubmobile.services;

import java.util.List;

import br.com.test.gold360.githubmobile.model.PullRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Flavio on 22/08/2017.
 */

public interface PullRequestsService {
    @Headers({
            "Accept: application/json"
    })

    @GET("repos/{owner}/{repository}/pulls")
    Call <List<PullRequest>> getPullRequests(@Path("owner") String owner,
                                             @Path("repository") String repository);
}