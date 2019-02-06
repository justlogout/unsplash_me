package com.arondillqs5328.unsplashme.adapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arondillqs5328.unsplashme.POJO.Collection;
import com.arondillqs5328.unsplashme.PhotoDecorator;
import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.UnsplashMe;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionAdaper extends RecyclerView.Adapter<CollectionAdaper.CollectionViewHolder> {

    private List<Collection> mCollections;

    public CollectionAdaper(List<Collection> collections) {
        mCollections = collections;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, int position) {
        PhotoDecorator decorator = new PhotoDecorator();
        String url = decorator.getPhotoUrl(mCollections.get(position).photo.urls);
        ColorDrawable placeholder = new ColorDrawable(Color.parseColor(mCollections.get(position).photo.color));
        String itemCount = "%d " + UnsplashMe.getInstance().getString(R.string.photos);

        holder.mCollectionName.setText(mCollections.get(position).title);
        holder.mCollectionImageCount.setText(String.format(itemCount, mCollections.get(position).totalPhotos));
        Picasso.get()
                .load(url)
                .placeholder(placeholder)
                .error(placeholder)
                .centerCrop()
                .resize(holder.mCollectionPreview.getWidth(), holder.mCollectionPreview.getMaxHeight())
                .into(holder.mCollectionPreview);
    }

    @Override
    public int getItemCount() {
        return mCollections.size();
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.collection_preview_imageview) ImageView mCollectionPreview;
        @BindView(R.id.collection_name_textView) TextView mCollectionName;
        @BindView(R.id.total_photo_textView) TextView mCollectionImageCount;

        public CollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
