package com.airbus.alten.cacau.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.airbus.alten.cacau.model.UserParameter;

@Transactional
public interface TemporaryListDAO extends JpaRepository<UserParameter, Long>{

	@Query(value="select * from temporary_list t where t.username = (:pUser)",nativeQuery=true)

	public List<UserParameter> findByUser(@Param("pUser") String pUser);

    @Modifying
    @Transactional
    public void deleteUserParameterByParameterId(int parameterId);

	public UserParameter findByParameterId(int parameterID);
	
	
}
