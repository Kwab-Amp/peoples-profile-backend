package com.ttlabs.project.services;

import com.ttlabs.project.models.GetFromBob;
import com.ttlabs.project.models.Profile;
import com.ttlabs.project.repositories.ProfileRepository;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void addAllProfiles(List<Profile> profiles) {
        profileRepository.saveAll(profiles);
    }

    @Override
    public void addProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    @Transactional
    public void updateProfile(Long profileId, String currentProject, String title, String department, String fullName, boolean isManager) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new IllegalStateException(
                "Profile with id" + profileId + "doesn't exist"
        ));
        if (fullName != null && !Objects.equals(profile.getFullName(), fullName)) {
            profile.setFullName(fullName);
        }

        if (currentProject != null && !Objects.equals(profile.getCurrentProject(), currentProject)) {
            profile.setCurrentProject(currentProject);
        }

        if (title != null && !Objects.equals(profile.getTitle(), title)) {
            profile.setTitle(title);
        }

        if (department != null && !Objects.equals(profile.getDepartment(), department)) {
            profile.setDepartment(department);
        }

        if (!Objects.equals(profile.isManager(), isManager)) {
            profile.setManager(isManager);
        }
    }

    @Override
    public List<Profile> getEmployeeProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public void deleteProfile(Long profileId) {
        boolean exists = profileRepository.existsById(profileId);
        if (!exists) {
            throw new IllegalStateException("Profile with id" + profileId + "doesn't exist");
        }
        profileRepository.deleteById(profileId);
    }
}
