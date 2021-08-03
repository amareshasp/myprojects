package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class StudentPredicate {
    public static Predicate<Student> isCountry(String country){
        return s -> s.getCoutry().equals(country);
    }
   public static Predicate<Student> hasHobby(String hob){

        return s -> s.getHobbies().contains(hob);
   }
}

class Student{
    private int s_id;
    private String coutry;
    private List<String> hobbies ;


    public Student(int s_id, String coutry, List<String> hobbies) {
        this.s_id = s_id;
        this.coutry = coutry;
        this.hobbies = hobbies;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", coutry='" + coutry + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}

class ChatGroup{
    private int c_id;
    private List<Integer> s_id;

    public ChatGroup(int c_id, List<Integer> s_id) {
        this.c_id = c_id;
        this.s_id = s_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public List<Integer> getS_id() {
        return s_id;
    }

    public void setS_id(List<Integer> s_id) {
        this.s_id = s_id;
    }

    @Override
    public String toString() {
        return "ChatGroup{" +
                "c_id=" + c_id +
                ", s_id=" + s_id +
                '}';
    }
}

public class Problem1 {


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<ChatGroup> chatGroups = new ArrayList<>();

        students.add(new Student(1,"UK", Arrays.asList("Photography","Painting")));
        students.add(new Student(2,"India", Arrays.asList("Reading","Painting")));
        students.add(new Student(3,"France", Arrays.asList("Gardening","Music")));
        students.add(new Student(4,"Greece", Arrays.asList("Music","Painting")));

        chatGroups.add(new ChatGroup(1,Arrays.asList(1,2,3)));
        chatGroups.add(new ChatGroup(2,Arrays.asList(1,4)));
        chatGroups.add(new ChatGroup(3,Arrays.asList(2,4)));


        List<Student> sl = students.stream().filter(s -> s.getCoutry().equals("France")).collect(Collectors.toList());
        System.out.println(sl);
        List<Student> sl2 = students.stream().filter(StudentPredicate.hasHobby("Music")).collect(Collectors.toList());
        System.out.println(sl2);


    }
}
