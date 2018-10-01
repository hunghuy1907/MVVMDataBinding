package com.framgia.mvvm.data.source.remote.config;

import com.framgia.demodatabinding.data.model.SearchUserResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubService {
    @GET("users?")
    Single<SearchUserResponse> getGithub(@Query("q") String key, @Query("per_page") int limit);
}