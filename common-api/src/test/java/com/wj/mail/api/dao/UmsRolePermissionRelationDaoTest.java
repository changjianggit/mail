package com.wj.mail.api.dao;

import com.wj.mail.dao.UmsRolePermissionRelationDao;
import com.wj.mail.model.UmsPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: springLearnDemo <br>
 * @Description: Mybatis测试类 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-07-04 11:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsRolePermissionRelationDaoTest {
    @Autowired
    private UmsRolePermissionRelationDao umsRolePermissionRelationDao;

    @Test
    public void testGetPermissionList() {
        List<UmsPermission> umsPermissionList = umsRolePermissionRelationDao.getPermissionList(2L);
        umsPermissionList.forEach(umsPermission -> System.out.println(umsPermission.toString()));
    }
}
