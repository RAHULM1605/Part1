package com.groovenexus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistItem {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_url")
    @Expose
    private String userUrl;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("artist_type")
    @Expose
    private String artistType;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("profile_photo")
    @Expose
    private String profilePhoto;
    @SerializedName("favorite-authors")
    @Expose
    private String favoriteAuthors;
    @SerializedName("ec_stars_rating")
    @Expose
    private String ecStarsRating;
    @SerializedName("instrument")
    @Expose
    private String instrument;
    @SerializedName("youtube")
    @Expose
    private String youtube;
    @SerializedName("soundcloud")
    @Expose
    private String soundcloud;
    @SerializedName("instagram")
    @Expose
    private String instagram;
    @SerializedName("mixcloud")
    @Expose
    private String mixcloud;
    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("gigs")
    @Expose
    private String gigs;
    @SerializedName("youtube_channel")
    @Expose
    private String youtubeChannel;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public void setFavoriteAuthors(String favoriteAuthors) {
        this.favoriteAuthors = favoriteAuthors;
    }

    public String getEcStarsRating() {
        return ecStarsRating;
    }

    public void setEcStarsRating(String ecStarsRating) {
        this.ecStarsRating = ecStarsRating;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getMixcloud() {
        return mixcloud;
    }

    public void setMixcloud(String mixcloud) {
        this.mixcloud = mixcloud;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getGigs() {
        return gigs;
    }

    public void setGigs(String gigs) {
        this.gigs = gigs;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
