package Domain;


/**
 * Created by emmabaddeley on 14/04/2016.
 */
public class User {


    private final String name;
    private final String handle;


    public User(String name, String handle) {
        this.name = name;
        this.handle = handle;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return handle != null ? handle.equals(user.handle) : user.handle == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (handle != null ? handle.hashCode() : 0);
        return result;
    }
}