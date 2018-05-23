
public class Connection {

    enum Type {
        PARENT, CHILD, FRIEND, SPOUSE, CLASSMATE, COLLEAGUE
    };

    public Profile p1;
    public Profile p2;
    public Type type;

    public Connection(Profile p11, Profile p22, Type type) {
        this.p1 = p11;
        this.p2 = p22;
        this.type = type;
    }
    
    /*
     * 
     * This class is only for representation. that how to show relations on JPanel in UI
     */

    public static Type getTypeFromString(String s){
        if(s.equals("friends"))
            return Type.FRIEND;
        else if(s.equals("parent"))
            return Type.PARENT;
        else if(s.equals("colleagues"))
            return Type.COLLEAGUE;
        else if(s.equals("couple"))
            return Type.SPOUSE;
        else
            return Type.CLASSMATE;
    }
    
    public String toString() {
        String s = "";
        switch (type) {
            case FRIEND:
                s = p1.getName() + " connected to " + p2.getName() + " as friend";
                break;
            case PARENT:
                s = p1.getName() + " connected to " + p2.getName() + " as parent";
                break;
            case SPOUSE:
                s = p1.getName() + " connected to " + p2.getName() + " as spouse";
                break;
            case CHILD:
                s = p1.getName() + " connected to " + p2.getName() + " as child";
                break;
            case CLASSMATE:
                s = p1.getName() + " connected to " + p2.getName() + " as classmates";
                break;
            case COLLEAGUE:
                s = p1.getName() + " connected to " + p2.getName() + " as colleagues";
                break;
        }
        return s;
    }
}
