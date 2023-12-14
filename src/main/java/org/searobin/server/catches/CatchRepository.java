package org.searobin.server.catches;

import org.searobin.server.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CatchRepository extends JpaRepository<Catch, UUID> {
}
