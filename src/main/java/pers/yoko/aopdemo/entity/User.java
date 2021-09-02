package pers.yoko.aopdemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yoko
 * @date 2021/9/1 10:49
 * @since 1.0
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public User() {}
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}