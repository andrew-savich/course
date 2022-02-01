package com.epam.task2;

import com.epam.task2.divisions.FlyingDivision;
import com.epam.task2.divisions.InfantryDivision;
import com.epam.task2.divisions.MilitaryHeadquarters;

import java.util.ArrayList;
import java.util.List;

public class MainRunner {
    public static void main(String[] args) {
        List<MilitaryHeadquarters> divisions = new ArrayList<>();

        divisions.add(new InfantryDivision("1st Infantry Division"));
        divisions.add(new InfantryDivision("2nd Infantry Division"));
        divisions.add(new InfantryDivision("3rd Infantry Division"));
        divisions.add(new InfantryDivision("4th Infantry Division"));
        divisions.add(new InfantryDivision("5th Infantry Division"));

        divisions.add(new FlyingDivision("1st Flying Division"));
        divisions.add(new FlyingDivision("2nd Flying Division"));
        divisions.add(new FlyingDivision("3rd Flying Division"));
        divisions.add(new FlyingDivision("4th Flying Division"));
        divisions.add(new FlyingDivision("5th Flying Division"));

        for (MilitaryHeadquarters division : divisions) {
            division.report();
        }
    }
}
