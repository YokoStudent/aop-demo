package pers.yoko.aopdemo.service.impl;

import pers.yoko.aopdemo.entity.Dept;
import pers.yoko.aopdemo.service.DeptService;

/**
 * @author yoko
 * @date 2021/9/3 15:02
 * @since 1.0
 */
public class DeptServiceImpl implements DeptService {
    @Override
    public void createDept(Dept dept) {
        System.out.println("创建dept中...");
    }

    @Override
    public Dept queryDept(Integer id) {
        System.out.println("查询queryDept中...");
        return new Dept(1, "研发部门");
    }
}
