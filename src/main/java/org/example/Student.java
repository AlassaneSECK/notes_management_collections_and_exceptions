package org.example;

public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return firstName.equalsIgnoreCase(s.firstName) &&
                lastName.equalsIgnoreCase(s.lastName);
    }

    @Override
    public int hashCode() {
        return firstName.toLowerCase().hashCode() + lastName.toLowerCase().hashCode();
    }
}
