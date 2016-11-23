package test_java_service;

import com.alibaba.fastjson.JSON;
import org.ndshop.dbs.jpa.exception.SerException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test_java_service.code.ApplicationConfiguration;
import test_java_service.code.entity.User;
import test_java_service.code.entity.UserInterest;
import test_java_service.code.service.IUserInterestSer;
import test_java_service.code.service.IUserSer;

import java.util.*;

/**
 * Created by huanghuanlai on 2016/10/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class OneToMany {


    /**
     * one to many Test
     * 一般由多的一方维护关系
     */

    @Autowired
    private IUserSer userSer;
    @Autowired
    private IUserInterestSer interestSer;


    @Before
    public void init() throws SerException {
        if (null == userSer.findByUsername("liguiqin")) {
            User user = new User();
            user.setUsername("liguiqin");
            user.setPassword("123456");
        }
    }

    @Test
    public void addUserInterest() throws SerException {
        Optional<User> optional = userSer.findByUsername("liguiqin");
        List<UserInterest> interests = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            UserInterest interest = new UserInterest();
            interest.setName("ga" + i);
            interest.setUser(optional.get());
            interest.setSeq(i);
            interests.add(interest);
        }
        interestSer.save(interests);
        System.out.println(JSON.toJSONString(optional.get()));
    }

    @Test
    public void delUserInterest() throws SerException {
        Optional<User> optional = userSer.findByUsername("liguiqin");
        Set<UserInterest> interests = optional.get().getInterests();
        if (null != interests) {
            interestSer.remove(interests);
        }
        System.out.println(JSON.toJSONString(optional.get()));
    }


    @Test
    public void updateUserInterest() throws SerException {
        Optional<User> optional = userSer.findByUsername("liguiqin");
        Set<UserInterest> interests = optional.get().getInterests();
        if (null != interests) {
            for (UserInterest interest : interests) {
                interest.setName("update" + new Random().nextInt(999));
            }
        }
        interestSer.update(interests);
        System.out.println(JSON.toJSONString(optional.get()));
    }


}
