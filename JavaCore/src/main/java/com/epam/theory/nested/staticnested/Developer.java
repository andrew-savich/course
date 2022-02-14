package com.epam.theory.nested.staticnested;

/*
/Nested static classes have access to all static fields from
outer class, however with "private" modifier
Outer class doesn't have access to fields from nested class
 */
public class Developer {
    private String name;
    private Level level;
    private Team team;

    private int privateNonStaticField;
    private static int privateStaticField;

    //private int someNonStaticField = innerNonStaticField; - doesn't have access to nested non-static field from class
    private int someNonStaticField = new Team("some name").innerNonStaticField;

    //static field has access to static field from nested class
    private static int someStaticField = Team.innerStaticField;

    //static nested enum
    public static enum Level {
        TRAINEE, JUNIOR, MIDDLE, SENIOR, LEAD;
    }

    //Static nested class
    public static class Team {
        //int innerNonStaticField = privateNonStaticField; - doesn't work with non-static fields

        //Access to outer static field
         int innerNonStaticField = privateStaticField;

        private static int innerStaticField;

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
