package com.joonseolee.springsecuritytutorial.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account_roles")
@IdClass(AccountRoleId.class)
public class AccountRole {
    @Id
    @Column(name = "account_id")
    private long accountId;
    @Id
    @Column(name = "role_id")
    private long roleId;
}
