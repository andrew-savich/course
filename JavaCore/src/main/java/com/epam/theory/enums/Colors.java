package com.epam.theory.enums;

enum Colors {
    RED("ff0000"), GREEN("00ff00"), BLUE("0000ff"), WHITE("ffffff"), BLACK("000000");

    private String hex;

    Colors(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
