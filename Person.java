
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Profile {

    private String name;
    private String image;
    private String status;
    private int age;
    private String state;
    
    private List<Connection> connections; // list of connection with the type of 'connection'
    
    
    /*
     * setter constructor of Person Class
     */

    public Person(String name, String image, String status, int age) {
        this.name = name;
        this.image = image;
        this.status = status;
        this.age = age;
        connections = new ArrayList<Connection>();
    }

    
    /*
     * populates the connection List with connections.
     */
    public void addConnection(Person withWhom, Connection.Type type) {
        Connection c = new Connection(this, withWhom, type);
        connections.add(c);
    }
    
    /*
     * capabled of removing selected connection from the List
     */

    public void removeConnection(Person withWhom) {
        int index = -1;
        for (int i = 0; i < connections.size(); i++) {
            Connection c = connections.get(i);
            if (c.p2.equals(withWhom)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            connections.remove(index);
        }
    }

    
    // __________ THESE ARE GETTER & SETTER FUNCTIONS ___________________
    
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public List<Connection> getConnections() {
        return connections;
    }

    @Override
    public Connection getConnectionWith(Profile p){
        for(Connection c : getConnections()){
            if(c.p2.equals(p))
                return c;
        }
        return null;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    /*
     * (non-Javadoc)
     * @see Profile#removeProfile(Profile)
     * used to remove selected profile from connection list
     */
    
    @Override
    public void removeProfile(Profile profile) {
        int index = -1;
        for (int i = 0; i < connections.size(); i++) {
            Connection c = connections.get(i);
            if (c.p2.equals(profile)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            connections.remove(index);
        }
    }

    @Override
    public Profile[] getParents() throws NoParentException {
        List<Profile> parents = new ArrayList<Profile>();

        for (Connection c : getConnections()) {
            if (c.type == Connection.Type.CHILD) {
                parents.add(c.p2);
            }
        }
        if(parents.isEmpty() || parents.size() == 1)
            throw new NoParentException("profile named '" + name + "' has only one or no parent");
        
        return (Profile[]) parents.toArray(new Profile[parents.size()]);
    }

    @Override
    public Profile[] getChildren() {
        List<Profile> children = new ArrayList<Profile>();

        for (Connection c : getConnections()) {
            if (c.type == Connection.Type.PARENT) {
                children.add(c.p2);
            }
        }

        return (Profile[]) children.toArray(new Profile[children.size()]);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        return name.equals(((Person) obj).name);
    }

    public abstract void print();

}
