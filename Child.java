
import java.util.List;

public class Child extends Person {

    public Child(String name, String image, String status, int age) {
        super(name, image, status, age);
    }

    @Override
    public boolean isAdult() {
        return false;
    }

    @Override
    public boolean isChild() {
        return true;
    }

    @Override
    public boolean isYoungChild() {
        return false;
    }

    @Override
    public List<Profile> getImmediateFriends() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        s += getName() + ", " + getImage() + ", " + getStatus();
        s += ", " + getAge() + ", " + getState() + " ( Child )";
        return s;
    }

    @Override
    public void print() {
        String info = toString();
        System.out.println(info);
    }

}
