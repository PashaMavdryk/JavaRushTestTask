package repository.custom;

import java.util.List;

import model.User;

public interface UserRepositoryCustom {

    List<User> findByName(String name);

}