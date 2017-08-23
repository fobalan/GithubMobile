package br.com.test.gold360.githubmobile.services;

import java.util.Objects;

import br.com.test.gold360.githubmobile.dto.RepositorySync;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Flavio on 18/08/2017.
 */

public interface RepositoriesService {
    @Headers({
            "Accept: application/json"
    })

    @GET("search/repositories")
    Call<RepositorySync> getRepositories(@Query("q") String paramQ,
                             @Query("sort") String sort,
                             @Query("page") int page);
}
