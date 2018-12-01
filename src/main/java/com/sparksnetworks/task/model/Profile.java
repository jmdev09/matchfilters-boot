package com.sparksnetworks.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Maroju, Jithender on 27/11/18
 */

public class Profile implements Serializable {

    private static final long serialVersionUID = 8273345667361655513L;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("age")
    private int age;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("height_in_cm")
    private int heightInCm;

    @JsonProperty("city")
    private City city;

    @JsonProperty("main_photo")
    private String mainPhoto;

    @JsonProperty("compatibility_score")
    private double compatabilityScore;

    @JsonProperty("contacts_exchanged")
    private int contactsExchanged;

    @JsonProperty("favourite")
    private boolean favourite;

    @JsonProperty("religion")
    private String religion;


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public double getCompatabilityScore() {
        return compatabilityScore;
    }

    public void setCompatabilityScore(double compatabilityScore) {
        this.compatabilityScore = compatabilityScore;
    }

    public int getContactsExchanged() {
        return contactsExchanged;
    }

    public void setContactsExchanged(int contactsExchanged) {
        this.contactsExchanged = contactsExchanged;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "displayName='" + displayName + '\'' +
                ", age=" + age +
                ", jobTitle='" + jobTitle + '\'' +
                ", heightInCm=" + heightInCm +
                ", city=" + city +
                ", mainPhoto='" + mainPhoto + '\'' +
                ", compatabilityScore=" + compatabilityScore +
                ", contactsExchanged=" + contactsExchanged +
                ", favourite=" + favourite +
                ", religion='" + religion + '\'' +
                '}';
    }
}
