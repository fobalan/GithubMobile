package br.com.test.gold360.githubmobile.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.test.gold360.githubmobile.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Flavio on 20/08/2017.
 */

public class RepositoryHolder extends RecyclerView.ViewHolder {

    public ImageView avatarCircleImageView;
    public TextView  ownerNameTextView;
    public TextView  ownerFullNameTextView;
    public TextView  nameTextView;
    public TextView  descriptionTextView;
    public TextView  forksTextView;
    public TextView  starsTextView;

    public RepositoryHolder(View itemView) {
        super(itemView);

        avatarCircleImageView = (CircleImageView) itemView.findViewById(R.id.avatarImageView);
        ownerNameTextView     = (TextView) itemView.findViewById(R.id.ownerNameTextView);
        ownerFullNameTextView = (TextView) itemView.findViewById(R.id.ownerFullNameTextView);
        nameTextView          = (TextView) itemView.findViewById(R.id.nameTextView);
        descriptionTextView   = (TextView) itemView.findViewById(R.id.descriptionTextView);
        forksTextView         = (TextView) itemView.findViewById(R.id.forksTextView);
        starsTextView         = (TextView) itemView.findViewById(R.id.starsTextView);
        ownerNameTextView     = (TextView) itemView.findViewById(R.id.ownerNameTextView);
    }
}
