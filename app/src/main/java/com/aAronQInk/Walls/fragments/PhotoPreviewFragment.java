package com.aAronQInk.Walls.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aAronQInk.Walls.ItemDecorator;
import com.aAronQInk.Walls.POJO.Photo;
import com.aAronQInk.Walls.R;
import com.aAronQInk.Walls.Walls;
import com.aAronQInk.Walls.helpers.DownloadHelper;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoPreviewFragment extends Fragment {

    @BindView(R.id.preview_photo) ImageView mPreviewPhoto;

    private Photo mPhoto;
    private ItemDecorator mDecorator = new ItemDecorator();

    public static PhotoPreviewFragment getInstance() {
        PhotoPreviewFragment fragment = new PhotoPreviewFragment();
        return fragment;
    }

    public PhotoPreviewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        mPhoto = Walls.sDefaultPhoto;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_photo_preview, container, false);
        ButterKnife.bind(this, view);

        Picasso.get()
                .load(mDecorator.getPhotoUrl(mPhoto.getUrls()))
                .placeholder(mDecorator.getPlaceholder(mPhoto.getColor()))
                .error(mDecorator.getPlaceholder(mPhoto.getColor()))
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
                new DownloadHelper().download(getActivity());
                return true;
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
