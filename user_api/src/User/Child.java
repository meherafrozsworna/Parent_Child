package User;


public class Child extends Parent {

    public Child(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName+","+lastName ;
    }
}
