package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Project{
    public Project(String projectCode, String name, String client, String buLeadName) {
        this.projectCode = projectCode;
        this.name = name;
        this.client = client;
        this.buLeadName = buLeadName;
    }
    public  String projectCode;
    public  String name ;
    public String client;
    public String buLeadName;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBuLeadName() {
        return buLeadName;
    }

    public void setBuLeadName(String buLeadName) {
        this.buLeadName = buLeadName;
    }
}
