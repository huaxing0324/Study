package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.will.TaxInvoiceWillDto;
import com.example.demo.study.Offer68_公共祖先;
import io.swagger.annotations.ApiModelProperty;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.*;


@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.example.demo.mapper")
public class DemoApplication {
        public static void main (String[]args) throws InterruptedException, ExecutionException, IOException {


          HashMap<String,Object> m = new HashMap<>();
          m.put("a","b");

          HashMap<String,Object> hashMap = JSONObject.parseObject(JSONObject.toJSONString(m), HashMap.class);

          UserEntity u1 = new UserEntity();
          u1.setCode("u1");
          UserEntity u2 = new UserEntity();
          u2.setCode("u2");
          UserEntity p = new UserEntity();
          p.setCode("p");
          u1.setParent(p);
          u2.setParent(p);

          UserEntity u11 = new UserEntity();
          u11.setCode("u11");
          u11.setParent(u1);
          UserEntity u12 = new UserEntity();
          u12.setCode("u12");
          u12.setParent(u1);

          UserEntity u21 = new UserEntity();
          u21.setCode("u21");
          u21.setParent(u2);
          UserEntity u22 = new UserEntity();
          u22.setCode("u22");
          u22.setParent(u2);

          List<UserEntity> list = new ArrayList<>();
          list.add(u11);
          list.add(u12);
          list.add(u21);
          list.add(u22);
          String s2 = JSONArray.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);

          String s1 = new BigDecimal("1.2340").stripTrailingZeros().toString();
          String
              .format("abc-%s-ddd", new BigDecimal("1.2340").stripTrailingZeros());
          BigDecimal bigDecimal = new BigDecimal("-789789.123");
          int precision = bigDecimal.precision();
          int scale = bigDecimal.scale();
          ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
              .configure()
              .addProperty(HibernateValidatorConfiguration.FAIL_FAST, "false")
              .buildValidatorFactory();
          Validator validator = validatorFactory.getValidator();


          String s = "{\"applyType\":\"1\",\"jshj\":\"1\",\"je\":\"1\",\"se\":\"1\",\"data\":{\"se\":\"1\"}}";
          Object data = JSONObject.parseObject(s).get("data");
          JSONObject d = (JSONObject) data;
          Map<String, Object> innerMap = d.getInnerMap();
          TaxInvoiceWillDto will = JSONObject.parseObject(s, TaxInvoiceWillDto.class);
          Set<ConstraintViolation<TaxInvoiceWillDto>> validate = validator.validate(will);
          for (ConstraintViolation<TaxInvoiceWillDto> v : validate) {
            v.getMessage();
          }


//          Set<ConstraintViolation<T>> violationSet = hibernateValidator.validate(bill);



          ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

            System.out.println("spring boot started success");
        }
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2);
    }
    }
