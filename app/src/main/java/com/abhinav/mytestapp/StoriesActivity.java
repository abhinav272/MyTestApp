package com.abhinav.mytestapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.abhinav.mytestapp.Adapter.CustomBaseAdapter;
import com.abhinav.mytestapp.Model.JsonReponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by abhinavsharma on 11-02-2016.
 */
public class StoriesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private CardView mCardView;
    private ListView storiesListView;
    private String formArray;
    private JsonReponse.List responseList = null;
    private CustomBaseAdapter customBaseAdapter;
    private ArrayList<JsonReponse> users = new ArrayList<JsonReponse>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stories_activity);
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String AssetJSONFile (String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }

    private void initialize() throws IOException {
        storiesListView = (ListView) findViewById(R.id.storieslistview);
        formArray = AssetJSONFile("iOS-Android Data.json",this);
        Gson gson = new Gson();
        responseList = gson.fromJson(formArray,JsonReponse.List.class);
        customBaseAdapter = new CustomBaseAdapter(StoriesActivity.this,responseList);
        storiesListView.setAdapter(customBaseAdapter);
        storiesListView.setOnItemClickListener(this);

        for(JsonReponse obj:responseList){
            if(obj.getType()==null){
                users.add(obj);
            }
        }




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        if(responseList.get(position).getUsername()==null){
            intent = new Intent(StoriesActivity.this,StoryDetailActivity.class);
        }
        else{
            intent = new Intent(StoriesActivity.this,UserDetailActivity.class);
        }

        intent.putExtra("item",responseList.get(position));
        intent.putParcelableArrayListExtra("users",users);
        startActivity(intent);
    }


}
