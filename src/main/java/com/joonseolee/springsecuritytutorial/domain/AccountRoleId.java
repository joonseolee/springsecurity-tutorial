package com.joonseolee.springsecuritytutorial.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountRoleId implements Serializable {

    private long accountId;
    private long roleId;
}
