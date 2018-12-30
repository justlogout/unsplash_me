package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arondillqs5328.unsplashme.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewPhotoFragment extends Fragment {

    public static NewPhotoFragment newInstance() {
        NewPhotoFragment fragment = new NewPhotoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_photo, container, false);
        setRetainInstance(true);

        return view;
    }
}
