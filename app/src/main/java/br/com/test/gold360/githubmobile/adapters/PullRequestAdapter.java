package br.com.test.gold360.githubmobile.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.test.gold360.githubmobile.PullRequestsActivity;
import br.com.test.gold360.githubmobile.R;
import br.com.test.gold360.githubmobile.holders.PullRequestHolder;
import br.com.test.gold360.githubmobile.holders.RepositoryHolder;
import br.com.test.gold360.githubmobile.listener.RecyclerViewListener;
import br.com.test.gold360.githubmobile.model.PullRequest;
import br.com.test.gold360.githubmobile.model.Repository;

/**
 * Created by Flavio on 22/08/2017.
 */

public class PullRequestAdapter extends RecyclerView.Adapter<PullRequestHolder> {
    private LayoutInflater layoutInflater;
    private List<PullRequest> pullRequests;
    private Context context;
    private RecyclerViewListener listener;

    public PullRequestAdapter(Context context, List<PullRequest> pullRequests) {
        this.context = context;
        this.pullRequests = pullRequests;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PullRequestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_pull_request, parent, false);
        PullRequestHolder pullRequestHolder = new PullRequestHolder(view, listener);
        return pullRequestHolder;
    }

    @Override
    public void onBindViewHolder(final PullRequestHolder holder, int position) {
        holder.titleTextView.setText(pullRequests.get(position).getTitle());
        holder.descriptionTextView.setText(pullRequests.get(position).getBody());
        holder.userNameTextView.setText(pullRequests.get(position).getUser().getName());

        String data = null;
        try {
            data = formatDate(pullRequests.get(position).getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.dateTextView.setText(data);

        Picasso.with(context)
                .load(pullRequests.get(position).getUser().getAvatar())
                .placeholder(R.drawable.github_circle)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, 120, 120, false);
                        holder.avatarCircleImageView.setImageBitmap(bitmapScaled);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        holder.avatarCircleImageView.setImageDrawable(placeHolderDrawable);
                    }
                });
    }

    private String formatDate(String string) throws ParseException {
        SimpleDateFormat formaterOld, formaterNew;
        formaterOld = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = formaterOld.parse(string);
        formaterNew = new SimpleDateFormat("dd-MMM-yyyy");

        return formaterNew.format(date);
    }


    @Override
    public int getItemCount() {
        return pullRequests.size();
    }

    public void setOnClickListener(RecyclerViewListener listener) {
        this.listener = listener;
    }
}
