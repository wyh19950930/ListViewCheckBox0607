package com.bwei.haozi.listviewcheckbox0607.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwei.haozi.listviewcheckbox0607.R;
import com.bwei.haozi.listviewcheckbox0607.bean.CheckBean;

import java.util.List;

/**
 * Created by haozi on 2017/6/7.
 */

public class MainAdapter extends BaseAdapter {

    private List<CheckBean> list;
    private Context context;

    public MainAdapter(List<CheckBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null){

            viewHolder = new ViewHolder();

            convertView = View.inflate(context, R.layout.checkitem, null);

            viewHolder.textView = (TextView) convertView.findViewById(R.id.textview);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.check);

            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.textView.setText(list.get(position).getContent());
        viewHolder.checkBox.setChecked(list.get(position).ischeck());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (list.get(position).ischeck()){

                    list.get(position).setIscheck(false);
                    viewHolder.checkBox.setChecked(false);

                }else{

                    list.get(position).setIscheck(true);
                    viewHolder.checkBox.setChecked(true);

                }

                notifyDataSetChanged();

            }
        });

        return convertView;
    }

    class ViewHolder{

        TextView textView;
        CheckBox checkBox;

    }
}
