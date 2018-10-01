package com.framgia.mvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SearchUserResponse implements Parcelable{

    @SerializedName("total_count")
    @Expose
    private int totalCount;

    @SerializedName("items")
    @Expose
    private List<User> items = new ArrayList<>();

    public SearchUserResponse(List<User> items) {
        this.items = items;
    }

    protected SearchUserResponse(Parcel in) {
        totalCount = in.readInt();
        items = in.createTypedArrayList(User.CREATOR);
    }

    public static final Creator<SearchUserResponse> CREATOR = new Creator<SearchUserResponse>() {
        @Override
        public SearchUserResponse createFromParcel(Parcel in) {
            return new SearchUserResponse(in);
        }

        @Override
        public SearchUserResponse[] newArray(int size) {
            return new SearchUserResponse[size];
        }
    };

    public int getTotalCount() {
        return totalCount;
    }

    public List<User> getItems() {
        return items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalCount);
        dest.writeTypedList(items);
    }
}
