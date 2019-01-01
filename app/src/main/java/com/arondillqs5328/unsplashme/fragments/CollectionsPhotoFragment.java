package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arondillqs5328.unsplashme.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CollectionsPhotoFragment extends Fragment {

    public static CollectionsPhotoFragment newInstance() {
        CollectionsPhotoFragment fragment = new CollectionsPhotoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collections_photo, container, false);
        setRetainInstance(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.collections_photo_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.collections_all:
                Toast.makeText(getContext(), "collections all", Toast.LENGTH_LONG).show();
                return true;
            case R.id.collections_curated:
                Toast.makeText(getContext(), "collections curated", Toast.LENGTH_LONG).show();
                return true;
            case R.id.collections_featured:
                Toast.makeText(getContext(), "collections featured", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
