package com.framgia.mvvm.data.respository;

import com.framgia.demodatabinding.data.model.SearchUserResponse;
import com.framgia.demodatabinding.data.source.GithubUserDataSource;
import com.framgia.demodatabinding.data.source.remote.GithubUserRemoteDataSource;
import io.reactivex.Single;

public class GithubUserRespository implements GithubUserDataSource.remoteDataSource{
    private static GithubUserRespository sInstance;
    private GithubUserRemoteDataSource mRemoteDataSource;

    public GithubUserRespository (GithubUserRemoteDataSource githubUserRemoteDataSource) {
        mRemoteDataSource = githubUserRemoteDataSource;
    }

    public static GithubUserRespository getInstance(GithubUserRemoteDataSource githubUserRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new GithubUserRespository(githubUserRemoteDataSource);
        }
        return sInstance;
    }


    @Override
    public Single<SearchUserResponse> getUser(String key, int limit) {
        return mRemoteDataSource.getUser(key, limit);
    }
}
