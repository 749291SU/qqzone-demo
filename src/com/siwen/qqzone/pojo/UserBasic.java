package com.siwen.qqzone.pojo;

import lombok.*;

import java.util.List;

/**
 * @projectName: qqzone
 * @package: com.siwen.qqzone.pojo
 * @className: UserBasic
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
public class UserBasic {
    private Integer id;
    private String loginId, pwd, nickName, headImg;
    private UserDetail userDetail;
    private List<Topic> topicList;
    private List<UserBasic> friendList;

    // prepared for map the id of author to UserBasic instance
    public UserBasic(Integer author) {
        this.id = author;
    }
}