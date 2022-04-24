package Model;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class Grade {
    private int value;
    private Subject subject;
    private Teacher teacher;
    private Student student;
    private Class class_;

    public Grade(int value, Subject subject, Teacher teacher, Student student, Class class_)
    {
        this.value=value;
        this.subject=subject;
        this.teacher=teacher;
        this.student=student;
        this.class_=class_;
    }

    public int getValue() {
        return value;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setStudent(Student student)
    {
        this.student=student;
    }

    public Student getStudent()
    {
        return student;
    }

    public Class getClass_()
    {
        return class_;
    }

}
