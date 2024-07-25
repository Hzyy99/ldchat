package com.black.ldchat.common.user.controller;

import com.black.ldchat.common.common.domain.vo.response.ApiResult;
import com.black.ldchat.common.common.oss.domain.OssResp;
import com.black.ldchat.common.common.utils.RequestHolder;
import com.black.ldchat.common.user.domain.vo.request.oss.UploadUrlReq;
import com.black.ldchat.common.user.service.OssService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description: oss控制层
 */
@RestController
@RequestMapping("/capi/oss")
@Api(tags = "oss相关接口")
public class OssController {
    @Autowired
    private OssService ossService;

    @GetMapping("/upload/url")
    @ApiOperation("获取临时上传链接")
    public ApiResult<OssResp> getUploadUrl(@Valid UploadUrlReq req) {
        return ApiResult.success(ossService.getUploadUrl(RequestHolder.get().getUid(), req));
    }
}
