package com.ylesb.controller;
/**
 * @title: OrderController
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/2510:39
 */

import com.alibaba.fastjson.JSON;
import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import com.ylesb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @className    : OrderController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/25 10:39]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/25 10:39]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        log.info("接收{}号商品下单",pid);
        //进行商品查询
        Product product =restTemplate.getForObject("http://localhost:8081/product/"+pid,Product.class);
        log.info("查询到{}商品的信息是{}",pid, JSON.toJSONString(product));
        //创建订单
        Order order=new Order();
        order.setUid(1);
        order.setPid(pid);
        order.setUname("xgc");
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.createOrder(order);
        log.info("下单{}号成功！",pid);
        return order;
    }
}
