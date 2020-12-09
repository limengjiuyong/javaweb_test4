package com.example.demo.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class testMbg {
	public static void main(String[] args) throws Exception  {
	// MBG 执行过程中的警告信息
    List<String> warnings = new ArrayList<String>();
    // 当生成的代码重复时，覆盖原代码
    boolean overwrite = true;
    // 读取我们的 MBG 配置文件
    File is = new File("mbg.xml");
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = cp.parseConfiguration(is);
    //is.close();

    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    // 创建 MBG
    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    // 执行生成代码
    myBatisGenerator.generate(null);
   
}
}
