package com.black.ldchat.common.chat.controller;


import com.black.ldchat.common.chat.domain.vo.request.ContactFriendReq;
import com.black.ldchat.common.chat.domain.vo.response.ChatRoomResp;
import com.black.ldchat.common.chat.service.ChatService;
import com.black.ldchat.common.chat.service.RoomAppService;
import com.black.ldchat.common.common.domain.vo.request.CursorPageBaseReq;
import com.black.ldchat.common.common.domain.vo.request.IdReqVO;
import com.black.ldchat.common.common.domain.vo.response.ApiResult;
import com.black.ldchat.common.common.domain.vo.response.CursorPageBaseResp;
import com.black.ldchat.common.common.utils.RequestHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/capi/chat")
@Api(tags = "聊天室相关接口")
@Slf4j
public class ContactController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private RoomAppService roomService;

    @GetMapping("/public/contact/page")
    @ApiOperation("会话列表")
    public ApiResult<CursorPageBaseResp<ChatRoomResp>> getRoomPage(@Valid CursorPageBaseReq request) {
        Long uid = RequestHolder.get().getUid();
        return ApiResult.success(roomService.getContactPage(request, uid));
    }

    @GetMapping("/public/contact/detail")
    @ApiOperation("会话详情")
    public ApiResult<ChatRoomResp> getContactDetail(@Valid IdReqVO request) {
        Long uid = RequestHolder.get().getUid();
        return ApiResult.success(roomService.getContactDetail(uid, request.getId()));
    }

    @GetMapping("/public/contact/detail/friend")
    @ApiOperation("会话详情(联系人列表发消息用)")
    public ApiResult<ChatRoomResp> getContactDetailByFriend(@Valid ContactFriendReq request) {
        Long uid = RequestHolder.get().getUid();
        return ApiResult.success(roomService.getContactDetailByFriend(uid, request.getUid()));
    }
}

