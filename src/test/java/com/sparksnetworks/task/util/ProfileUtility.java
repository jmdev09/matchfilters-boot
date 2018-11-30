package com.sparksnetworks.task.util;

import com.sparksnetworks.task.model.City;
import com.sparksnetworks.task.model.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Maroju, Jithender on 29/11/18
 */
public class ProfileUtility {

    private static Map<String,City> cityMap = new HashMap<>();

    static {
        City leeds = new City("Leeds",53.801277,-1.548567);
        City solihull = new City("Solihull",52.412811,-1.778197);
        City eastbourne = new City("Eastbourne",50.768036,0.290472);
        City london = new City("London",51.509865,-0.118092);
        City swindon = new City("Swindon",51.568535,-1.772232);

        cityMap.put("Leeds",leeds);
        cityMap.put("Solihull",solihull);
        cityMap.put("Eastbourne",eastbourne);
        cityMap.put("London",london);
        cityMap.put("Swindon",swindon);

    }

    public static List<Profile> getProfiles() {
        List<Profile> profiles = new ArrayList<>();

        Profile p1 = createProfile("Caroline",41,153,"dummy-url", 0.76,2,true,"Leeds");
        Profile p2 = createProfile("Sharon",47,162,"dummy-url", 0.97,0,false,"Solihull");
        Profile p3 = createProfile("Marta",55,140,"dummy-url", 0.95,0,false,"Eastbourne");
        Profile p4 = createProfile("Maria",43,175,"dummy-url", 0.88,0,false,"London");
        Profile p5 = createProfile("Colette",39,177,"dummy-url", 0.89,2,false,"Swindon");

        profiles.add(p1);
        profiles.add(p2);
        profiles.add(p3);
        profiles.add(p4);
        profiles.add(p5);

        return profiles;
    }

    public static Profile createProfile(String displayName, int age, int height, String photo, double score, int contacts, boolean favourite, String city ){
        Profile profile = new Profile();
        profile.setDisplayName(displayName);
        profile.setAge(age);
        profile.setContactsExchanged(contacts);
        profile.setCompatabilityScore(score);
        profile.setHeightInCm(height);
        profile.setMainPhoto(photo);
        profile.setFavourite(favourite);
        profile.setCity(cityMap.get(city));
        return profile;
    }
}
