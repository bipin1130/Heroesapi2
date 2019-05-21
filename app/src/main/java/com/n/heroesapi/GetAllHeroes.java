package com.n.heroesapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import Interface.HeroApi;
import model.Hero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetAllHeroes extends AppCompatActivity {
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_heroes);

        display=findViewById(R.id.display);

        Retrofit retrofit=new Retrofit.
                Builder().baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HeroApi heroApi=retrofit.create(HeroApi.class);

        Call <List<Hero>> heroCall=heroApi.getHero();

        heroCall.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> herolist=response.body();

                for (Hero hero: herolist) {
                    String context="";
                    context+="Name:" +hero.getName()+"\n";
                    context+="Description" +hero.getDesc()+"\n";
                    context+="................................."+"\n";

                    display.append(context);
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });

    }
}
