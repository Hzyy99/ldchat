package com.black.ldchat.common.chat.service;

import com.black.ldchat.common.chat.domain.entity.RoomFriend;
import com.black.ldchat.common.chat.domain.entity.RoomGroup;

import java.util.List;

public interface RoomService {

    /**
     * 创建一个单聊房间
     */
    RoomFriend createFriendRoom(List<Long> uidList);

    RoomFriend getFriendRoom(Long uid1, Long uid2);

    /**
     * 禁用一个单聊房间
     */
    void disableFriendRoom(List<Long> uidList);


    /**
     * 创建一个群聊房间
     */
    RoomGroup createGroupRoom(Long uid);


}
