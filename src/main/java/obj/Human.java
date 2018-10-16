package obj;

import annot.CustomDateFormat;

import java.time.LocalDate;

public class Human {
    private String firstName;
    private String lastName;
    private String hobby;
    private LocalDate birthDate;

    public Human(String firstName, String lastName, String hobby, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHobby() {
        return hobby;
    }

    public LocalDate getBirthDate() {

        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
