package Model;

import Exceptions.SchoolSystemException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class School {
    private List<User> users;
    private List<Subject> subjects;
    private List<Class> classes;
    private List<Grade>grades;

    public School() {
        users = new ArrayList<>();
        subjects = new ArrayList<>();
        classes = new ArrayList<>();
        grades=new ArrayList<>();
    }

    public void createSampleSchool() {
        //Create some subjects
        subjects.add(new Subject("Matematyka"));
        subjects.add(new Subject("Biologia"));
        subjects.add(new Subject("Chemia"));
        subjects.add(new Subject("Angielski"));
        subjects.add(new Subject("Wychowanie fizyczne"));
        subjects.add(new Subject("Fizyka"));

        //Create some teachers
        Teacher teacher1 = new Teacher("Agnieszka", "Kowalska", Sex.WOMEN, "abcd123", "agnkowal123");
        teacher1.getSubjects().add(subjects.get(0)); //Matematyka
        teacher1.getSubjects().add(subjects.get(5));
        users.add(teacher1);

        Teacher teacher2 = new Teacher("Andrzej", "Zielony", Sex.MEN, "abcd123", "andrzziel456");
        teacher2.getSubjects().add(subjects.get(5)); //Fizyka
        users.add(teacher2);

        Teacher teacher3 = new Teacher("Karol", "Lekki", Sex.MEN, "abcd123", "karlekki789");
        teacher3.getSubjects().add(subjects.get(2)); //Chemia
        users.add(teacher3);

        Teacher teacher4 = new Teacher("Maryla", "Cisza", Sex.WOMEN, "abcd123", "marcisza101112");
        teacher4.getSubjects().add(subjects.get(3)); //Angielski
        users.add(teacher4);


        //Create class
        Class class_ = new Class("3C");
        Class class_2=new Class("2A");
       // subjects.get(0).addClass(class_);
       // subjects.get(0).addClass(class_2);
       // subjects.get(1).addClass(class_);
       // subjects.get(1).addClass(class_2);

        //Create some students
        Student student1 = new Student("Anna", "Nowak", Sex.WOMEN, "abcd123", "annnowa131415");
        users.add(student1);
        class_.getStudents().add(student1);
        Student student2 = new Student("Hanna", "Nowak", Sex.WOMEN, "abcd123", "hannnowa123");
        users.add(student2);
        class_.getStudents().add(student2);
        Student student3 = new Student("Karol", "Korczyk", Sex.MEN, "abcd123", "karolkor1315");
        users.add(student3);
        class_.getStudents().add(student3);
        Student student4 = new Student("Maria", "Zaradny", Sex.WOMEN, "abcd123", "mariazra456");
        users.add(student4);
        class_.getStudents().add(student4);
        Student student5 = new Student("Adam", "Lisek", Sex.MEN, "abcd123", "adamlis234");
        users.add(student5);
        class_2.getStudents().add(student5);
        Student student6 = new Student("Lidia", "Wodny", Sex.WOMEN, "abcd123", "lidwodny244");
        users.add(student6);
        class_2.getStudents().add(student6);
        Student student7 = new Student("Dariusz", "Adamczyk", Sex.MEN, "abcd123", "daradam245");
        users.add(student7);
        class_2.getStudents().add(student7);
        Student student8 = new Student("Tomasz", "Niebieski", Sex.MEN, "abcd123", "tomnie123");
        users.add(student8);
        class_2.getStudents().add(student8);
        classes.add(class_);
        classes.add(class_2);



    }

    public User loginUser(String login, String password) throws SchoolSystemException {
        for (User user :
                users) {

            if (login.equals(user.getLogin())) {
                if (password.equals(user.getPassword())) {
                    return user;
                } else throw new SchoolSystemException("Niepoprawne hasło!");
            }
        }
        throw new SchoolSystemException("Nie odnaleziono użytkownika o takim loginie!");
    }



    public String getStudentsClass(Student student) throws SchoolSystemException
    {
        String classString="";
        for (Class c:classes
             ) {

            for (Student s: c.getStudents()
                 ) {
                if(s.getLogin().equals(student.getLogin()))
                {
                    return c.toString();
                }
            }
        }
        throw new SchoolSystemException("Nie odnaleziono studenta!");
    }
    public List<Class> getClasses()
    {
        return classes;
    }


    public void addGrade(Grade g, Class c)
    {
        for (Student ss:c.getStudents()
             ) {
            if(g.getStudent().getLogin().equals(ss.getLogin()))
            {
                ss.addGrade(g);
                this.grades.add(g);
            }
        }
    }

    public List<Grade> getGrades()
    {
        return grades;
    }

    public void setGrades(List<Grade> grades)
    {
        this.grades=grades;
    }

    public List<Grade> returnGradesByTeacher(Teacher teacher)
    {
        List<Grade> teacherGrades=new ArrayList<>();

        for (Grade g:grades
             ) {

            if(teacher.getLogin().equals(g.getTeacher().getLogin()))
            {
                teacherGrades.add(g);
            }
        }

        return teacherGrades;

    }


}