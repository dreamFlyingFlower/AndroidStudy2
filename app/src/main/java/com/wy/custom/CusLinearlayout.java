package com.wy.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wy.R;

/**
 * 自定义一个线性布局,构造函数的参数意义
 */
public class CusLinearlayout extends LinearLayout {

    public CusLinearlayout(Context context) {
        super(context);
    }

    public CusLinearlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CusLinearlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化LinearLayout视图
     */
    private void initView() {
        // 设置LinearLayout的布局方向
        setOrientation(LinearLayout.VERTICAL);
        // 设置布局参数
        LinearLayout.LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(getContext());
        tv.setText(R.string.prompt_loginname);
        // 在MyLinearLayout里面添加TextView
        addView(tv, params);
        for (int i = 0; i < 10; i++) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(R.drawable.test01);
            // 设置动画
            //  Animation animation1 = AnimationUtils.loadAnimation(getContext(),
            //        R.anim.rotate);
            // iv.setAnimation(animation1);
            // 在MyLinearLayout里面添加10个带动画的ImageView
            addView(iv, params);
        }
    }

    /**
     * 对子view进行布局，确定子view的位置
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    /**
     * 测量尺寸时的回调方法
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}