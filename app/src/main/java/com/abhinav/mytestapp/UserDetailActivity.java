package com.abhinav.mytestapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abhinav.mytestapp.CustomView.CircleImageView;
import com.abhinav.mytestapp.Model.JsonReponse;
import com.abhinav.mytestapp.Utils.BlurTransform;
import com.abhinav.mytestapp.Utils.PreferenceUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abhinavsharma on 12-02-2016.
 */
public class UserDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagebg;
    private CircleImageView image;
    private TextView name,followers,handle,about,createdon;
    private Button follow;
    private JsonReponse item;
    private String createdDate;
    private String month[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail_activity);
        initialize();

    }

    private void initialize(){
        item = getIntent().getParcelableExtra("item");
        Date date = new Date(item.getCreatedOn());
        createdDate = date.getDate()+" "+ month[date.getMonth()]+" "+(date.getYear()+1900);
        name = (TextView) findViewById(R.id.name);
        followers = (TextView) findViewById(R.id.followers);
        handle = (TextView) findViewById(R.id.handle);
        about = (TextView) findViewById(R.id.about);
        createdon = (TextView) findViewById(R.id.createdon);
        image = (CircleImageView) findViewById(R.id.image);
        imagebg = (ImageView) findViewById(R.id.imagebg);
        follow = (Button) findViewById(R.id.follow);
        follow.setOnClickListener(this);
        setupUI();
    }
    private void setupUI(){
        Picasso.with(this).load(item.getImage()).fit().centerCrop().into(image);
        Picasso.with(this).load(item.getImage()).fit().centerCrop().transform(new BlurTransform(this)).into(imagebg);
        name.setText(item.getUsername());
        followers.setText(item.getFollowers()+" Followers");
        handle.setText(item.getHandle());
        about.setText(item.getAbout());
        createdon.setText("Created On: "+createdDate);
        if(PreferenceUtils.getFollowStatus(this,item.getId()).equalsIgnoreCase("Followed"))
            follow.setText("Unfollow");
    }

    @Override
    public void onClick(View v) {
        if(v.getTag().equals("Follow")){
            Snackbar.make(v,"You are now following "+item.getUsername(),Snackbar.LENGTH_SHORT).show();
            PreferenceUtils.saveFollowStatus(this,item.getId(),"Followed");
            follow.setTag("Unfollow");
            follow.setText("Unfollow");
        }
        else {
            Snackbar.make(v,"You just Unfollowed "+item.getUsername(),Snackbar.LENGTH_SHORT).show();
            PreferenceUtils.saveFollowStatus(this,item.getId(),"UnFollowed");
            follow.setTag("Follow");
            follow.setText("Follow");
        }

    }
}
