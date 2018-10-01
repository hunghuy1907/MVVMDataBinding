package com.framgia.mvvm.screen.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.demodatabinding.data.respository.GithubUserRespository;
import com.framgia.demodatabinding.data.source.remote.GithubUserRemoteDataSource;
import com.framgia.demodatabinding.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment{
    private FragmentSearchBinding mBinding;
    private SearchViewModel mSearchViewModel;
    private GithubUserRespository mGithubUserRespository;

    public SearchFragment() {
    }

    public static SearchFragment getInstance() {
        return new SearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, com.framgia.demodatabinding.R.layout.fragment_search, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGithubUserRespository = new GithubUserRespository(GithubUserRemoteDataSource.getInstance());
        mSearchViewModel = new SearchViewModel(mGithubUserRespository);
        mBinding.setViewModel(mSearchViewModel);
    }
}
