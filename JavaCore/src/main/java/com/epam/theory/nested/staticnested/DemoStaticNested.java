package com.epam.theory.nested.staticnested;

public class DemoStaticNested {
    public static void main(String[] args) {
        Developer devAndrew = new Developer();
        devAndrew.setName("Andrew");
        devAndrew.setLevel(Developer.Level.JUNIOR);
        devAndrew.setTeam(new Developer.Team("Hades"));

        System.out.println(devAndrew);
    }
}
