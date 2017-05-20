package com.epam.jmp.cms.user.model;

/**
 * Created by Aleksei_Okhrimenko on 15.05.2017.
 */
public class Description {
    private String jobFunction = "Software Engineering";
    private Integer level = 3;
    private String primarySkill = "Scala";
    private Integer points = 100;

    public String getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
