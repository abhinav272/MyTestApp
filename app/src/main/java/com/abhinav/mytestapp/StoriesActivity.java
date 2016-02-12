package com.abhinav.mytestapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
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
public class StoriesActivity extends AppCompatActivity {

    private CardView mCardView;
    private ListView storiesListView;
    private String formArray;
    private JsonReponse.List responseList = null;
    private CustomBaseAdapter customBaseAdapter;

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


    }
}
