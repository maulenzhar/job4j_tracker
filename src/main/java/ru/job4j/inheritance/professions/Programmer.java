package ru.job4j.inheritance.professions;

public class Programmer extends Engineer {

    private boolean isHaveDeadline;

    public Programmer(String name, String surname, String education, String birthday, boolean isHaveComputer, boolean isHaveDeadline) {
        super(name, surname, education, birthday, isHaveComputer);
        this.isHaveDeadline = isHaveDeadline;
    }

    public boolean isHaveDeadline() {
        return isHaveDeadline;
    }

    public void setHaveDeadline(boolean haveDeadline) {
        isHaveDeadline = haveDeadline;
    }
}
