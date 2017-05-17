package com.alapplication.yelpy.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alapplication.yelpy.R;
import com.alapplication.yelpy.api.model.Business;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DemoListAdapter extends RecyclerView.Adapter<DemoListAdapter.ViewHolder> {
    private Context mContext;
    private List<Business> mList;

    public DemoListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Business> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item_demo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Business business = mList.get(position);
        if (!TextUtils.isEmpty(business.image_url)) {
            Picasso.with(mContext).load(business.image_url).placeholder(R.drawable.ic_business_placeholder).fit().centerCrop().into(holder.thumbnail);
        } else {
            holder.thumbnail.setImageResource(R.drawable.ic_business_placeholder);
        }
        holder.title.setText(business.name);
        holder.rating.setRating(business.rating);
        holder.review.setText(mContext.getResources().getQuantityString(R.plurals.reviews, business.review_count, business.review_count));
        holder.price.setText(business.price);
        holder.address.setText(business.location.toString());
        holder.categories.setText(business.getCategorySummary());
        holder.address.setText(business.location == null ? "" : business.location.getShortForm());
    }

    @Override
    public int getItemCount() {
        return null != mList ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        private TextView title, review, price, address, categories;
        private RatingBar rating;

        public ViewHolder(View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            review = (TextView) itemView.findViewById(R.id.reviews);
            address = (TextView) itemView.findViewById(R.id.address);
            categories = (TextView) itemView.findViewById(R.id.categories);
            price = (TextView) itemView.findViewById(R.id.price);
            rating = (RatingBar) itemView.findViewById(R.id.rating);
        }
    }


}
