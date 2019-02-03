package com.arondillqs5328.unsplashme.adapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arondillqs5328.unsplashme.POJO.Photo;
import com.arondillqs5328.unsplashme.PhotoDecorator;
import com.arondillqs5328.unsplashme.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> mPhotos;

    public PhotoAdapter(List<Photo> photos) {
        mPhotos = photos;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoDecorator decorator = new PhotoDecorator(mPhotos.get(position).width, mPhotos.get(position).height);
        String url = decorator.getPhotoUrl(mPhotos.get(position).urls);
        ColorDrawable placeholder = new ColorDrawable(Color.parseColor(mPhotos.get(position).color));

        holder.mImageView.setMinimumHeight(decorator.getFinalHeight());
        Picasso.get()
                .load(url)
                .placeholder(placeholder)
                .error(placeholder)
                .centerCrop()
                .resize(holder.mImageView.getMeasuredWidth(), decorator.getFinalHeight())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_imageview) ImageView mImageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
