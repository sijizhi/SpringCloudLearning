package com.example.pagehelper.service.Impl;

import com.example.pagehelper.entity.Document;
import com.example.pagehelper.mapper.DocumentMapper;
import com.example.pagehelper.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/23 21:16
 */
@Component
public class DocumentImpl implements DocumentService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private   DocumentMapper documentMapper;
    private Document document;
    @Override
    public int millionAdd() throws Exception {
        Long preTime=System.currentTimeMillis();
        int len=0;
        int departId=0;
        //总共100万份文件
        for(int i=0;i<1000;i++){
            //1-1000 levelId(1000个最小节点）
            for(int j=0;j<1000;j++){
                if(departId%2==0){
                    departId=1;
                }else{
                    departId=2;
                }
                len ++;
                logger.info("现在执行到文件》》》》"+len);
                document=new Document("文件"+len, departId, UUID.randomUUID().toString(),j ,(int) Math.ceil(Math.random()*10) );
                documentMapper.millionAdd(document);
            }
        }

//        TimeUnit.SECONDS.sleep(2);
        Long lastTime=System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
        System.out.println("已经结束啦！！！！！！");
        System.out.println("开始时间》》》》》》》"+formatter.format(new Date(preTime)));
        System.out.println("结束时间》》》》》》》"+formatter.format(new Date(lastTime)));
        System.out.println((lastTime-preTime)/1000+"s");
       return 1;
    }

}
