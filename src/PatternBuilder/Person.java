package PatternBuilder;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        OptionalInt oiAge = OptionalInt.of(age);
        return oiAge;
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Возраст не может быть изменён, т.к. возраст не известен");
        }
    }

    boolean hasAge() {
        OptionalInt oiAge = getAge();
        return oiAge.isPresent();
    }

    boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAddress(this.address);
        return child;
    }

    @Override
    public String toString() {
        return (this.surname + " " + this.name);
    }

    @Override
    public int hashCode() {
        return surname.hashCode() + name.hashCode() + address.hashCode() + age;
    }
}