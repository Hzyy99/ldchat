package com.black.ldchat.common.common.event.listener;

import com.black.ldchat.common.common.event.UserOfflineEvent;
import com.black.ldchat.common.user.dao.UserDao;
import com.black.ldchat.common.user.domain.entity.User;
import com.black.ldchat.common.user.domain.enums.ChatActiveStatusEnum;
import com.black.ldchat.common.user.service.WebSocketService;
import com.black.ldchat.common.user.service.adapter.WSAdapter;
import com.black.ldchat.common.user.service.cache.UserCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 用户下线监听器
 */
@Slf4j
@Component
public class UserOfflineListener {
    @Autowired
    private WebSocketService webSocketService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserCache userCache;
    @Autowired
    private WSAdapter wsAdapter;

    @Async
    @EventListener(classes = UserOfflineEvent.class)
    public void saveRedisAndPush(UserOfflineEvent event) {
        User user = event.getUser();
        userCache.offline(user.getId(), user.getLastOptTime());
        //推送给所有在线用户，该用户下线
        webSocketService.sendToAllOnline(wsAdapter.buildOfflineNotifyResp(event.getUser()), event.getUser().getId());
    }

    @Async
    @EventListener(classes = UserOfflineEvent.class)
    public void saveDB(UserOfflineEvent event) {
        User user = event.getUser();
        User update = new User();
        update.setId(user.getId());
        update.setLastOptTime(user.getLastOptTime());
        update.setActiveStatus(ChatActiveStatusEnum.OFFLINE.getStatus());
        userDao.updateById(update);
    }

}
