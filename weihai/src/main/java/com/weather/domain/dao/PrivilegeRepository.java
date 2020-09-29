package com.weather.domain.dao;

import com.weather.domain.entity.Privilege;
import com.weather.domain.entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    @Query(value = "select * from wh_privilege t where if(:name is not null && :name != '', t.name like %:name%, 1=1)",
            countQuery = "select count(1) from wh_resource t where if(:name is not null && :name != '', t.name like %:name%, 1=1)",
            nativeQuery = true)
    Page<Privilege> findByName(@Param(value = "name") String name, Pageable pageable);

    @Query(value = "select * from wh_privilege t where if(:name is not null && :name != '', t.name like %:name%, 1=1)",
            nativeQuery = true)
    List<Privilege> findByName(@Param(value = "name") String name);
}
