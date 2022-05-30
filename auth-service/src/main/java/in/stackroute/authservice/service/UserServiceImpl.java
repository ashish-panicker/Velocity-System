package in.stackroute.authservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.authservice.domain.User;
import in.stackroute.authservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> getUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Optional<User> getUserByUserNameAndPassword(String username, String password) {
        return userRepository.findByUserNameAndPassword(username, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
