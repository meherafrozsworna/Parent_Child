package Api;

import User.Parent;

import java.io.*;

public class ParentApi {

    public boolean insertParent(Parent parent) throws IOException {
        //check existence of parent
        if(parentExist(parent)){
            System.out.println("parent already exist");
            return false;
        }

        FileWriter fw = new FileWriter("files/parent_data.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw) ;
        System.out.println(parent.toString());
        out.println(parent.toString());
        out.flush();
        out.close();
        return true ;
    }

    public boolean deleteParent(Parent parent) throws IOException {
        File inputFile = new File("files/parent_data.txt");
        File tempFile = new File("files/myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = parent.toString();
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

    public boolean updateParent(Parent oldParent, Parent newParent) throws IOException {
        //check if updated parent already exist in file , if exist then reture false
        if (parentExist(newParent)){
            System.out.println("cannot update parent, new parent already exist");
            return false;
        }

        File inputFile = new File("files/parent_data.txt");
        File tempFile = new File("files/myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        String lineToRemove = oldParent.toString();

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)){
                writer.write(newParent.toString() +"\n");
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

    public boolean parentExist(Parent parent) throws IOException {
        File inputFile = new File("files/parent_data.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String currentLine;
        String newLine = parent.toString();

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
