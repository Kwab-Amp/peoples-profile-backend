package com.ttlabs.project.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class GetFromBob implements Serializable {
    private HashMap<String,String> profiles;

    public HashMap<String, String> getProfiles() {
        return profiles;
    }

    public void setProfiles(HashMap<String, String> profiles) {
        this.profiles = profiles;
    }
}
