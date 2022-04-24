package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class Teacher extends User{
    private List<Subject> subjects;
    private Class aClass;



    public Teacher(String name, String surname, Sex sex, String password, String login) {
        super(name, surname, sex, password, login);
        subjects=new ArrayList<>();
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


    public List<Subject> getSubjects() {
        return subjects;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }




    @Override
    public String toString()
    {
        return this.getName()+" "+this.getSurname();
    }
}
