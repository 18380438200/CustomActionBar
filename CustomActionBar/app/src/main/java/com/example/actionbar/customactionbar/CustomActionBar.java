package com.example.actionbar.customactionbar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomActionBar extends LinearLayout {

    private ImageView headerBack;
    private TextView headerTitle, headerMenuText;
    private LinearLayout llSearch;
    private LayoutInflater mInflater;
    private View headView;

    public CustomActionBar(Context context) {
        super(context);
        init(context);
    }

    public CustomActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        mInflater = LayoutInflater.from(context);
        headView = mInflater.inflate(R.layout.customactionbar, null);
        addView(headView);
        initView();
    }

    private void initView() {
        headerBack = headView.findViewById(R.id.header_back);
        headerTitle = headView.findViewById(R.id.header_title);
        headerMenuText = headView.findViewById(R.id.header_menu);
        llSearch = headView.findViewById(R.id.ll__search);
        headerBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    public void setStyle(String title) {
        if (title != null)
            headerTitle.setText(title);
    }

    /**
     * 标题加文字菜单
     *
     * @param title
     * @param menuText
     * @param listener
     */
    public void setStyle(String title, String menuText, OnClickListener listener) {
        setStyle(title);
        if (menuText != null)
            headerMenuText.setText(menuText);
        headerMenuText.setOnClickListener(listener);
    }

    /**
     * 只有右边字体
     *
     * @param menuText
     * @param listener
     */
    public void setStyle(String menuText, OnClickListener listener) {
        headerBack.setVisibility(GONE);
        if (menuText != null)
            headerMenuText.setText(menuText);
        headerMenuText.setOnClickListener(listener);
    }

    /**
     * 标题加图标菜单
     *
     * @param title
     * @param menuImgResource
     * @param listener
     */
    public void setStyle(String title, int menuImgResource, OnClickListener listener) {
        setStyle(title);
        headerMenuText.setBackgroundResource(menuImgResource);
        headerMenuText.setOnClickListener(listener);
    }

    public void setStyle(boolean hasSearch){
        if(hasSearch){
            llSearch.setVisibility(VISIBLE);
        }
    }

    /**
     * 将默认的返回按钮功能去掉
     */
    public void setStyleNoBack(String title) {
        setStyle(title);
        headerBack.setVisibility(GONE);
    }

}
