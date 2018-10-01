package com.framgia.mvvm.screen.search;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import com.framgia.demodatabinding.data.model.User;

public class ItemSearchViewModel extends BaseObservable {

    public ObservableField<User> userObservableField = new ObservableField<>();
    private SearchAdapter.OnClickItemGithub mItemClickListener;

    public ItemSearchViewModel(SearchAdapter.OnClickItemGithub listener) {
        mItemClickListener = listener;
    }

    public void setUser(@NonNull User user) {
        userObservableField.set(user);
    }

    public void onItemClick() {
        if (mItemClickListener == null || userObservableField.get() == null) {
            return;
        }
        mItemClickListener.clickItemGithub(userObservableField.get());
    }
}
