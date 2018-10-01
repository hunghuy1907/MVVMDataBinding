package com.framgia.mvvm.screen.search;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.framgia.demodatabinding.data.model.SearchUserResponse;
import com.framgia.demodatabinding.data.model.User;
import com.framgia.demodatabinding.data.respository.GithubUserRespository;
import com.framgia.demodatabinding.screen.base.BaseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class SearchViewModel extends BaseViewModel implements SearchAdapter.OnClickItemGithub,
        LifecycleOwner{
    private static final String KEY = "hung";
    private static final int LIMIT = 5;
    private LifecycleRegistry mLifecycleRegistry;
    private SearchAdapter mSearchAdapter;
    private GithubUserRespository mGithubUserRespository;

    public SearchViewModel(GithubUserRespository githubUserRespository) {
        mGithubUserRespository = githubUserRespository;
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        setAdapter();
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onStop() {
    }

    @Override
    public void clickItemGithub(User user) {

    }

    LiveData<SearchUserResponse> getDataFromApi(String key, int limit) {
        final MutableLiveData<SearchUserResponse> data = new MutableLiveData<>();
        mGithubUserRespository.getUser(key, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SearchUserResponse>() {
                    @Override
                    public void accept(SearchUserResponse searchUserResponse) throws Exception {
                        data.setValue(searchUserResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public void setAdapter() {
        getDataFromApi(KEY, LIMIT).observe(this, new Observer<SearchUserResponse>() {
            @Override
            public void onChanged(@Nullable SearchUserResponse searchUserResponse) {
                List<User> users = searchUserResponse.getItems();
                mSearchAdapter = new SearchAdapter(users, SearchViewModel.this);
            }
        });
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    public SearchAdapter getSearchAdapter() {
        return mSearchAdapter;
    }
}
