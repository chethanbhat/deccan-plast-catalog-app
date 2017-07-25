package com.deccanplast.app.deccanplastindustries;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by chethan on 25/7/17.
 */

public class SliderAdapter extends PagerAdapter {
    private int[] mSliderImageResouceId;
    private LayoutInflater mInflater;
    private Context mContext;

    public SliderAdapter(Context context, int[] sliderImageResouceId) {
        this.mContext = context;
        this.mSliderImageResouceId = sliderImageResouceId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mSliderImageResouceId.length;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = mInflater.inflate(R.layout.slider, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
        myImage.setImageResource(mSliderImageResouceId[position]);
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
