package com.abhinav.mytestapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.abhinav.mytestapp.CustomView.CircleImageView;
import com.abhinav.mytestapp.Model.JsonReponse;
import com.abhinav.mytestapp.R;
import com.abhinav.mytestapp.Utils.PreferenceUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by abhinavsharma on 12-02-2016.
 */
public class CustomBaseAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    private ArrayList<JsonReponse> reponseArrayList;
    private ViewHolder holder;


    static class ViewHolder{
        CircleImageView image;
        TextView header1, header2, header3;
        Button followButton;
    }

    public CustomBaseAdapter (Context mContext, JsonReponse.List reponseArrayList){
        this.mContext = mContext;
        this.reponseArrayList = reponseArrayList;
    }


    @Override
    public int getCount() {
        return reponseArrayList.size();
    }

    @Override
    public JsonReponse getItem(int position) {
        return reponseArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            view = new View(mContext);
            view = inflater.inflate(R.layout.single_story_layout,parent,false);
            holder = new ViewHolder();
            holder.image = (CircleImageView) view.findViewById(R.id.image);
            holder.header1 = (TextView) view.findViewById(R.id.header1);
            holder.header2 = (TextView) view.findViewById(R.id.header2);
            holder.header3 = (TextView) view.findViewById(R.id.header3);
            holder.followButton = (Button) view.findViewById(R.id.followbutton);
            holder.followButton.setOnClickListener(this);
            view.setTag(holder);

        }

        else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        if(getItem(position).getUsername()==null){
            holder.header1.setText(getItem(position).getTitle());
            holder.header2.setText(getItem(position).getDescription());
            holder.header3.setText(getItem(position).getVerb());
            holder.followButton.setTag(getItem(position).getDb());
            if(PreferenceUtils.getFollowStatus(mContext,getItem(position).getDb()).equals(PreferenceUtils.UNFOLLOWED)
                    ||PreferenceUtils.getFollowStatus(mContext,getItem(position).getDb()).equals("NoStatus")){
                holder.followButton.setText("Follow this user");
            }else holder.followButton.setText("Unfollow this user");

            Picasso.with(mContext).load(getItem(position).getSi()).fit().centerCrop().into(holder.image);
        }
        else{
            holder.header1.setText(getItem(position).getUsername());
            holder.header2.setText(getItem(position).getHandle());
//            if(getItem(position).isIsFollowing())
//                holder.header3.setText("You Are following this story");
//            else holder.header3.setText("Follow");
            holder.header3.setText(getItem(position).getFollowers()+" Followers");
            holder.followButton.setTag(getItem(position).getId());
            if(PreferenceUtils.getFollowStatus(mContext,getItem(position).getId()).equals(PreferenceUtils.UNFOLLOWED)
                    ||PreferenceUtils.getFollowStatus(mContext,getItem(position).getId()).equals("NoStatus")){
                holder.followButton.setText("Follow this user");
            }else holder.followButton.setText("Unfollow this user");
            Picasso.with(mContext).load(getItem(position).getImage()).fit().centerCrop().into(holder.image);



        }
        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.followbutton){
            if(PreferenceUtils.getFollowStatus(mContext,v.getTag().toString()).equalsIgnoreCase(PreferenceUtils.UNFOLLOWED)
                    ||PreferenceUtils.getFollowStatus(mContext,v.getTag().toString()).equalsIgnoreCase("NoStatus")) {
                PreferenceUtils.saveFollowStatus(mContext, v.getTag().toString(), PreferenceUtils.FOLLOWED);
                holder.followButton.setText("Unfollow this user");
                notifyDataSetChanged();
            } else {
                PreferenceUtils.saveFollowStatus(mContext, v.getTag().toString(), PreferenceUtils.UNFOLLOWED);
                holder.followButton.setText("Follow this user");
                notifyDataSetChanged();
            }
        }
    }

}
