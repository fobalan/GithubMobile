package br.com.test.gold360.githubmobile.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import br.com.test.gold360.githubmobile.R;
import br.com.test.gold360.githubmobile.holders.RepositoryHolder;
import br.com.test.gold360.githubmobile.model.Repository;

/**
 * Created by Flavio on 20/08/2017.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryHolder> {
    private LayoutInflater layoutInflater;
    private List<Repository> repositories;
    private Context context;

    public RepositoryAdapter(Context context, List<Repository> repositories){
        this.context = context;
        this.repositories = repositories;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_repository, parent, false);
        RepositoryHolder repositoryHolder = new RepositoryHolder(view);
        return repositoryHolder;
    }

    @Override
    public void onBindViewHolder(final RepositoryHolder holder, int position) {
        holder.nameTextView.setText(repositories.get(position).getName());
        holder.descriptionTextView.setText(repositories.get(position).getDescription());
        holder.forksTextView.setText(String.valueOf(repositories.get(position).getForksNumber()));
        holder.starsTextView.setText(String.valueOf(repositories.get(position).getStarsNumber()));
        holder.ownerNameTextView.setText(repositories.get(position).getOwner().getName());
        holder.ownerFullNameTextView.setText(repositories.get(position).getFullName());
        Picasso.with(context)
                .load(repositories.get(position).getOwner().getAvatarUrl())
                .placeholder(R.drawable.ic_account_circle_black_48dp)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, 160, 160, false);
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

    @Override
    public int getItemCount() {
        return repositories.size();
    }

}
