
import java.util.List;

public class Adult extends Person {

    public Adult(String name, String image, String status, int age) {
        super(name, image, status, age);
    }

    /*
     * (non-Javadoc)
     * @see Person#print()
     * 
     * This funtion cast is into String and prints info 
     */
    @Override
    public void print() {
        String info = toString();
        System.out.println(info);
    }
    
    /*
     * (non-Javadoc)
     * @see Profile#isAdult()
     * 
     * To check wheather the person is an adult or not. 
     */

    @Override
    public boolean isAdult() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see Profile#isChild()
     * To check wheather the person is an Child or not.
     */
    @Override
    public boolean isChild() {
        return false;
    }
    

    /*
     * (non-Javadoc)
     * @see Profile#isYoungChild()
     * To check wheather the person is an youngerChild or not.
     */
    @Override
    public boolean isYoungChild() {
        return false;
    }

    /*
     * 
     * it Checks for each connections and return true is the profile is already coupled.
     */
    
    public boolean isAlreadyCouple(){
        for(Connection c : getConnections()){
            if(c.type == Connection.Type.SPOUSE)
                return true;
        }
        return false;
    }
    
    @Override
    public List<Profile> getImmediateFriends() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     * 
     * it just cast the profile (Static type) into String.
      */
    
    public String toString() {
        String s = "";
        s += getName() + ", " + getImage() + ", " + getStatus();
        s += ", " + getAge() + ", " + getState() + " ( Adult )";
        return s;
    }
}
