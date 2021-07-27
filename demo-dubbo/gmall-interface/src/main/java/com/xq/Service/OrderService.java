package com.xq.Service;

import com.xq.bean.UserAddress;

import java.util.List;

public interface OrderService {

    public List<UserAddress> initOrder(String userId);

}
