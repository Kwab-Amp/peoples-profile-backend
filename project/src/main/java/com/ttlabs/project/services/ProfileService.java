package com.ttlabs.project.services;

import com.ttlabs.project.models.Profile;

import javax.transaction.Transactional;
import java.util.List;

public interface ProfileService {
    void addAllProfiles(List<Profile> profiles);
    void addProfile(Profile profile);
    void updateProfile(Long profileId,String currentProject,String title,String department,String fullName,boolean isManager);
    List<Profile> getEmployeeProfiles();
    void  deleteProfile(Long profileId);
}
