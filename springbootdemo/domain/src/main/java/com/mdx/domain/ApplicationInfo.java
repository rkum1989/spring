////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: ApplicationInfo.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.domain;


public class ApplicationInfo {
    private String[] profiles;
    private String[] services;

    public ApplicationInfo(String[] profiles, String[] services) {
        this.profiles = profiles.clone();
        this.services = services.clone();
    }

    public String[] getProfiles() {
        return profiles.clone();
    }

    public void setProfiles(String[] profiles) {
        this.profiles = profiles.clone();
    }

    public String[] getServices() {
        return services.clone();
    }

    public void setServices(String[] services) {
        this.services = services.clone();
    }
}
