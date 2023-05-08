package org.zed.zed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zed.zed.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
