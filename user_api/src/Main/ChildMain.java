package Main;

import Api.ChildApi;
import User.Child;

import java.io.IOException;
import java.util.Scanner;

public class ChildMain {
    public static void main(String[] args) throws IOException {

        ChildApi api = new ChildApi();

        System.out.println("Child : ");
        while (true){
            System.out.println("1.Create 2.Delete 3.Update 4.exit\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1){
                System.out.println("Give first name : ");
                String firstName = scanner.next();
                System.out.println("Give last name : ");
                String lastName = scanner.next();
                Child child = new Child(firstName,lastName);
                api.insertChild(child);
            }else if(choice == 2){
                System.out.println("Give first name : ");
                String firstName = scanner.next();
                System.out.println("Give last name : ");
                String lastName = scanner.next();

                Child child = new Child(firstName,lastName);
                api.deleteChild(child);
            }else if(choice == 3){
                System.out.println("Give first name : ");
                String firstName = scanner.next();
                System.out.println("Give last name : ");
                String lastName = scanner.next();

                Child oldChild = new Child(firstName,lastName);

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

                Child newChild = new Child(firstName,lastName);
                api.updateChild(oldChild,newChild);
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
