package com.xq.impl;

import com.xq.Service.UserService;
import com.xq.bean.UserAddress;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

        @Override
        public List<UserAddress> getUserAddressList(String userId) {
            ArrayList<UserAddress> list = new ArrayList();
            list.add(new UserAddress(1,"01","615"));
            list.add(new UserAddress(2,"02","613"));
            list.add(new UserAddress(3,"03","617"));
            return list;
        }

}
