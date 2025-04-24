package _Classes;

public class Main {
    public static void main(String[] args) {
        HeadMaster hm = new HeadMaster();
        Faculty helper = new Helper();
        Faculty assistant = new Assistant();

        hm.addFaculty(assistant);
        System.out.println(helper.getClass());
        System.out.println(assistant.getClass());
        System.out.println(hm.faculty.getClass());
    }
}
