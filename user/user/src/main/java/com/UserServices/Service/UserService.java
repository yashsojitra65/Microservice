package com.UserServices.Service;



import com.UserServices.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();
    User getUser(String userId);
}
