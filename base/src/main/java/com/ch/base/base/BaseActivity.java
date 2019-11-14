package com.ch.base.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ch.base.R;
import com.google.gson.Gson;

import androidx.annotation.Nullable;

/**
 * Created by CH
 * on 2018/9/20 11:50
 */
public abstract class BaseActivity extends Activity {
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    // log
    private static Log log;

    private RelativeLayout toolbar;
    private TextView toolbar_title;
    private ImageView toolbar_back;
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
        //设置布局
        setContentView(initLayout());
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    protected <T extends View> T F(int id) {
        return (T) super.findViewById(id);
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int initLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();


    /**
     * 显示长toast
     *
     * @param msg
     */
    public void toastLong(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 显示短toast
     *
     * @param msg
     */
    public void toastShort(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    // log
    public void logCat(String msg) {
        Log.d(TAG, msg);
    }


    public void loadPic(String url, ImageView view) {
        Glide.with(getApplicationContext()).load(url).into(view);
    }


    // 界面跳转
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    // 携带参数的页面跳转
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    private void bindTitle() {
        toolbar = findViewById(R.id.layout_title_rlc);
        toolbar_back = toolbar.findViewById(R.id.layout_title_back);
        toolbar_title = toolbar.findViewById(R.id.layout_title_text);
        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar_title.setText("标题");
    }


}
