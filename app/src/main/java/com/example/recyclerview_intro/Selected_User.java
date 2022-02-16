package com.example.recyclerview_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Selected_User extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        textView = findViewById(R.id.seletecusr);

        Intent intent = getIntent();

        if (intent.getExtras() != null){

            UserModel userModel = (UserModel) intent.getSerializableExtra("data");
            textView.setText(userModel.getUsername());

        }

    }
}