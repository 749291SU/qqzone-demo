package com.siwen.qqzone.pojo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @projectName: qqzone
 * @package: com.siwen.qqzone.pojo
 * @className: HostReply
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 8:49 PM
 * @version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HostReply {
    private Integer id;
    private Reply reply;
    private UserBasic author;
    private String content ;
    private LocalDateTime hostReplyDate;
}