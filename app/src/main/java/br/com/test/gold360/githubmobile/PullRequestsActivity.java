package br.com.test.gold360.githubmobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.test.gold360.githubmobile.adapters.PullRequestAdapter;
import br.com.test.gold360.githubmobile.listener.RecyclerViewListener;
import br.com.test.gold360.githubmobile.model.PullRequest;
import br.com.test.gold360.githubmobile.model.Repository;
import br.com.test.gold360.githubmobile.retrofit.RetrofitInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.M)
public class PullRequestsActivity extends AppCompatActivity implements RecyclerViewListener {
    private RecyclerView recyclerView;
    private List<PullRequest> pullRequests;
    private LinearLayoutManager linearLayourManager;
    private PullRequestAdapter adapter;
    private Repository repository;
    private Toolbar toolbar;
    private TextView openPullTextView;
    private TextView closePullTextView;
    private int numberOpen;
    private int numberClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_requests);

        Intent intent = getIntent();
        repository = (Repository) intent.getSerializableExtra("repository");

        openPullTextView = (TextView) findViewById(R.id.openPullTextView);
        closePullTextView = (TextView) findViewById(R.id.closePullTextView);
        toolbar = (Toolbar) findViewById(R.id.pullRequestToolbar);
        toolbar.setTitle(repository.getName());
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        pullRequests = new ArrayList<>();
        loadPullRequests();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPullRequest);
        recyclerView.setHasFixedSize(true);

        linearLayourManager = new LinearLayoutManager(this);
        linearLayourManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayourManager);

        adapter = new PullRequestAdapter(this, pullRequests);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void loadPullRequests() {
        final ProgressDialog progress = ProgressDialog.show(this,"Aguarde","Buscando dados..",true,true);
        Call<List<PullRequest>> call = new RetrofitInitializer()
                .getPullRequestsService()
                .getPullRequests(repository.getOwner().getName(),repository.getName());
        call.enqueue(new Callback<List<PullRequest>>() {
            @Override
            public void onResponse(Call<List<PullRequest>> call, Response<List<PullRequest>> response) {
                List<PullRequest> newPullRequests = response.body();
                loadList(newPullRequests);
                progress.dismiss();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("onFailure", t.getMessage());
                Toast.makeText(PullRequestsActivity.this, "Falha de comunicação com a API, verificar log",Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }

    private void loadList(List<PullRequest> newPullRequests){
        for(PullRequest pullRequest : newPullRequests){
            pullRequests.add(pullRequest);
            adapter.notifyItemInserted(pullRequests.size() - 1);
            if(pullRequest.getState().equals("open")){
                numberOpen++;
            } else {
                numberClose++;
            }
        }
        openPullTextView.setText(numberOpen + " opened ");
        closePullTextView.setText("/ " + numberClose + " closed");
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(pullRequests.get(position).getUrl()));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

