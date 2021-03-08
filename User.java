package quickquizfx;

/**
 *
 * @author Mosiur Rahman Sweet
 */
public class User {
    public static int ID;
    public static String name;
    public static double score=0;

    public User() {
    }
    
    public User(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    
}
