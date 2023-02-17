package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@Transactional
@Service
public class ServiceImpl implements IService {

@Resource
    UserMapper userMapper;

    public static void test(Object getCode) {

    }

    @Override
    public void test() {
        for (int i = 0; i < 200; i++) {
            UserEntity u = new UserEntity();
            u.setName("012345678901234567890");
            u.setCode(UUID.randomUUID().toString().replace("-",""));
            u.setContent("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
            u.setCreateTime(new Date());
            userMapper.insert(u);


        }
    }


    public void shutdown(){
        pool.shutdownNow();
    }

    ThreadPoolExecutor pool = new ThreadPoolExecutor(1,1,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
    AtomicLong count = new AtomicLong();
    @PostConstruct
    void init(){

        for (int i = 0; i < 5; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    //Thread.currentThread().setDaemon(false);
                    try {
                        System.out.println("begin");
                        Thread.sleep(1000);
                        System.out.println("a");
                        Thread.sleep(1000);
                        System.out.println("b");
                        Thread.sleep(1000);
                        System.out.println("c");
                        Thread.sleep(1000);
                        long l = count.incrementAndGet();
                        System.out.println(l);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("error");
                    }

                }
            });
        }
    }


}
