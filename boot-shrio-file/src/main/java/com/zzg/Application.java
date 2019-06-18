package com.zzg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement // 启动事务
@MapperScan("com.zzg.*.dao") // 扫描dao层
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SpringApplicationBuilder(Application.class).run(args);
	}

}
