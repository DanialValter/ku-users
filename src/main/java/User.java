import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String userName;
    private String password;
    private int age;
    private LocalDateTime insertedAtUtc;

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", userName='" + userName + '\'' +
               ", password='" + password + '\'' +
               ", age=" + age +
               ", insertedAtUtc=" + insertedAtUtc +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(insertedAtUtc, user.insertedAtUtc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, userName, password, age, insertedAtUtc);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getInsertedAtUtc() {
        return insertedAtUtc;
    }

    public void setInsertedAtUtc(LocalDateTime insertedAtUtc) {
        this.insertedAtUtc = insertedAtUtc;
    }
}
