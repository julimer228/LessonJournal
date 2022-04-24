package Model;

import Exceptions.SchoolSystemException;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class User {
    private String name;
    private String surname;
    private Sex sex;
    private String login;
    private String password;

    public User(String name, String surname, Sex sex, String password, String login)
    {
        this.name=name;
        this.surname=surname;
        this.sex=sex;
        this.password=password;
        this.login=login;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)throws SchoolSystemException {
        if(password.isEmpty()||password.isBlank()||password.length()<3)
            throw new SchoolSystemException("Hasło powinno mieć więcej niż 2 znaki! \nHasło nie może składać się z samych białych znaków!");
        else
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
