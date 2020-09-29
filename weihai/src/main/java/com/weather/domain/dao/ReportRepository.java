package com.weather.domain.dao;

import com.weather.domain.entity.Btn;
import com.weather.domain.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select * from WH_REPORT t where 1 = 1 " +
            " and if(:reportTypeId is not null, t.report_type_id = :reportTypeId, 1=1)" +
            " and ( if(:reportStartDate is not null, t.report_date >= :reportStartDate, 1=1) and if(:reportEndDate is not null, t.report_date <= :reportEndDate, 1=1))" +
            " and if(:reportContext is not null && :reportContext != '', t.report_context like %:reportContext%, 1=1)" +
            " and if(:reportId is not null, t.create_by = :reportId, 1=1)" +
            " and t.activity = 1",
            countQuery = "select count(1) from WH_REPORT t where 1 = 1 " +
                    " and if(:reportTypeId is not null, t.report_type_id = :reportTypeId, 1=1)" +
                    " and ( if(:reportStartDate is not null, t.report_date >= :reportStartDate, 1=1) and if(:reportEndDate is not null, t.report_date <= :reportEndDate, 1=1))" +
                    " and if(:reportContext is not null && :reportContext != '', t.report_context like %:reportContext%, 1=1)" +
                    " and if(:reportId is not null, t.create_by = :reportId, 1=1)" +
                    " and t.activity = 1",
            nativeQuery = true)
    Page<Report> pageQuery(@Param(value = "reportTypeId") Long reportTypeId,
                            @Param(value = "reportStartDate") Date reportStartDate,
                            @Param(value = "reportEndDate") Date reportEndDate,
                            @Param(value = "reportContext") String reportContext,
                            @Param(value = "reportId") Long reportId,
                            Pageable pageable);

    @Query(value = "select * from WH_REPORT t where 1 = 1 " +
            " and if(:reportTypeId is not null, t.report_type_id = :reportTypeId, 1=1)" +
            " and ( if(:reportStartDate is not null, t.report_date >= :reportStartDate, 1=1) and if(:reportEndDate is not null, t.report_date <= :reportEndDate, 1=1))" +
            " and if(:reportContext is not null && :reportContext != '', t.report_context like %:reportContext%, 1=1)" +
            " and if(:reportId is not null, t.create_by = :reportId, 1=1)" +
            " and t.activity = 1",
            nativeQuery = true)
    List<Report> listQuery(@Param(value = "reportTypeId") Long reportTypeId,
                           @Param(value = "reportStartDate") Date reportStartDate,
                           @Param(value = "reportEndDate") Date reportEndDate,
                           @Param(value = "reportContext") String reportContext,
                           @Param(value = "reportId") Long reportId);

    @Query(value = "select * from WH_REPORT t where t.id in(:ids) and t.activity = 1", nativeQuery = true)
    List<Report> findByIds(@Param(value = "ids") List<Long> ids);
}
