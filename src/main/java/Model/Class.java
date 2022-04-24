package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class Class {
    private List <Student> students;
    private String name;
    public Class(String name)
    {
        this.name=name;
        this.students=new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
