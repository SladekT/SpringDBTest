package org.example.springdb.DAO;
import org.aspectj.weaver.ast.Or;

import org.example.springdb.Model.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LoginRepository extends JpaRepository<CustomerLogin, Long> {
    @SuppressWarnings("NullableProblems")
    CustomerLogin save(CustomerLogin customerLogin);

    List<CustomerLogin> findAll();

  CustomerLogin searchAllByLoginId(Long login_id);

    Integer deleteAllByLoginId(@Param("id") Long id);
}
