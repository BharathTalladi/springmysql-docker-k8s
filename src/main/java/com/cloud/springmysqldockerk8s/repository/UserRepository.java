package com.cloud.springmysqldockerk8s.repository;

import com.cloud.springmysqldockerk8s.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
