package learn.data;

import org.springframework.data.repository.CrudRepository;

import learn.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
