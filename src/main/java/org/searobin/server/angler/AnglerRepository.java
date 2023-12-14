package org.searobin.server.angler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnglerRepository extends JpaRepository<Angler, UUID> {
}
