package com.sunil.recyclerviewviewpager.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunil.recyclerviewviewpager.R;
import com.sunil.recyclerviewviewpager.daogen.DataWall;

import java.util.List;

/**
 * Created by kuliza-195 on 11/23/16.
 */

public class ViewPagerAdapter extends PagerAdapter{

    List<DataWall> dataModels;
   public ViewPagerAdapter(List<DataWall> dataModels){
        this.dataModels = dataModels;
    }

    @Override
    public int getCount() {
        return dataModels.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.view_pager_row, container, false);
        ImageView imageViewCampaign = (ImageView) itemView.findViewById(R.id.imageview_campaign);
        TextView textViewCampaign = (TextView) itemView.findViewById(R.id.textview_campaign);
        DataWall wall = dataModels.get(position);
        String imageUrl = wall.getImageurl();
        if (imageUrl != null && !imageUrl.isEmpty()){
            Glide.with(container.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    //.placeholder(R.drawable.ic)
                    .crossFade()
                    .into(imageViewCampaign);

        }
        textViewCampaign.setText(wall.getName());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
