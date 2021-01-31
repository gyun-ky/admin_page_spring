package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    //DI
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s, %s, %d value(account, email, age);
        //과거 라면 저렇게 쿼리문을 활용해서 넣어줌
        User user = new User();
        user.setAccount("TestUser02");
        user.setEmail("kiyoon9390@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser02");

        User newUser = userRepository.save(user);

        System.out.println("newUser : " +newUser);

    }

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findById(5L);

        user.ifPresent(selectUser->{
            selectUser.getOrderDetailList().stream().forEach(detail->{
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }

    @Test
    public void update(){

        //select * from user where id = ?
        Optional<User> user = userRepository.findByAccount("TestUser02");

        user.ifPresent(selectUser->{
            selectUser.setAccount("pppp");
            selectUser.setUpdateAt(LocalDateTime.now());
            selectUser.setUpdateBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // roll back 시켜서 쿼리는 실행하지만 db에는 결론적으로 반영되지 않는다
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

        Assert.assertTrue(user.isPresent()); //true

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent()); //false
    }
}
