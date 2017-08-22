package br.com.test.gold360.githubmobile;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import br.com.test.gold360.githubmobile.adapters.RepositoryAdapter;
import br.com.test.gold360.githubmobile.dto.RepositorySync;
import br.com.test.gold360.githubmobile.model.Repository;
import br.com.test.gold360.githubmobile.retrofit.RetrofitInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.M)
public class RepositoriesActivity extends AppCompatActivity implements RecyclerView.OnScrollChangeListener {

    private RecyclerView recyclerView;
    private List<Repository> repositories;
    private LinearLayoutManager linearLayourManager;
    private RepositoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repositories_activity);

        loadRepositories();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setOnScrollChangeListener(this);
        recyclerView.setHasFixedSize(true);

        linearLayourManager = new LinearLayoutManager(this);
        linearLayourManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayourManager);
    }

    private void loadRepositories() {
        final ProgressDialog progress = ProgressDialog.show(this,"Aguarde","Buscando dados..",true,true);
        Call<RepositorySync> call = new RetrofitInitializer().getRepositoriesService().get("language:kotlin","stars",1);
        call.enqueue(new Callback<RepositorySync>() {
            @Override
            public void onResponse(Call<RepositorySync> call, Response<RepositorySync> response) {
                RepositorySync repositorySync = response.body();
                repositories = repositorySync.getRepositories();
                loadList();
                progress.dismiss();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        if(linearLayourManager != null){
            if(repositories.size() == linearLayourManager.findLastCompletelyVisibleItemPosition()){
                Log.i("onLastItem", "ultimo item");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void loadList(){
        adapter = new RepositoryAdapter(this,repositories);
        recyclerView.setAdapter(adapter);
    }
}
