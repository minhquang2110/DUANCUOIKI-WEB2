package ntu.edu.nhom13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntu.edu.nhom13.entity.Admin;
import ntu.edu.nhom13.entity.Scientist;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT s FROM Admin s WHERE s.account.id = :accountId")
    Admin findaAdminByAccountId(@Param("accountId") Integer accountId);
}
