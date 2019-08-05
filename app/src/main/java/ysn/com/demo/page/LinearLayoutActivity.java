package ysn.com.demo.page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ysn.com.demo.R;
import ysn.com.demo.adapter.MyAdapter;
import ysn.com.demo.divider.LinearLayoutDivider;

/**
 * @Author yangsanning
 * @ClassName LinearLayoutActivity
 * @Description 一句话概括作用
 * @Date 2019/8/5
 * @History 2019/8/5 author: description:
 */
public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        setTitle(R.string.text_linear_layout);
        RecyclerView recyclerView = findViewById(R.id.linear_layout_activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new LinearLayoutDivider(this));
        recyclerView.setAdapter(new MyAdapter(getData(), this));
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            data.add("第" + i + "碗饭");
        }
        return data;
    }
}