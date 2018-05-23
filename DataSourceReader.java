
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSourceReader {

    public void readMiniNetFromFile(MiniNet miniNet, String peopleFilename, String relationsFilename){
        readProfiles(miniNet, peopleFilename);
        readRelations(miniNet, relationsFilename);
    }
    
    private void readProfiles(MiniNet miniNet, String peopleFilename){
        try {
            File f = new File(peopleFilename);
            Scanner fileScanner = new Scanner(f);
            String line;
            
            while(fileScanner.hasNextLine()){
                line = fileScanner.nextLine();
                String[] data = line.split(",");
                String name = data[0].trim();
                String image = data[1].trim();
                String status = data[2].trim();
                String gender = data[3].trim();
                int age = Integer.parseInt(data[4].trim());
                String state = data[5];
                Profile p = null;
                if(age > 16)
                    p = new Adult(name, image, status, age);
                else if(age > 2)
                    p = new Child(name, image, status, age);
                else
                    p = new YoungChild(name, image, status, age);
                ((Person)p).setState(state);
                try {
                    miniNet.addProfile(p);
                } catch (NoSuchAgeException ex) {
                }
            }
            fileScanner.close();
            System.out.println("Profiles loaded from file " + peopleFilename);
        } catch (FileNotFoundException ex) {
            System.out.println("file " + peopleFilename + " not found. Profiles not loaded.");
        }
    }
    
    private  void readRelations(MiniNet miniNet, String relationsFilename){
        try {
            File f = new File(relationsFilename);
            Scanner fileScanner = new Scanner(f);
            String line;
            
            while(fileScanner.hasNextLine()){
                line = fileScanner.nextLine();
                String[] data = line.split(",");
                String name1 = data[0].trim();
                String name2 = data[1].trim();
                String relation = data[2].trim();
                Profile profile1 = miniNet.getProfile(name1);
                Profile profile2 = miniNet.getProfile(name2);
                Connection.Type type = Connection.getTypeFromString(relation);
                miniNet.addConnection(profile1, profile2, type);
            }
            fileScanner.close();
            System.out.println("Relations loaded from file " + relationsFilename);
        } catch (FileNotFoundException ex) {
            System.out.println("file " + relationsFilename + " not found. Relations not loaded.");
        } catch(Exception ex){
            
        }
    }
	
}
