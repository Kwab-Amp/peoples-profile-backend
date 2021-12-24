package com.ttlabs.project.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="fullName",updatable = true,nullable = false)
    private String fullName;

    @Column(name = "department",updatable = true,nullable = true)
    private String department;

    @Column(name="email")
    private String email;

    @Column(name="title",updatable = true)
    private String title;

    @Column(name="profilePicture",nullable = true)
    private String profilePicture;

    @Column(name = "currentProject",updatable = true,nullable = true)
    private String currentProject;

//    @Column(name = "cv",updatable = true,nullable = true)
//    private String cv;

    @Column(name="isManager",updatable = true,columnDefinition = "boolean default false")
    private boolean isManager;

    @Column(name = "site",nullable = true)
    private String site;

    @OneToMany(mappedBy = "profile",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<TechStack> techStack;


    public String getEmail() {
        return email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

//    public void setCv(String cv) {
//        this.cv = cv;
//    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public Long getId() {
        return id;
    }

    public Set<TechStack> getTechStack() {
        return techStack;
    }

    public void setTechStack(Set<TechStack> techStack) {
        this.techStack = techStack;
    }
//    public String getCv() {
//        return cv;
//    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
