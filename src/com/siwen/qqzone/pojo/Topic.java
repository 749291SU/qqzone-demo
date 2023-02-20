package com.siwen.qqzone.pojo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @projectName: qqzone
 * @package: com.siwen.qqzone.pojo
 * @className: Topic
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 8:46 PM
 * @version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Topic {
    private Integer id;
    private UserBasic author;
    private String title, content;
    private LocalDateTime topicDate;
    private List<Reply> replyList;



}