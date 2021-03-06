package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.bean.UserAddress;
import com.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 1.将服务提供者注册到注册中心（暴露服务）
 *      a.导入sringboot-dubbo依赖及其他dubbo依赖
 *      b.配置服务提供者
 * 2.让服务消费者到注册中心订阅服务提供者的服务地址
 *
 */
@Service   //应该引入dubbo的service,暴露服务,通过该注解将该服务注册中注册中心
@Component //springboot 组件 因为要引入dubbo的service注解，所以spring的service不能用了，只能引入Component
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public List<UserAddress> qryUserAddressList(String userId) {
        logger.info("Begin call UserServiceImpl qryUserAddressList method  and request params{} " , JSON.toJSONString(userId));
        UserAddress userAddress1 = new UserAddress(
                1,
                "北京大兴区经开大厦",
                "10001",
                "Tom",
                "18402021042",
                "N"
        );
        UserAddress userAddress2 = new UserAddress(
                2,
                "北京大兴区大雄郁金香",
                "10001",
                "Tom",
                "18402021042",
                "Y"
        );
        List<UserAddress> userAddresses = Arrays.asList(userAddress1, userAddress2);
        System.out.println(userAddresses);
        return userAddresses;
    }
}
