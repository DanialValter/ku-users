import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    /*public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.findByIdAll();
        for (User user : users) {
            System.out.println(user);
        }*/

    /*public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteById(12L);
    }
    public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        userRepository.updateByID(13L, "probe");*/

    public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setName("Jav 3");
        user.setUserName("Usernamet");
        user.setAge(99);
        user.setPassword("Gавыler");
        user.setInsertedAtUtc(LocalDateTime.now());
        user.setSurname("SSSSSSаыаS");
        userRepository.save(user);


    }
}

    /*public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findById(13L);

        System.out.println(user);

    }*/


