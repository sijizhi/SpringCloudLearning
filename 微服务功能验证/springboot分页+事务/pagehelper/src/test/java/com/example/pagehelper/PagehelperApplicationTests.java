package com.example.pagehelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PagehelperApplicationTests {
	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Test
	public void contextLoads() {
		int len=0;
		long pre=System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			for(int j=1;j<=10000;j++){
				len++;
				//logger.info("现在执行到》》》》"+len);
				if(i%2==0){
					if(j%2==0){
						if(len%2==0){
							if(j%2==0){
								if(len%2==0){
									System.out.println("现在执行到》》》》"+len);
								}
							}
						}
					}
				}
			}
		}

		long last=System.currentTimeMillis();
		System.out.println((last-pre)+"ms");
	}

}

