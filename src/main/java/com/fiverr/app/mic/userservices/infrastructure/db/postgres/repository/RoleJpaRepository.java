package com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository;

import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {
}
