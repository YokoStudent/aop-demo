package pers.yoko.aopdemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yoko
 * @date 2021/9/3 14:59
 * @since 1.0
 */
@Entity
@Table(name = "t_dept")
@Data
public class Dept{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String deptName;

    public Dept() {}
    public Dept(int id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }
}
