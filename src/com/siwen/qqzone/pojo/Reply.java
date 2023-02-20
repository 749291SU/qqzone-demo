package com.siwen.qqzone.pojo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @projectName: qqzone
 * @package: com.siwen.qqzone.pojo
 * @className: reply
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 8:48 PM
 * @version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
    private Integer id;
    Topic topic;
    private UserBasic author;
    private String content;
    private LocalDateTime replyDate;
    private HostReply hostReply;

    public Reply(Integer id) {
        this.id = id;
    }
}