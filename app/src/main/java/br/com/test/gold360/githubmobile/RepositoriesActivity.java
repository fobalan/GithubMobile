package br.com.test.gold360.githubmobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.test.gold360.githubmobile.adapters.RepositoryAdapter;
import br.com.test.gold360.githubmobile.dto.RepositorySync;
import br.com.test.gold360.githubmobile.listener.RecyclerViewListener;
import br.com.test.gold360.githubmobile.model.Repository;
import br.com.test.gold360.githubmobile.retrofit.RetrofitInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.M)
public class RepositoriesActivity extends AppCompatActivity implements RecyclerView.OnScrollChangeListener, RecyclerViewListener {

    private RecyclerView recyclerView;
    private List<Repository> repositories;
    private LinearLayoutManager linearLayourManager;
    private RepositoryAdapter adapter;
    private static final int pageInitial = 1;
    private int nextPage = pageInitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repositories_activity);

        repositories = new ArrayList<>();
        loadRepositories(pageInitial);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewRepository);
        recyclerView.setOnScrollChangeListener(this);
        recyclerView.setHasFixedSize(true);

        linearLayourManager = new LinearLayoutManager(this);
        linearLayourManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayourManager);

        adapter = new RepositoryAdapter(this, repositories);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void loadRepositories(int page) {
        final ProgressDialog progress = ProgressDialog.show(this,"Aguarde","Buscando dados..",true,true);
        Call<RepositorySync> call = new RetrofitInitializer().getRepositoriesService().getRepositories("language:kotlin","stars",page);
        call.enqueue(new Callback<RepositorySync>() {
            @Override
            public void onResponse(Call<RepositorySync> call, Response<RepositorySync> response) {
                RepositorySync repositorySync = response.body();
                List<Repository> newRepositories = repositorySync.getRepositories();
                loadList(newRepositories);
                progress.dismiss();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("onFailure", t.getMessage());
                Toast.makeText(RepositoriesActivity.this, "Falha de comunicação com a API, verificar log",Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        if(linearLayourManager != null){
            if(repositories.size() == linearLayourManager.findLastCompletelyVisibleItemPosition() + 1){
                nextPage++;
                loadRepositories(nextPage);
            }
        }
    }

    private void loadList(List<Repository> newRepositories){
        for(Repository repository : newRepositories){
            repositories.add(repository);
            adapter.notifyItemInserted(repositories.size() - 1);
        }
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(this,PullRequestsActivity.class);
        intent.putExtra("repository", repositories.get(position));
        startActivity(intent);
    }
}
