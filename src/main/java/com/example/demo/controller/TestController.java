package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.demo.entity.TaxEptTimeExportModel;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@RestController
public class TestController implements Serializable {

    Logger logger = LoggerFactory.getLogger(getClass());

    AtomicLong count = new AtomicLong();
    volatile long last = 0;

    public TestController() {
        int a = 0;

    }

    @Resource
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

    @Autowired
    ServiceImpl service;

    @GetMapping(value = "/sleep")
    public String sleep1(){
        service.shutdown();
        return "ok";
    }

    @PostMapping(value = "/map")
    public String map(@RequestBody HashMap<String,Object> map){
        HashMap<String,Object> data = (HashMap<String, Object>) map.get("data");
        return "ok";
    }

    @GetMapping(value = "/test")
    public void test(HttpServletResponse response) throws Exception {
        final File currentUserExcelDir = new File("/temp/", "excel");
        if(!currentUserExcelDir.exists()){
            currentUserExcelDir.mkdirs();
        }
        File excelFile = new File("/temp/excel/",   "123.xlsx");
        if(excelFile.exists()){
            excelFile.delete();
        }
        excelFile.createNewFile();
        ExcelWriter         excelWriter =
                EasyExcel.write(excelFile)
                        .withTemplate(new ClassPathResource("static/hailuo_ept_template.xlsx").getInputStream())
                        .build();
//
//        FileOutputStream fos = new FileOutputStream("/temp/excel/tmp.xlsx");
//        byte[] b = new byte[1024];
//        int length;
//        while((length= inputStream.read(b))>0){
//            fos.write(b,0,length);
//        }
//        fos.close();
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
        TaxEptTimeExportModel m = new TaxEptTimeExportModel();
        m.setFirstTypeName("abcdef");
        excelWriter.write(Arrays.asList(m), writeSheet);
        excelWriter.finish();


        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/zip");
        final String fileName =   "环保税税局文件.zip";
        response.setHeader(
                "Content-disposition",
                "attachment; filename="
                        + new String(fileName.getBytes(StandardCharsets.UTF_8), "iso8859-1"));

        try (ZipOutputStream out = new ZipOutputStream(response.getOutputStream())) {
            for (File file : currentUserExcelDir.listFiles()) {
                out.putNextEntry(new ZipEntry(file.getName()));
                try (final FileInputStream in = new FileInputStream(file)) {
                    final byte[] bytes = new byte[in.available()];
                    in.read(bytes);
                    out.write(bytes);
                }
                out.closeEntry();
            }
        }

    }

    @GetMapping(value = "/test1")
    public String sleep() throws SQLException {
        for (int n = 0; n < 12; n++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    int size = 500;
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {

                        Connection connection = null;
                        try {
                            connection = dataSource.getConnection();

                            connection.setAutoCommit(false);
                            String sql = "";
                            StringBuilder sb = new StringBuilder(190000);
                            sb.append("insert into user(name,code,content,create_time) values");
                            for (int j = 1; j <= size; j++) {
                                if (j == size) {
                                    sb.append("('012345678901234567890','356c382ee1f44b2a87dd98b619950798','01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789','2022-01-22')");
                                } else {
                                    sb.append("('012345678901234567890','356c382ee1f44b2a87dd98b619950798','01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789','2022-01-22'),");
                                }
                            }
                            sql = sb.toString();
                            Statement statement = connection.createStatement();
                            statement.execute(sql);
                            connection.commit();
                            connection.close();
                            count.getAndAdd(size);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }


                }
            }).start();
        }


        return "ok";
    }
}
