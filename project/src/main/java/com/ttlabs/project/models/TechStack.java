package com.ttlabs.project.models;

import javax.persistence.*;

@Entity
@Table(name = "TechStack")
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "stackName")
    private String stackName;

    @Column(name = "experienceLevel")
    private String experienceLevel;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "profile_id",nullable = false)
    private Profile profile;

    public Long getId() {
        return id;
    }

    public String getStackName() {
        return stackName;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
