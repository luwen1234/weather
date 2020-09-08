package com.weather.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter @Setter
public class BaseEntity<ID> implements Serializable {

    @Id
    @Column(name = "id")
    @NotNull(message = "id不能为空！")
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.IdentityGenerator")
    private ID id;

    @Column(name = "create_on")
    private Date createOn;

    @Column(name = "create_by")
    private Long createBy;

    @Column(name = "modify_on")
    private Date modifyOn;

    @Column(name = "modify_by")
    private Long modifyBy;

    public interface Save extends Default {

    }

    public interface Update extends Default{

    }
}
