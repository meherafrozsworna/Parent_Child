package Main;

import Additional.Address;
import Api.ParentApi;
import User.Parent;

import java.io.IOException;
import java.util.Scanner;

public class ParentMain {
    public static void main(String[] args) throws IOException {

        ParentApi api = new ParentApi();

        System.out.println("Parent : ");
        while (true){
            System.out.println("1.Create 2.Delete 3.Update 4.exit\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1){
                System.out.println("Give first name : ");
                String firstName = scanner.next();
                System.out.println("Give last name : ");
                String lastName = scanner.next();
                System.out.println("Give Address : ");
                System.out.println("Street : ");
                String street = scanner.next();
                System.out.println("City : ");
                String city = scanner.next();
                System.out.println("State : ");
                String state = scanner.next();
                System.out.println("Zip : ");
                String zip = scanner.next();

                Address address = new Address(street,city,state,zip);
                Parent parent = new Parent(firstName,lastName,address);
                api.insertParent(parent);
            }else if(choice == 2){
                System.out.println("Give first name : ");
                String firstName = scanner.next();
                System.out.println("Give last name : ");
                String lastName = scanner.next();
                System.out.println("Give Address : ");
                System.out.println("Street : ");
                String street = scanner.next();
                System.out.println("City : ");
                String city = scanner.next();
                System.out.println("State : ");
                String state = scanner.next();
                System.out.println("Zip : ");
                String zip = scanner.next();

                Address address = new Address(street,city,state,zip);
                Parent parent = new Parent(firstName,lastName,address);
                api.deleteParent(parent);
            }else if(choice == 3){
                System.out.println("Give first name : ");
                String firstName = scanner.next();
                System.out.println("Give last name : ");
                String lastName = scanner.next();
                System.out.println("Give Address : ");
                System.out.println("Street : ");
                String street = scanner.next();
                System.out.println("City : ");
                String city = scanner.next();
                System.out.println("State : ");
                String state = scanner.next();
                System.out.println("Zip : ");
                String zip = scanner.next();

                Address address = new Address(street,city,state,zip);
                Parent oldParent = new Parent(firstName,lastName,address);

                System.out.println("Do you want to change first name : (y/n)");
                String s = scanner.next();
                if (s.toLowerCase().equals("y")){
                    System.out.println("Give first name : ");
                    firstName = scanner.next();
                }
                System.out.println("Do you want to change last name : (y/n)");
                s = scanner.next();
                if (s.toLowerCase().equals("y")){
                    System.out.println("Give last name : ");
                    lastName = scanner.next();
                }
                System.out.println("Do you want to change address : (y/n)");
                s = scanner.next();
                Address newAddress = address;
                if (s.toLowerCase().equals("y")){
                    System.out.println("Give Address : ");
                    System.out.println("Street : ");
                    street = scanner.next();
                    System.out.println("City : ");
                    city = scanner.next();
                    System.out.println("State : ");
                    state = scanner.next();
                    System.out.println("Zip : ");
                    zip = scanner.next();
                    newAddress = new Address(street,city,state,zip);
                }
                Parent newParent = new Parent(firstName,lastName,newAddress);
                api.updateParent(oldParent,newParent);
            }
            if (choice == 4){
                break;
            }
            else{
                System.out.println("  ");
            }

        }



    }
}
