package com.example.demo.Profile;

public class Profile {
    private String name;
    private double budget;
    private double allBudget;

    public Profile() {
    }

    public Profile (String name , double budget , double allBudget){
        this.name = name;
        this.budget = budget;
        this.allBudget = allBudget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getAllBudget() {
        return allBudget;
    }

    public void setAllBudget(double allBudget) {
        this.allBudget = allBudget;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", allBudget=" + allBudget +
                '}';
    }
}
