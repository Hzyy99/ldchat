package com.black.ldchat.common.user.service;

import com.black.ldchat.common.common.oss.domain.OssResp;
import com.black.ldchat.common.user.domain.vo.request.oss.UploadUrlReq;
//import com.black.ldchat.oss.domain.OssResp;


/**
 * <p>
 * oss 服务类
 * </p>
 */
public interface OssService {

    /**
     * 获取临时的上传链接
     */
    OssResp getUploadUrl(Long uid, UploadUrlReq req);
}
