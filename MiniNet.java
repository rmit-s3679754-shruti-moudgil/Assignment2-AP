
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MiniNet {

    private HashMap<String, Profile> network;

    public MiniNet() {
        network = new HashMap<String, Profile>();
    }

    public void addProfile(Profile p) throws NoSuchAgeException {
        if (p.getAge() < 0 || p.getAge() > 150) {
            throw new NoSuchAgeException(p.getAge() + " is outside the range. Must be > 0 and < 150");
        }
        network.put(p.getName(), p);
//        sqlLiteDatabase database = new sqlLiteDatabase();
//        database.insert(p.getName(), p.getAge())
    }

    public Profile getProfile(String name) {
        if (network.containsKey(name)) {
            return network.get(name);
        } else {
            return null;
        }
    }

    public Connection getConnectionBetween(Profile prof1, Profile prof2){
        return prof1.getConnectionWith(prof2);
    }
    
    /*
     * addConnection check for exception and if not occur then it make a connection between two profiles.
     */
    
    public void addConnection(Profile prof1, Profile prof2, Connection.Type type) throws Exception {
        Person p1 = (Person) prof1;
        Person p2 = (Person) prof2;
        if (p1==p2){
        		throw new Exception("Can't make connection with themselves");
        	}
        if(type == Connection.Type.PARENT && !prof1.isAdult() ){
            throw new TooYoungException("A child or young child cannot be a parent");
        }
        if(type == Connection.Type.FRIEND && (prof1.isYoungChild() || prof2.isYoungChild()))
            throw new TooYoungException("Young Child cannot have a friend");
        
        if(type == Connection.Type.FRIEND && 
                ((prof1.isYoungChild() && prof2.isAdult()) 
                || (prof2.isYoungChild() && prof1.isAdult())))
            throw new TooYoungException("An adult and a young child cannot be friends");
        
        if(type == Connection.Type.FRIEND && 
                ((prof1.isYoungChild() && prof2.isChild()) 
                || (prof2.isYoungChild() && prof1.isChild())))
            throw new TooYoungException("An adult and a young child cannot be friends");
        
        if(type == Connection.Type.SPOUSE && (!p1.isAdult() || !p2.isAdult())){
            throw new NotToBeCoupledException("Only two adults can be couple");
        }
        if(type == Connection.Type.SPOUSE && p1.isAdult() && p2.isAdult()){
            Adult a1 = (Adult)p1;
            Adult a2 = (Adult)p2;
            if(a1.isAlreadyCouple())
                throw new NoAvailableException("Profile named " + a1.getName() + " is already a couple");
            if(a2.isAlreadyCouple())
                throw new NoAvailableException("Profile named " + a2.getName() + " is already a couple");
        }
        if(type == Connection.Type.COLLEAGUE && (p1.isChild() && !p2.isChild())){
            throw new NotToBeColleaguesException("A child cannot have a collegues relation");
        }
        if(type == Connection.Type.CLASSMATE && (p1.isYoungChild() && !p2.isYoungChild())){
            throw new NotToBeClassmatesException("A young child cannot have a classmates relation");
        }
        if(type== Connection.Type.FRIEND && p1.isAdult() && !p2.isAdult())
        {
        		throw new NotToBeFriendsException("An adult cannot be friend with a child");
        }
        if(type== Connection.Type.FRIEND && p1.isChild() && p2.isChild() && Math.abs(p1.getAge()-p2.getAge())>3)
        {
        		throw new NotToBeFriendsException("Cannot form friends between children with more than 3 years of age gap");
        }
        
        switch (type) {
            case FRIEND:
                p1.addConnection(p2, type);
                p2.addConnection(p1, type);
                break;
            case PARENT:
                p1.addConnection(p2, type);
                p2.addConnection(p1, Connection.Type.CHILD);
                break;
            case SPOUSE:
                p1.addConnection(p2, type);
                p2.addConnection(p1, type);
                break;
            case CHILD:
                p1.addConnection(p2, type);
                p2.addConnection(p1, Connection.Type.PARENT);
                break;
            case CLASSMATE:
                p1.addConnection(p2, type);
                p2.addConnection(p1, type);
                break;
            case COLLEAGUE:
                p1.addConnection(p2, type);
                p2.addConnection(p1, type);
                break;   
            default:
                break;
        }
    }

    public void removeProfile(Profile p) throws NoParentException {
        if(p.isAdult() && p.getChildren().length != 0){
            throw new NoParentException("Cannot remove a parent with at least one child");
        }
        for (String name : network.keySet()) {
            if (!p.getName().equals(name)) {
                Profile otherProfile = network.get(name);
                otherProfile.removeProfile(p);
            }
        }
        network.remove(p.getName());
    }

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<Profile>();
        for(String name : network.keySet()){
            Profile p = network.get(name);
            profiles.add(p);
        }
        return profiles;
    }

    public List<Connection> getAllConnections(){
        List<Connection> connections = new ArrayList<Connection>();
        for(String name : network.keySet()){
            Profile p = network.get(name);
            connections.addAll(p.getConnections());
        }
        return connections;
    }
    
    public void printAllProfiles() {
        for (String name : network.keySet()) {
            Profile p = network.get(name);
            System.out.println(p.toString());
        }
    }

    public void printAllConnections() {
        for (String name : network.keySet()) {
            Profile p = network.get(name);
            for (Connection c : p.getConnections()) {
                System.out.println(c.toString());
            }
        }
    }

}
