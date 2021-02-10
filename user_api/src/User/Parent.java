package User;

import Additional.Address;

public class Parent
{
    protected String firstName ;
    protected String lastName ;
    private Address address ;

    public Parent(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Parent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Address getAddress() {
        if (getClass().equals(Parent.class)) {
            return address;
        } else {
            throw new UnsupportedOperationException("Only Parent cannot access address");
        }
    }

    public void setAddress(Address address) {
        if (getClass().equals(Parent.class)) {
            this.address = address;
        } else {
            throw new UnsupportedOperationException("Only Parent cannot access address");
        }
    }

    @Override
    public String toString() {
        return firstName+","+lastName+","+address ;
    }
}
