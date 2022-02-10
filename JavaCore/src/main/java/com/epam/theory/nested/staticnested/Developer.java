package com.epam.theory.nested.staticnested;

public class Developer {
    private String name;
    private Level level;
    private Team team;

    //static nested enum
    public static enum Level {
        TRAINEE, JUNIOR, MIDDLE, SENIOR, LEAD;
    }

    //Static nested class
    public static class Team {
        private String name;

        public Team(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", team=" + team +
                '}';
    }
}
