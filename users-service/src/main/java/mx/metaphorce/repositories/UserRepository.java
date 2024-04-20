
package mx.metaphorce.repositories;

import mx.metaphorce.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
	@Query("select u from User u where u.username = ?1")
	User findByUsernameSQL(String username);
}
