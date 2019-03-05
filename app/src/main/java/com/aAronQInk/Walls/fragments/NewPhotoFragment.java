package com.aAronQInk.Walls.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.aAronQInk.Walls.ItemDecorator;
import com.aAronQInk.Walls.MVP.contracts.NewPhotoContract;
import com.aAronQInk.Walls.MVP.models.NewPhotoRepository;
import com.aAronQInk.Walls.MVP.presenters.NewPhotoPresenter;
import com.aAronQInk.Walls.POJO.Photo;
import com.aAronQInk.Walls.R;
import com.aAronQInk.Walls.Retrofit.RetrofitClient;
import com.aAronQInk.Walls.adapters.PhotoAdapter;
import com.aAronQInk.Walls.endpoints.UnsplashPhotoAPI;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPhotoFragment extends Fragment implements NewPhotoContract.View {

    @BindView(R.id.new_recycler) RecyclerView mRecyclerView;
    @BindView(R.id.new_progress_bar) ProgressBar mProgressBar;
    @BindView(R.id.new_normal) View mNormalStateView;
    @BindView(R.id.new_no_internet) View mNoInternetConnectionView;

    private boolean isLoading = true;
    private int page = 1;
    private int per_page = 10;
    private String order_by = UnsplashPhotoAPI.ORDER_BY_LATEST;
    private List<Photo> mPhotos = new ArrayList<>();

    private NewPhotoPresenter mPresenter;

    public static NewPhotoFragment getInstance() {
        NewPhotoFragment fragment = new NewPhotoFragment();
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
        View view = inflater.inflate(R.layout.fragment_new_photo, container, false);
        ButterKnife.bind(this, view);

        mPresenter = new NewPhotoPresenter(this, new NewPhotoRepository(new RetrofitClient().getRetrofitInstance().create(UnsplashPhotoAPI.class)));

        initRecyclerView();
        mPresenter.onLoadMorePhoto(page, per_page, order_by);
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
                    mPresenter.onLoadMorePhoto(page, per_page, order_by);
                    isLoading = false;
                }
            }
        });
    }

    @OnClick(R.id.retry_button)
    public void onClickRetry() {
        updateOldQuery(UnsplashPhotoAPI.ORDER_BY_LATEST);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_photo_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_latest:
                updateOldQuery(UnsplashPhotoAPI.ORDER_BY_LATEST);
                return true;
            case R.id.new_oldest:
                updateOldQuery(UnsplashPhotoAPI.ORDER_BY_OLDEST);
                return true;
            case R.id.new_popular:
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
        mNormalStateView.setVisibility(View.GONE);
        mNoInternetConnectionView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoInternetConection() {
        mNoInternetConnectionView.setVisibility(View.GONE);
        mNormalStateView.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateQuery() {
        page = page + 1;
        isLoading = true;
    }
}
