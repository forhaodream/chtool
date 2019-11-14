package com.ch.base.view;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.ch.base.R;
import com.ch.base.adapter.PopupListAdapter;

/**
 * Created by CH
 * on 2018/11/26 0026 15:07
 */

public abstract class PopupWindowView<T> extends PopupWindow {
    private View popView;
    private PopupListAdapter<T> mPopupListAdapter;

    public PopupWindowView(int layoutid, Context context) {
        popupWindowView(context);

    }

    public abstract void convert(T t, int position);

    public void popupWindowView(Context context) {
        popView = View.inflate(context, R.layout.popwindow_list, null);
        ListView listView = (ListView) popView.findViewById(R.id.listview);
        mPopupListAdapter = new PopupListAdapter<T>() {
            @Override
            public void convert(T o, int position) {
                convert(o, position);
            }
        };
        listView.setAdapter(mPopupListAdapter);
        //获取屏幕宽高
        int weight = context.getResources().getDisplayMetrics().widthPixels;
        final PopupWindow popupWindow = new PopupWindow(popView, weight, WindowManager.LayoutParams.WRAP_CONTENT);
        //   popupWindow.setAnimationStyle(R.style.anim_popup_dir);
        popupWindow.setFocusable(true);
        //点击外部popueWindow消失
        popupWindow.setOutsideTouchable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                popupWindow.dismiss();
            }
        });

    }

}
