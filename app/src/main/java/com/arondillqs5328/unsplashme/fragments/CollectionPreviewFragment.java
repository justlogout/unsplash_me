package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arondillqs5328.unsplashme.ItemDecorator;
import com.arondillqs5328.unsplashme.MVP.contracts.CollectionPreviewContract;
import com.arondillqs5328.unsplashme.MVP.models.CollectionPreviewRepository;
import com.arondillqs5328.unsplashme.MVP.presenters.CollectionPreviewPresenter;
import com.arondillqs5328.unsplashme.POJO.Photo;
import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.Retrofit.RetrofitClient;
import com.arondillqs5328.unsplashme.UnsplashMe;
import com.arondillqs5328.unsplashme.adapters.PhotoAdapter;
import com.arondillqs5328.unsplashme.endpoints.UnsplashCollectionAPI;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionPreviewFragment extends Fragment implements CollectionPreviewContract.View {

    @BindView(R.id.collection_preview_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.collection_preview_progress_bar) ProgressBar mProgressBar;

    private boolean isLoading = true;
    private int id;
    private int page = 1;
    private int per_page = 10;
    private List<Photo> mPhotos = new ArrayList<>();

    private CollectionPreviewPresenter mPresenter;

    public static CollectionPreviewFragment getInstance() {
        CollectionPreviewFragment fragment = new CollectionPreviewFragment();
        return fragment;
    }

    public CollectionPreviewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        id = UnsplashMe.sDefaultCollection.getId();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_collection_preview, container, false);
        ButterKnife.bind(this, view);

        mPresenter = new CollectionPreviewPresenter(this, new CollectionPreviewRepository(new RetrofitClient().getRetrofitInstance().create(UnsplashCollectionAPI.class)));

        initRecyclerView();
        mPresenter.onLoadMorePhoto(id, page, per_page);
        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(new PhotoAdapter(mPhotos, new ItemDecorator()));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isLoading && ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition() == mRecyclerView.getLayoutManager().getItemCount() - 1) {
                    mPresenter.onLoadMorePhoto(id, page, per_page);
                    isLoading = false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMorePhoto(List<Photo> photos) {
        mPhotos.addAll(photos);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoInternetConection() {
        Toast.makeText(this.getContext(), "Дурак включи інтернет", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideNoInternetConection() {

    }

    @Override
    public void updateQuery() {
        page = page + 1;
        isLoading = true;
    }
}
