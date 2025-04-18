package Classes;

public class Teacher implements Faculty {
    private String name;

    void Teacher(String name) {
        this.name = name;
        System.out.print("This is a Teacher");
    }
}
