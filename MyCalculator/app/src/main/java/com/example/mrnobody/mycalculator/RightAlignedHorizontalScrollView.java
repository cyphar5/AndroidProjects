package com.example.mrnobody.mycalculator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

/**
 * Created by Mr. Nobody on 10/7/2016.
 */

public class RightAlignedHorizontalScrollView extends HorizontalScrollView {
    TextView mTextView1,mTextView2;


    public RightAlignedHorizontalScrollView(Context context) {
        super(context);
    }

    public RightAlignedHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RightAlignedHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mTextView1=(TextView)findViewById(R.id.edit_text_calc);
        mTextView2=(TextView)findViewById(R.id.intermediate);
        l=0;
        r=getChildAt(0).getMeasuredWidth();
        super.onLayout(true,l,t,r, b);
        scrollTo(r,l);

      //  mTextView1.setGravity(Gravity.END);
        //mTextView2.setGravity(Gravity.END);
    }
}
