package com.alapplication.yelpy.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alapplication.yelpy.R;
import com.alapplication.yelpy.api.YelpApi;
import com.alapplication.yelpy.api.model.LocationParam;
import com.alapplication.yelpy.api.model.SearchParam;

import de.greenrobot.event.EventBus;

public class DemoListViewActivity extends AppCompatActivity {
    private RecyclerView mBusinessList;
    private DemoListAdapter mAdapter;
    private SearchParam mSearchParam;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);
        EventBus.getDefault().register(this);
        mBusinessList = (RecyclerView) findViewById(R.id.business_list);
        mAdapter = new DemoListAdapter(this);
        mBusinessList.setLayoutManager(new LinearLayoutManager(this));
        mBusinessList.setAdapter(mAdapter);
        SearchParam.Builder builder = new SearchParam.Builder(new LocationParam("Toronto"));
        mSearchParam = builder.build();
        authenticate();
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

    public void onEventMainThread(YelpApi.Search.Response response) {
        if (response.isSuccess()) {
            mAdapter.setData(response.businesses);
        } else {
            Toast.makeText(this, "Search Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void searchBusiness() {
        mSearchParam = new SearchParam.Builder(mSearchParam).location("Toronto").price("1,2,3,4").build();
        new YelpApi.Search(mSearchParam).postRequestAsync();
    }
}
