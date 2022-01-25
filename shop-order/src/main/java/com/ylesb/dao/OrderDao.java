package com.ylesb.dao;
/**
 * @title: ProductDao
 * @projectName springcloud-alibaba
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/1/229:08
 */

import com.ylesb.domain.Order;
import com.ylesb.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className    : ProductDao
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/1/22 9:08]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/1/22 9:08]
 * @updateRemark : [描述说明本次修改内容] 
 */

public interface OrderDao extends JpaRepository<Order,Integer>  {
}