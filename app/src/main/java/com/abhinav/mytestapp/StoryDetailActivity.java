package com.abhinav.mytestapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhinav.mytestapp.Model.JsonReponse;
import com.squareup.picasso.Picasso;

/**
 * Created by abhinavsharma on 12-02-2016.
 */
public class StoryDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private JsonReponse item = null;
    private ImageView image,like;
    private TextView storytitle,storydescription,createdon,likescount;
    private Button viewstory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_detail_activity);
        initialize();
    }

    private void initialize(){
        item = getIntent().getParcelableExtra("item");
        image = (ImageView) findViewById(R.id.image);
        like = (ImageView) findViewById(R.id.like);
        storytitle = (TextView) findViewById(R.id.storytitle);
        storydescription = (TextView) findViewById(R.id.storydescription);
        createdon = (TextView) findViewById(R.id.createdon);
        likescount = (TextView) findViewById(R.id.likescount);
        viewstory = (Button) findViewById(R.id.viewstory);
        setUpUI(item);
        like.setOnClickListener(this);
        viewstory.setOnClickListener(this);

    }

    private void setUpUI(JsonReponse item){
        if(item.getSi()!=null)
            Picasso.with(this).load(item.getSi()).fit().centerCrop().into(image);
        storytitle.setText(item.getTitle());
        storydescription.setText(item.getDescription());
        createdon.setText(item.getVerb());
        likescount.setText(item.getLikesCount()+" Likes");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.like:
                like.setImageDrawable(getResources().getDrawable(R.drawable.like));
                int count = Integer.valueOf(item.getLikesCount())+1;
                likescount.setText(count+" Likes");
                break;
            case R.id.viewstory:
                Intent viewStoryInBrowser = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(item.getUrl()));
                if(viewStoryInBrowser.resolveActivity(getPackageManager())!=null){
                    startActivity(Intent.createChooser(viewStoryInBrowser,"Choose the browser"));
                }
                break;
        }
    }
}