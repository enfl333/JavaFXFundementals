package flores.javafx.recap.sessions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestFile {

    public TestFile(){

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("recapInfo").getFile());
        StringBuffer buffer = null;
        boolean exists = file.exists();
        if(exists){
            buffer = new StringBuffer();
            System.out.println("Found!");

            try {

                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    buffer.append(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }else{
            System.out.println("Nothing");
        }
    }

    public static void main(String[] args) {
        new TestFile();
    }


}
