package com.black.ldchat.common.user.domain.enums;

import lombok.Data;

@Data
public class WSBaseResp<T> {
    /**
     * ws推送给前端的消息
     *
     * @see WSRespTypeEnum
     */
    private Integer type;
    private T data;
}
