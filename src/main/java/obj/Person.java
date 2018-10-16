package obj;

import annot.CustomDateFormat;
import annot.JsonValue;

import java.time.LocalDate;

public class Person {

    private String firstName;

    private String lastName;

    @JsonValue(name ="fun")
    private String hobby;
    @CustomDateFormat(format ="dd-MM-yyyy")
    private LocalDate birthDate;

    public Person(String firstName, String lastName, String hobby, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
