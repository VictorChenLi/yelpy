package com.alapplication.yelpy.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alapplication.yelpy.R;
import com.alapplication.yelpy.api.model.Business;
import com.squareup.picasso.Picasso;

public class DemoCustomView extends LinearLayout {
    private Context mContext;
    private Business mBusiness;

    private ImageView thumbnail;
    private TextView title, review, price, address, categories;
    private RatingBar rating;

    public DemoCustomView(Context context) {
        super(context);
        init(context, null);
    }

    public DemoCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DemoCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.list_item_demo, this, true);

        // find elements
        thumbnail = (ImageView) findViewById(R.id.thumbnail);
        title = (TextView) findViewById(R.id.title);
        review = (TextView) findViewById(R.id.reviews);
        address = (TextView) findViewById(R.id.address);
        categories = (TextView) findViewById(R.id.categories);
        price = (TextView) findViewById(R.id.price);
        rating = (RatingBar) findViewById(R.id.rating);
    }

    public void setData(Business business){
        mBusiness = business;
        if (!TextUtils.isEmpty(business.image_url)) {
            Picasso.with(mContext).load(business.image_url).placeholder(R.drawable.ic_business_placeholder).fit().centerCrop().into(this.thumbnail);
        } else {
            this.thumbnail.setImageResource(R.drawable.ic_business_placeholder);
        }
        this.title.setText(business.name);
        this.rating.setRating(business.rating);
        this.review.setText(mContext.getResources().getQuantityString(R.plurals.reviews, business.review_count, business.review_count));
        this.price.setText(business.price);
        this.address.setText(business.location.toString());
        this.categories.setText(business.getCategorySummary());
        this.address.setText(business.location == null ? "" : business.location.getShortForm());
    }
}
