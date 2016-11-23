package com.sunil.recyclerviewviewpager.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunil.recyclerviewviewpager.R;
import com.sunil.recyclerviewviewpager.daogen.DataWall;
import com.sunil.recyclerviewviewpager.daogen.WallTall;
import com.sunil.recyclerviewviewpager.manager.DataManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kuliza-195 on 11/23/16.
 */

public class WallAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WallTall> wallTalls;
    private Context context;

    public WallAdapter(Context context, List<WallTall> wallTalls) {
        this.wallTalls = wallTalls;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return wallTalls.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new WallViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int name_id = wallTalls.get(position).getName_id();
        List<DataWall> dataModelList = DataManager.loadByQuery(context, name_id);
        initializeViews(dataModelList, holder, position);
    }


    private void initializeViews(List<DataWall> dataModel, final RecyclerView.ViewHolder holder, int position) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(dataModel);
        ((WallViewHolder)holder).viewPager.setAdapter(adapter);
        ((WallViewHolder)holder).viewPager.setClipToPadding(false);
        ((WallViewHolder)holder).viewPager.setPadding(40, 0, 40, 0);
        if (position == 0) {
            ((WallViewHolder) holder).title.setText("Just for the weekend");
        }
        else{
            ((WallViewHolder)holder).title.setText("AirBnb Favorites");
        }
    }

   /* @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        ViewWithViewPager recycledViewPager = ((ViewWithViewPager)holder.itemView);
        wallTalls.add(recycledViewPager.viewPager.getCurrentItem());
        super.onViewRecycled(holder);
    }*/

    public static class WallViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_pager)
        ViewPager viewPager;

        @BindView(R.id.title)
        TextView title;

        public WallViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}