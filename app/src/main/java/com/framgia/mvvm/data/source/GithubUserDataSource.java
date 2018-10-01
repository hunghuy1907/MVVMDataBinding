package com.framgia.mvvm.data.source;

import com.framgia.demodatabinding.data.model.SearchUserResponse;
import io.reactivex.Single;

public interface GithubUserDataSource {
    interface remoteDataSource {
        Single<SearchUserResponse> getUser(String key, int limit);
    }
}
