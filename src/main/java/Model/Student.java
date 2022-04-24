package Model;

import Exceptions.SchoolSystemException;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class Student extends User{
    private List<Grade> grades;
    public Student(String name, String surname, Sex sex, String password, String login) {
        super(name, surname, sex, password, login);
        grades=new ArrayList<>();
    }

    public void addGrade(Subject subject, int value, Teacher teacher, Class class_) throws SchoolSystemException
    {

        switch (value)
        {
            case 1,2,3,4,5,6:
                Grade grade=new Grade(value, subject, teacher, this, class_);
                break;
            default: throw new SchoolSystemException("The value of the grade is invalid!");
        }
        this.grades.add(new Grade(value, subject, teacher, this, class_));
    }

    public List<Grade> getGrades() {
        return grades;
    }

    @Override
    public String toString()
    {
        return this.getName()+" "+this.getSurname()+" ("+this.getLogin()+")";
    }

    public void addGrade(Grade grade)
    {
        this.grades.add(grade);
    }

}
