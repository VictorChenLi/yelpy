package com.alapplication.yelpy.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alapplication.yelpy.api.model.Business;

import java.util.List;

public class PracticeListAdapter extends RecyclerView.Adapter<PracticeListAdapter.ViewHolder> {
    private Context mContext;
    private List<Business> mList;

    public PracticeListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Business> list) {
        //TODO 4. Save data and notify changes
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO 2. Inflate the list item view

        // TODO 3. Initial ViewHolder

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO 6. Setup data into view holder

    }

    @Override
    public int getItemCount() {
        // TODO 5. Setup item count based on data size
        return 0;
    }

    //
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        private TextView title, review, price, address, categories;
        private RatingBar rating;

        public ViewHolder(View itemView) {
            super(itemView);

            //TODO 1. Initial view holder, find elements

        }
    }
}
