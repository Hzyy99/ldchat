package com.black.ldchat.common.chatai.domain.builder;

import com.black.ldchat.common.chatai.domain.ChatGPTContext;

public class ChatGPTContextBuilder {

    public static ChatGPTContext initContext(Long uid, Long roomId) {
        ChatGPTContext chatGPTContext = new ChatGPTContext();
        chatGPTContext.setUid(uid);
        chatGPTContext.setRoomId(roomId);
        chatGPTContext.addMsg(ChatGPTMsgBuilder.systemPrompt());
        return chatGPTContext;
    }

}
