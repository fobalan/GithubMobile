package br.com.test.gold360.githubmobile.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.test.gold360.githubmobile.R;
import br.com.test.gold360.githubmobile.listener.RecyclerViewListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Flavio on 22/08/2017.
 */

public class PullRequestHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView userNameTextView;
    public TextView dateTextView;
    public TextView titleTextView;
    public TextView descriptionTextView;
    public CircleImageView avatarCircleImageView;

    private RecyclerViewListener listener;
    public PullRequestHolder(View itemView, RecyclerViewListener listener) {
        super(itemView);

        this.listener = listener;

        userNameTextView = (TextView) itemView.findViewById(R.id.userNamePullRequestTextView);
        dateTextView = (TextView)itemView.findViewById(R.id.dateTextView);
        titleTextView = (TextView) itemView.findViewById(R.id.titlePullRequestTextView);
        descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionPullRequestTextView);
        avatarCircleImageView = (CircleImageView) itemView.findViewById(R.id.avatarPullRequestCircleImageView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v, getAdapterPosition());
        }
    }
}
