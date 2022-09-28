package com.example.BTL_App_truyen_tranh.GUI.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.BTL_App_truyen_tranh.R;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    private RecyclerView list_item_truyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        list_item_truyen=findViewById(R.id.list_item_truyen);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        list_item_truyen.setLayoutManager(gridLayoutManager);
        HomeItemTruyen homeItemTruyen=new HomeItemTruyen(getList());
        list_item_truyen.setAdapter(homeItemTruyen);

    }

    private List<String> getList() {
        List<String>list=new ArrayList<>();
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        return list;
    }

}