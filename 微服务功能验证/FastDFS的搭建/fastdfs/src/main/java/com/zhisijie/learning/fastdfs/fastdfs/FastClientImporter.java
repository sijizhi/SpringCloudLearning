package com.zhisijie.learning.fastdfs.fastdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/22 17:31
 */
@Configuration
@Import(FdfsClientConfig.class)
/**
 * 解决jmx重复注册bean的问题
 */
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastClientImporter {
}