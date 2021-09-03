package pers.yoko.aopdemo.service;

import pers.yoko.aopdemo.entity.Dept;

/**
 * @author yoko
 * @date 2021/9/3 14:59
 * @since 1.0
 */
public interface DeptService {
    void createDept(Dept dept);

    Dept queryDept(Integer id);
}
