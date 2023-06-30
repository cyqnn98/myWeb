package com.yqcui.yqweb.service.ServiceImpl;

import com.yqcui.yqweb.entity.User;
import com.yqcui.yqweb.repository.UserRepository;
import com.yqcui.yqweb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())
                || userRepository.existsByPhoneNum(user.getPhoneNum())){
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public boolean existsUser(User user) {
        return userRepository.existsByEmail(user.getEmail()) || userRepository.existsByPhoneNum(user.getPhoneNum());
    }

    @Override
    public boolean passwordMatched(User user) {
        User userInDatabase = userRepository.getUserByEmail(user.getEmail());
        return userInDatabase.getPassword().equals(user.getPassword());
    }
}