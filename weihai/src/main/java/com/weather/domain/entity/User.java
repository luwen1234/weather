package com.weather.domain.entity;

import com.weather.domain.model.AccountType;
import com.weather.domain.model.ActivityType;
import com.weather.domain.model.GenderType;
import com.weather.domain.model.PayType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "WH_USER")
@Getter @Setter
public class User extends BaseEntity<Long>{

    @ApiModelProperty("用户姓名")
    @Column(name = "name", length = 100)
    private String name;

    @ApiModelProperty("性别 1男，2女")
    @Column(name = "gender")
    @Enumerated
    private GenderType gender;

    @ApiModelProperty("用户账号")
    @Column(name = "account", length = 100)
    @NotNull(message = "用户账号不能为空！")
    private String account;

    @ApiModelProperty("用户密码")
    @Column(name = "password", length = 20)
    @NotNull(message = "用户密码不能为空！")
    private String password;

    @ApiModelProperty("地址")
    @Column(name = "address", length = 500)
    private String address;

    @ApiModelProperty("用户单位ID")
    @Column(name = "organization_id")
    private Long organizationId;

    @ApiModelProperty("用户座机号码")
    @Column(name = "telephone", length = 20)
    private String telephone;

    @ApiModelProperty("用户手机号码")
    @Column(name = "mobile", length = 20)
    private String mobile;

    @ApiModelProperty("用户邮箱")
    @Column(name = "email", length = 20)
    private String email;

    @ApiModelProperty("用户账号类型:普通用户，管理员,超级管理员")
    @Column(name = "account_type", length = 10)
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @ApiModelProperty("用户账号注册时间")
    @Column(name = "register_on")
    private Date registerOn;

    @ApiModelProperty("用户最近登录时间")
    @Column(name = "login_latest_on")
    private Date loginLatestOn;

    @ApiModelProperty("用户登录次数")
    @Column(name = "login_count")
    private Integer loginCount;

    @ApiModelProperty("用户常用登录IP")
    @Column(name = "login_ip", length = 30)
    private String loginIP;

    @ApiModelProperty("用户账号状态:1已缴费0未交费")
    @Column(name = "status", length = 10)
    @NotNull(message = "用户账号状态不能为空！")
    @Enumerated(value = EnumType.STRING)
    private PayType status;

    @ApiModelProperty("用户角色id")
    @Column(name = "role_id")
    private Long roleId;

    @ApiModelProperty("数据状态1正常0作废")
    @Column(name = "activity")
    @Enumerated
    private ActivityType activity;

    public User(){
        this.gender = GenderType.MALE;
        this.accountType = AccountType.COMMON;
        this.activity = ActivityType.LIVING;
        this.status = PayType.PAY;
    }

    public void createBy(Long crateBy){
        this.setCreateBy(crateBy);
        this.setCreateOn(new Date());
    }

    public void modifyBy(Long modifyBy){
        this.setModifyBy(modifyBy);
        this.setModifyOn(new Date());
    }
}
