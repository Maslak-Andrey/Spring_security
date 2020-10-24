package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User readUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }
}
