package com.codewithkaif.usersignupsignin.reposiotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithkaif.usersignupsignin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserNameAndPassword(String userName, String password);

	Optional<User> findByUserName(String userName);
}
