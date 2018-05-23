import java.util.List;



/*
 * 
 * The interface defined to hold the prototype of the methods/Functions
 */

public interface Profile {
	
	public String getName();
	public int getAge();
	public boolean isAdult();
	public boolean isChild();
	public boolean isYoungChild();
	public List<Connection> getConnections();
	public void removeProfile(Profile profile);
	public Profile[] getParents() throws NoParentException;
	public Profile[] getChildren();
        public Connection getConnectionWith(Profile profile);
	public List<Profile> getImmediateFriends() throws TooYoungException;
	public void print();
}
