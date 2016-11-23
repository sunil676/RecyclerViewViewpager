package com.sunil.recyclerviewviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.sunil.recyclerviewviewpager.adapter.WallAdapter;
import com.sunil.recyclerviewviewpager.daogen.DataWall;
import com.sunil.recyclerviewviewpager.daogen.WallTall;
import com.sunil.recyclerviewviewpager.manager.DataManager;
import com.sunil.recyclerviewviewpager.manager.WallTallManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    String [] name = {"Bangalore", "Chennai", "Kolkata", "Delhi", "Leh", "Andaman"};
    String [] image = {"http://farm8.staticflickr.com/7452/27782542462_12e206359b_m.jpg",
                       "http://farm8.staticflickr.com/7311/27782539412_1e1cece561_m.jpg",
                        "http://farm8.staticflickr.com/7452/27782542462_12e206359b_m.jpg",
                         "http://farm8.staticflickr.com/7326/27605634010_917553d601_m.jpg",
                         "http://farm8.staticflickr.com/7452/27782542462_12e206359b_m.jpg",
                        "http://farm8.staticflickr.com/7311/27782539412_1e1cece561_m.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        insertIntoDb();
        getInfo();
    }

    private void getInfo() {
        List<WallTall> listWall= WallTallManager.loadAll(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        WallAdapter adapter = new WallAdapter(this, listWall);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayoutManager.getOrientation());
        recyclerView.addItemDecoration(mDividerItemDecoration);
    }

    private void insertIntoDb(){
        WallTallManager.removeAll(this);
        DataManager.removeAll(this);
        for (int index =0; index < 2; index++){
            WallTall wallTall = new WallTall();
            wallTall.setName_id(index);
            WallTallManager.insertOrReplace(this,wallTall);

            for (int i =0; i<6; i++) {
                DataWall dataWall = new DataWall();
                dataWall.setName_id(index);
                dataWall.setName(name[i]);
                dataWall.setImageurl(image[i]);
                DataManager.insertOrReplace(this,dataWall);
            }

        }
    }
}
