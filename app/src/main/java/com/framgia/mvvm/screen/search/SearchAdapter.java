package com.framgia.mvvm.screen.search;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.demodatabinding.data.model.User;
import com.framgia.demodatabinding.databinding.LayoutItemSearchBinding;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{
    private List<User> mUsers;
    private OnClickItemGithub mOnClickItemGithub;

    public SearchAdapter(List<User> users, OnClickItemGithub onClickItemGithub) {
        mUsers = users;
        mOnClickItemGithub = onClickItemGithub;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemSearchBinding layoutItemSearchBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        com.framgia.demodatabinding.R.layout.layout_item_search, parent, false);
        return new SearchViewHolder(layoutItemSearchBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.binData(mUsers.get(position), mOnClickItemGithub);
    }

    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private LayoutItemSearchBinding mBinding;
        private ItemSearchViewModel mItemSearchViewModel;

        public SearchViewHolder(LayoutItemSearchBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(mItemSearchViewModel);
        }

        public void binData(User user, OnClickItemGithub onClickItemGithub) {
            mItemSearchViewModel.setUser(user);
            mItemSearchViewModel = new ItemSearchViewModel(onClickItemGithub);
            mBinding.executePendingBindings();
        }
    }

    public interface OnClickItemGithub {
        void clickItemGithub(User user);
    }
}
