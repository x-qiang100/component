package com.xq.impl;

import com.xq.Service.OrderService;
import com.xq.Service.UserService;
import com.xq.bean.UserAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {

        return userService.getUserAddressList(userId);

    }
}
