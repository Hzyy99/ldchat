package com.black.ldchat.common.user.service.impl;

import com.black.ldchat.common.common.oss.MinIOTemplate;
import com.black.ldchat.common.common.oss.domain.OssReq;
import com.black.ldchat.common.common.oss.domain.OssResp;
import com.black.ldchat.common.common.utils.AssertUtil;
import com.black.ldchat.common.user.domain.enums.OssSceneEnum;
import com.black.ldchat.common.user.domain.vo.request.oss.UploadUrlReq;
import com.black.ldchat.common.user.service.OssService;

//import com.black.ldchat.oss.MinIOTemplate;
//import com.black.ldchat.oss.domain.OssReq;
//import com.black.ldchat.oss.domain.OssResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class OssServiceImpl implements OssService {
    @Autowired
    private MinIOTemplate minIOTemplate;

    @Override
    public OssResp getUploadUrl(Long uid, UploadUrlReq req) {
        OssSceneEnum sceneEnum = OssSceneEnum.of(req.getScene());
        AssertUtil.isNotEmpty(sceneEnum, "场景有误");
        OssReq ossReq = OssReq.builder()
                .fileName(req.getFileName())
                .filePath(sceneEnum.getPath())
                .uid(uid)
                .build();
        return minIOTemplate.getPreSignedObjectUrl(ossReq);
    }
}
