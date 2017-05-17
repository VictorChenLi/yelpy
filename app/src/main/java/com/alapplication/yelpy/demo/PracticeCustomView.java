package com.alapplication.yelpy.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alapplication.yelpy.api.model.Business;

public class PracticeCustomView extends LinearLayout {
    private Context mContext;
    private Business mBusiness;

    private ImageView thumbnail;
    private TextView title, review, price, address, categories;
    private RatingBar rating;

    public PracticeCustomView(Context context) {
        super(context);
        init(context, null);
    }

    public PracticeCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PracticeCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        // TODO 1. Inflate the custom view layout

        // TODO 2. find and initial elements

    }

    public void setData(Business business) {
        // TODO 3. Update view with the data

    }
}
