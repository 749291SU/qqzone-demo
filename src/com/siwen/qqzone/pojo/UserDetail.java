package com.siwen.qqzone.pojo;

import lombok.*;

import java.sql.Date;

/**
 * @projectName: qqzone
 * @package: com.siwen.qqzone.pojo
 * @className: UserDetail
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 8:40 PM
 * @version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDetail {
    private Integer id;
    private Date birth;
    private String realName, star, tel, email;
}