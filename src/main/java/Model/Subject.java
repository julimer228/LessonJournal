package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class Subject {
    private String name;
    private List<Class> classes;
    public Subject(String name)
    {
        this.classes=new ArrayList<>();
        this.name=name;
    }
    @Override
    public String toString()
    {
        return this.name;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void addClass(Class class_)
    {
        this.classes.add(class_);
    }
}
