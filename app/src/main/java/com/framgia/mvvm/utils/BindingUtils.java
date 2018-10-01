package com.framgia.mvvm.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class BindingUtils {

    @BindingAdapter({ "recyclerAdapter" })
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
            RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
