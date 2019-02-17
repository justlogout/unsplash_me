package com.arondillqs5328.unsplashme.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arondillqs5328.unsplashme.ItemDecorator;
import com.arondillqs5328.unsplashme.POJO.Collection;
import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.UnsplashMe;
import com.arondillqs5328.unsplashme.activities.CollectionPreviewActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {

    private List<Collection> mCollections;
    private ItemDecorator mDecorator;

    public CollectionAdapter(List<Collection> collections, ItemDecorator decorator) {
        mCollections = collections;
        mDecorator = decorator;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, final int position) {
        holder.mCollectionName.setText(mCollections.get(position).getTitle());
        holder.mCollectionImageCount.setText(mDecorator.getTotalCount(mCollections.get(position).getTotalPhotos()));

        Picasso.get()
                .load(mDecorator.getPhotoUrl(mCollections.get(position).getPhoto().getUrls()))
                .placeholder(mDecorator.getPlaceholder(mCollections.get(position).getPhoto().getColor()))
                .error(mDecorator.getPlaceholder(mCollections.get(position).getPhoto().getColor()))
                .centerCrop()
                .resize(holder.mCollectionPreview.getWidth(), holder.mCollectionPreview.getMaxHeight())
                .into(holder.mCollectionPreview);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CollectionPreviewActivity.newIntent(v.getContext());
                UnsplashMe.sDefaultCollection = mCollections.get(position);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCollections.size();
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.collection_preview_image_view) ImageView mCollectionPreview;
        @BindView(R.id.collection_name_text_view) TextView mCollectionName;
        @BindView(R.id.total_photo_text_view) TextView mCollectionImageCount;

        public CollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
