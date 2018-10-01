package com.framgia.mvvm.data.source.remote;

import com.framgia.demodatabinding.data.model.SearchUserResponse;
import com.framgia.demodatabinding.data.source.GithubUserDataSource;
import com.framgia.demodatabinding.data.source.remote.config.GithubService;
import com.framgia.demodatabinding.data.source.remote.config.ServiceClient;
import io.reactivex.Single;

public class GithubUserRemoteDataSource implements GithubUserDataSource.remoteDataSource {
    private static GithubUserRemoteDataSource sInstance;
    private static GithubService sGithubService;

    public GithubUserRemoteDataSource(GithubService githubService) {
        sGithubService = githubService;
    }

    public static GithubUserRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new GithubUserRemoteDataSource(ServiceClient.getService());
        }
        return sInstance;
    }

    @Override
    public Single<SearchUserResponse> getUser(String key, int limit) {
        return sGithubService.getGithub(key, limit);
    }
}

