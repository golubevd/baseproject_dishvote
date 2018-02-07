package baseproject.dishvote.service;


import baseproject.dishvote.Util.exception.NotFoundException;
import baseproject.dishvote.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void evictCache();

    List<User> getAll();

    User getWithMeals(int id);

}
