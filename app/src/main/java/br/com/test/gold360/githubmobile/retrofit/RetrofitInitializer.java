package br.com.test.gold360.githubmobile.retrofit;

import br.com.test.gold360.githubmobile.services.RepositoriesService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Flavio on 18/08/2017.
 */

public class RetrofitInitializer {
    private final Retrofit retrofit;
     public RetrofitInitializer(){

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
     }

    public RepositoriesService getRepositoriesService() {
        return retrofit.create(RepositoriesService.class);
    }
}
