package org.ndshop.user.common.entity;

import org.ndshop.dbs.jpa.entity.BaseEntity;

import javax.persistence.*;

/**
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: [用户喜好]
 * @Version: [1.0.0]
 * @Copy: [org.ndshop]
 */
@Entity
@Table(name = "user_interest")
public class UserInterest extends BaseEntity {
    //用户
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    //商品类型


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
