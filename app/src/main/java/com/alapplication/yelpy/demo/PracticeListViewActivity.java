package com.alapplication.yelpy.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alapplication.yelpy.api.YelpApi;
import com.alapplication.yelpy.api.model.LocationParam;
import com.alapplication.yelpy.api.model.SearchParam;

import de.greenrobot.event.EventBus;

public class PracticeListViewActivity extends AppCompatActivity {

    private RecyclerView mBusinessList;
    private DemoListAdapter mAdapter;
    private SearchParam mSearchParam;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

        // TODO 1. setup the layout

        // TODO 2. initial the recycle view

        // TODO 3. initial the Adapter


        SearchParam.Builder builder = new SearchParam.Builder(new LocationParam("Toronto"));
        mSearchParam = builder.build();
        authenticate();
    }

    public void onEventMainThread(YelpApi.Search.Response response) {
        if (response.isSuccess()) {

            // TODO 4. set the data into Adapter

        } else {
            Toast.makeText(this, "Search Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void authenticate() {
        new YelpApi.GetToken().postRequestAsync();
    }

    public void onEventMainThread(YelpApi.GetToken.Response response) {
        if (response.isSuccess()) {
            SearchParam.Builder builder = new SearchParam.Builder(mSearchParam);
            mSearchParam = builder.build();
            searchBusiness();
        } else {
            Toast.makeText(this, response.status.errorMsg, Toast.LENGTH_SHORT).show();
        }
    }

    private void searchBusiness() {
        mSearchParam = new SearchParam.Builder(mSearchParam).location("Toronto").price("1,2,3,4").build();
        new YelpApi.Search(mSearchParam).postRequestAsync();
    }
}
