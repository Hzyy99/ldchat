package com.black.ldchat.common.user.dao;

import com.black.ldchat.common.user.domain.entity.Role;
import com.black.ldchat.common.user.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 */
@Service
public class RoleDao extends ServiceImpl<RoleMapper, Role> {

}
