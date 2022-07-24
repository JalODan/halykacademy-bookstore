package kz.halykacademy.bookstore.user;

import kz.halykacademy.bookstore.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("User with ID=" + id + " not found");
        }
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {

        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("User with ID=" + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public void update(User user) {

        if (!userRepository.existsById(user.getId())) {
            throw new IllegalStateException("User with ID=" + user.getId() + " not found");
        }

        userRepository.save(user);
    }
}
