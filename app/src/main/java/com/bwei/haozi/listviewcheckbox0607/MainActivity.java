package com.bwei.haozi.listviewcheckbox0607;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.bwei.haozi.listviewcheckbox0607.adapter.MainAdapter;
import com.bwei.haozi.listviewcheckbox0607.bean.CheckBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lv;
    private List<CheckBean> list = new ArrayList<>();
    private Button bt;
    private boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        lv = (ListView) findViewById(R.id.lv);
        bt = (Button) findViewById(R.id.bt);

        final MainAdapter adapter = new MainAdapter(list,MainActivity.this);

        lv.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0;i< list.size();i++ ){

                    if (!checked){

                       list.get(i).setIscheck(true);

                    }else{

                        list.get(i).setIscheck(false);

                    }

                }
                adapter.notifyDataSetChanged();

                if (!checked){

                    checked = true;

                }else{

                    checked = false;

                }




            }
        });

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                if (mtotalItemCount - mvisibleItemCount - mfirstVisibleItem <= 5){

                    for (int i = 51; i < 100; i++){

                        CheckBean checkBean = new CheckBean();

                        checkBean.setContent("呦呦"+i);

                        list.add(checkBean);

                    }

                    adapter.notifyDataSetChanged();


                }


            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

              mfirstVisibleItem = firstVisibleItem;
                mvisibleItemCount = visibleItemCount;
                mtotalItemCount = totalItemCount;

            }
        });





    }

    public int mfirstVisibleItem; int mvisibleItemCount; int mtotalItemCount;

    private void getData(){

        for (int i = 0; i < 50; i++){

            CheckBean checkBean = new CheckBean();

            checkBean.setContent("呦呦"+i);

            list.add(checkBean);

        }

    }
}
