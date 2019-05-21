package com.n.heroesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button View, Post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View=findViewById(R.id.btnview);
        Post=findViewById(R.id.btnAdd);
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent=new Intent(MainActivity.this, GetAllHeroes.class);
                startActivity(intent);
            }
        });

        Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent=new Intent(MainActivity.this, AddHeroActivity.class);
                startActivity(intent);
            }
        });

    }
}
