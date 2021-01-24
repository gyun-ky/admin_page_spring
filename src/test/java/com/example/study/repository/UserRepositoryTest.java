package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void read(){
        Optional<User> user = userRepository.findById(4L);

        user.ifPresent(selectUser->{
            System.out.println("user"+selectUser);
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(4L);

        user.ifPresent(selectUser->{
            selectUser.setAccount("pppp");
            selectUser.setUpdateAt(LocalDateTime.now());
            selectUser.setUpdateBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+ deleteUser.get());
        }
        else{
            System.out.println("데이터 삭제 데이터 없음");
        }
    }
}
