package com.deccanplast.app.deccanplastindustries;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chethan on 25/7/17.
 */

public class SliderAdapter extends PagerAdapter {
    private int[] mSliderImageResourceId;
    private String[] mSliderProductColorId;
    private LayoutInflater mInflater;
    private Context mContext;
    private String colorCodeString;

    public SliderAdapter(Context context, int[] sliderImageResourceId, String[] sliderProductColorId) {
        this.mContext = context;
        this.mSliderImageResourceId = sliderImageResourceId;
        this.mSliderProductColorId = sliderProductColorId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mSliderImageResourceId.length;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = mInflater.inflate(R.layout.slider, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
        myImage.setImageResource(mSliderImageResourceId[position]);

        TextView colorCode = (TextView) myImageLayout.findViewById(R.id.colorCode);
        colorCodeString = mContext.getText(R.string.colorCode) + mSliderProductColorId[position];
        colorCode.setText(colorCodeString);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
