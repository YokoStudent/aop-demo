package pers.yoko.aopdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.yoko.aopdemo.entity.User;

/**
 * @author yoko
 * @date 2021/9/1 10:52
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
