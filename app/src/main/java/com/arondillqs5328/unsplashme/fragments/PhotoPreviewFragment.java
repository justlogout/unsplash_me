package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arondillqs5328.unsplashme.ItemDecorator;
import com.arondillqs5328.unsplashme.POJO.Photo;
import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.UnsplashMe;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoPreviewFragment extends Fragment {

    @BindView(R.id.preview_photo) ImageView mPreviewPhoto;
    @BindView(R.id.preview_author) TextView mPreviewAuthor;

    private Photo mPhoto;
    private ItemDecorator mDecorator = new ItemDecorator();

    public static PhotoPreviewFragment newInstance() {
        PhotoPreviewFragment fragment = new PhotoPreviewFragment();
        return fragment;
    }

    public PhotoPreviewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        mPhoto = UnsplashMe.sDefaultPhoto;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_photo_preview, container, false);
        ButterKnife.bind(this, view);

        mPreviewAuthor.setText(mDecorator.getAuthor(mPhoto.getUser()));
        mPreviewPhoto.setMinimumHeight(mDecorator.getFinalHeight(mPhoto.getWidth(), mPhoto.getHeight()));

        Picasso.get()
                .load(mDecorator.getPhotoUrl(mPhoto.getUrls()))
                .placeholder(mDecorator.getPlaceholder(mPhoto.getColor()))
                .error(mDecorator.getPlaceholder(mPhoto.getColor()))
                .centerCrop()
                .resize(mPreviewPhoto.getMeasuredWidth(), mDecorator.getFinalHeight(mPhoto.getWidth(), mPhoto.getHeight()))
                .into(mPreviewPhoto);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.photo_preview_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.download:
                Toast.makeText(getContext(), "Download", Toast.LENGTH_LONG).show();
                return true;
            case R.id.set_wallpaper:
                Toast.makeText(getContext(), "set wallpaper", Toast.LENGTH_LONG).show();
                return true;
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
