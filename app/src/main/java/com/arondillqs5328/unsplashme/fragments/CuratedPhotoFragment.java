package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arondillqs5328.unsplashme.ItemDecorator;
import com.arondillqs5328.unsplashme.MVP.contracts.CuratedPhotoContract;
import com.arondillqs5328.unsplashme.MVP.models.CuratedPhotoRepository;
import com.arondillqs5328.unsplashme.MVP.presenters.CuratedPhotoPresenter;
import com.arondillqs5328.unsplashme.POJO.Photo;
import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.Retrofit.RetrofitClient;
import com.arondillqs5328.unsplashme.adapters.PhotoAdapter;
import com.arondillqs5328.unsplashme.endpoints.UnsplashPhotoAPI;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CuratedPhotoFragment extends Fragment implements CuratedPhotoContract.View {

    @BindView(R.id.featured_recycler) RecyclerView mRecyclerView;
    @BindView(R.id.featured_progress_bar) ProgressBar mProgressBar;

    private boolean isLoading = true;
    private int page = 1;
    private int per_page = 10;
    private String order_by = UnsplashPhotoAPI.ORDER_BY_LATEST;
    private List<Photo> mPhotos = new ArrayList<>();

    private CuratedPhotoPresenter mPresenter;

    public static CuratedPhotoFragment newInstance() {
        CuratedPhotoFragment fragment = new CuratedPhotoFragment();
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
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_featured_photo, container, false);
        ButterKnife.bind(this, view);

        mPresenter = new CuratedPhotoPresenter(this, new CuratedPhotoRepository(new RetrofitClient().getRetrofitInstance().create(UnsplashPhotoAPI.class)));

        initRecyclerView();
        mPresenter.onLoadMorePhoto(page, per_page, order_by);
        return view;
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
                    mPresenter.onLoadMorePhoto(page, per_page, order_by);
                    isLoading = false;
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.featured_photo_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.featured_latest:
                updateOldQuery(UnsplashPhotoAPI.ORDER_BY_LATEST);
                return true;
            case R.id.featured_oldest:
                updateOldQuery(UnsplashPhotoAPI.ORDER_BY_OLDEST);
                return true;
            case R.id.featured_popular:
                updateOldQuery(UnsplashPhotoAPI.ORDER_BY_POPULAR);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateOldQuery(String order_by) {
        page = 1;
        per_page = 10;
        this.order_by = order_by;
        mPhotos.clear();
        mRecyclerView.getAdapter().notifyDataSetChanged();

        mPresenter.onLoadFirst();
        mPresenter.onLoadMorePhoto(page, per_page, order_by);
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
