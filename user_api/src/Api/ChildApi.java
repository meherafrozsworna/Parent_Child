package Api;

import User.Child;

import java.io.*;

public class ChildApi {

    public boolean insertChild(Child child) throws IOException {
        //check existence of child
        if(childExist(child)){
            System.out.println("child already exist");
            return false;
        }

        FileWriter fw = new FileWriter("files/child_data.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw) ;
        System.out.println(child.toString());
        out.println(child.toString());
        out.flush();
        out.close();
        return true ;
    }

    public boolean deleteChild(Child child) throws IOException {
        File inputFile = new File("files/child_data.txt");
        File tempFile = new File("files/myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = child.toString();
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine +"\n");
            writer.flush();
        }
        writer.close();
        reader.close();

        System.out.println("file deleted : "+inputFile.delete());
        boolean successful = tempFile.renameTo(inputFile);
        return successful;
    }

    public boolean updateChild(Child oldChild, Child newChild) throws IOException {
        //check if updated child already exist in file , if exist then reture false
        if (childExist(newChild)){
            System.out.println("cannot update child, new child already exist");
            return false;
        }

        File inputFile = new File("files/child_data.txt");
        File tempFile = new File("files/myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        String lineToRemove = oldChild.toString();

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)){
                writer.write(newChild.toString() +"\n");
                continue;
            }
            writer.write(currentLine +"\n");
            writer.flush();
        }
        writer.close();
        reader.close();

        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
        return successful;
    }

    public boolean childExist(Child child) throws IOException {
        File inputFile = new File("files/child_data.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String currentLine;
        String newLine = child.toString();

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(newLine)){
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }

}
