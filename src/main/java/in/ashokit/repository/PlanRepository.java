package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
