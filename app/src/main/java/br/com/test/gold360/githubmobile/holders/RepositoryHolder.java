package br.com.test.gold360.githubmobile.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.test.gold360.githubmobile.R;
import br.com.test.gold360.githubmobile.listener.RecyclerViewListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Flavio on 20/08/2017.
 */

public class RepositoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView avatarCircleImageView;
    public TextView  ownerNameTextView;
    public TextView  ownerFullNameTextView;
    public TextView  nameTextView;
    public TextView  descriptionTextView;
    public TextView  forksTextView;
    public TextView  starsTextView;
    private RecyclerViewListener listener;

    public RepositoryHolder(View itemView, RecyclerViewListener listener) {
        super(itemView);

        this.listener = listener;
        avatarCircleImageView = (CircleImageView) itemView.findViewById(R.id.avatarRepositoryCircleImageView);
        ownerNameTextView     = (TextView) itemView.findViewById(R.id.ownerNameTextView);
        ownerFullNameTextView = (TextView) itemView.findViewById(R.id.ownerFullNameTextView);
        nameTextView          = (TextView) itemView.findViewById(R.id.nameRepositoryTextView);
        descriptionTextView   = (TextView) itemView.findViewById(R.id.descriptionRepositoryTextView);
        forksTextView         = (TextView) itemView.findViewById(R.id.forksTextView);
        starsTextView         = (TextView) itemView.findViewById(R.id.starsTextView);
        ownerNameTextView     = (TextView) itemView.findViewById(R.id.ownerNameTextView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v, getAdapterPosition());
        }
    }
}
