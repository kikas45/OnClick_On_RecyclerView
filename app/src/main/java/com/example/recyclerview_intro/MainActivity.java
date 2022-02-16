package com.example.recyclerview_intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdapter.Selecteduser{
    RecyclerView recyclerView;
    Toolbar toolbar;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<UserModel> userModelList = new ArrayList<>();

        String[] names = {"David", "john", "Simon", "james "};


        recyclerView = findViewById(R.id.recucler_view);
        toolbar = findViewById(R.id.toolbar);

        // tol bar

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        /// recycler view

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // setting the user adpater

        /// declearing the array oblect

        for (String s:names){

            UserModel userModel = new UserModel(s);
            userModelList.add(userModel);

        }
        userAdapter = new UserAdapter(userModelList, this);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void selecteduser(UserModel userModel) {
        startActivity(new Intent(MainActivity.this, Selected_User.class).putExtra("data", userModel));

    }
}