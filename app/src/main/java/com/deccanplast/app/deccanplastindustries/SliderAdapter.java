package com.deccanplast.app.deccanplastindustries;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Product Slider for the Product Page
 */

public class SliderAdapter extends PagerAdapter {
    private int[] mSliderImageResourceId;
    private String[] mSliderProductColorId;
    private LayoutInflater mInflater;
    private Context mContext;

    /**
     * Slider Adapter to generates Product Slider
     *
     * @param context               refers to current activity context
     * @param sliderImageResourceId refers to Product Slider Images
     * @param sliderProductColorId  refers to Color associated with Product Sldier Images
     */

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
        ImageView myImage = myImageLayout
                .findViewById(R.id.image);
        myImage.setImageResource(mSliderImageResourceId[position]);

        if(mSliderProductColorId.length > 0){
            TextView colorCode = myImageLayout.findViewById(R.id.colorCode);
            String colorCodeString = mContext.getText(R.string.colorCode) + mSliderProductColorId[position];
            colorCode.setText(colorCodeString);
        }

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
