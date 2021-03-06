package com.miki.applock.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getOptionsMenuId() != -1) {
            setHasOptionsMenu(true);
        }

        initBefore(inflater, container, savedInstanceState);
        view = inflater.inflate(getContentViewId(), container, false);
        init(view);
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (getOptionsMenuId() != -1) {
            inflater.inflate(getOptionsMenuId(), menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * 初始化之前
     */
    protected void initBefore(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    /**
     * 当前布局文件
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 初始化
     */
    protected abstract void init(View rootView);


    public View findViewById(int id) {
        return view.findViewById(id);
    }


    /**
     * 当前页菜单资源
     *
     * @return
     */
    protected int getOptionsMenuId() {
        return -1;
    }


}


