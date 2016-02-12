package com.abhinav.mytestapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by abhinavsharma on 12-02-2016.
 */
public class JsonReponse implements Parcelable {

    private String about;
    private String id;
    private String username;
    private int followers;
    private int following;
    private String image;
    private String url;
    private String handle;
    private boolean isFollowing;
    private String createdOn;
    private String description;
    private String verb;
    private String db;
    private String si;
    private String type;
    private String title;
    private boolean likeFlag;
    private int likesCount;
    private int commentCount;

    public static class List extends ArrayList<JsonReponse>{}

    /**
     *
     * @return
     * The about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The followers
     */
    public int getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     * The followers
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     * The following
     */
    public int getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     * The following
     */
    public void setFollowing(int following) {
        this.following = following;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The handle
     */
    public String getHandle() {
        return handle;
    }

    /**
     *
     * @param handle
     * The handle
     */
    public void setHandle(String handle) {
        this.handle = handle;
    }

    /**
     *
     * @return
     * The isFollowing
     */
    public boolean isIsFollowing() {
        return isFollowing;
    }

    /**
     *
     * @param isFollowing
     * The is_following
     */
    public void setIsFollowing(boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

    /**
     *
     * @return
     * The createdOn
     */
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     *
     * @param createdOn
     * The createdOn
     */
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The verb
     */
    public String getVerb() {
        return verb;
    }

    /**
     *
     * @param verb
     * The verb
     */
    public void setVerb(String verb) {
        this.verb = verb;
    }

    /**
     *
     * @return
     * The db
     */
    public String getDb() {
        return db;
    }

    /**
     *
     * @param db
     * The db
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     *
     * @return
     * The si
     */
    public String getSi() {
        return si;
    }

    /**
     *
     * @param si
     * The si
     */
    public void setSi(String si) {
        this.si = si;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The likeFlag
     */
    public boolean isLikeFlag() {
        return likeFlag;
    }

    /**
     *
     * @param likeFlag
     * The like_flag
     */
    public void setLikeFlag(boolean likeFlag) {
        this.likeFlag = likeFlag;
    }

    /**
     *
     * @return
     * The likesCount
     */
    public int getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The likes_count
     */
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    /**
     *
     * @return
     * The commentCount
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.about);
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeInt(this.followers);
        dest.writeInt(this.following);
        dest.writeString(this.image);
        dest.writeString(this.url);
        dest.writeString(this.handle);
        dest.writeByte(isFollowing ? (byte) 1 : (byte) 0);
        dest.writeString(this.createdOn);
        dest.writeString(this.description);
        dest.writeString(this.verb);
        dest.writeString(this.db);
        dest.writeString(this.si);
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeByte(likeFlag ? (byte) 1 : (byte) 0);
        dest.writeInt(this.likesCount);
        dest.writeInt(this.commentCount);
    }

    public JsonReponse() {
    }

    protected JsonReponse(Parcel in) {
        this.about = in.readString();
        this.id = in.readString();
        this.username = in.readString();
        this.followers = in.readInt();
        this.following = in.readInt();
        this.image = in.readString();
        this.url = in.readString();
        this.handle = in.readString();
        this.isFollowing = in.readByte() != 0;
        this.createdOn = in.readString();
        this.description = in.readString();
        this.verb = in.readString();
        this.db = in.readString();
        this.si = in.readString();
        this.type = in.readString();
        this.title = in.readString();
        this.likeFlag = in.readByte() != 0;
        this.likesCount = in.readInt();
        this.commentCount = in.readInt();
    }

    public static final Parcelable.Creator<JsonReponse> CREATOR = new Parcelable.Creator<JsonReponse>() {
        public JsonReponse createFromParcel(Parcel source) {
            return new JsonReponse(source);
        }

        public JsonReponse[] newArray(int size) {
            return new JsonReponse[size];
        }
    };
}
