package com.java_lang_programming.android_listview_demo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.java_lang_programming.android_listview_demo.R;
import com.java_lang_programming.android_listview_demo.logic.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msuzuki on 2016/04/03.
 */
public class MyItemListViewAdapter extends ArrayAdapter<ArrayList<DummyItem>> {

    List<DummyItem> mList;

    public MyItemListViewAdapter(Context context, int resource, List<DummyItem> list) {
        super(context, resource);
        mList = list;
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        if (mList != null) {
            return position;
        } else {
            return -1;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_view_item, parent, false);
        }

        DummyItem dummyItem = mList.get(position);

        TextView id = (TextView) row.findViewById(R.id.id);
        id.setText(dummyItem.id);

        TextView content = (TextView) row.findViewById(
                R.id.content);
        content.setText(dummyItem.content);

        return row;

    }
}
