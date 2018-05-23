
import java.util.List;

public class YoungChild extends Person {
	
	
	/*
	 * Same Comments as Adults has
	 */

    public YoungChild(String name, String image, String status, int age) {
        super(name, image, status, age);
    }

    @Override
    public boolean isAdult() {
        return false;
    }

    @Override
    public boolean isChild() {
        return false;
    }

    @Override
    public boolean isYoungChild() {
        return true;
    }
    
    @Override
    public List<Profile> getImmediateFriends() throws TooYoungException {
        throw new TooYoungException("Profile named " + getName() + " is too young to have a friend");
    }

    @Override
    public String toString() {
        String s = "";
        s += getName() + ", " + getImage() + ", " + getStatus();
        s += ", " + getAge() + ", " + getState() + " ( Young Child )";
        return s;
    }
    
    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

}
