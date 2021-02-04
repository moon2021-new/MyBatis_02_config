---
## HelloWorld 最简单的MyBatis使用
----
### 坑
- MySql版本太低，将 mysql-connector-java-x.jar替换为最新版本
- 链接配置：
    - com.mysql.cj.jdbc.Driver
    - jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;serverTimezone=Asia/Shanghai"

----
### 步骤
- 数据库中创建一张测试表
- 创建对应的javaBean：Employee.java
- 创建mybatis的配置文件,sql映射文件
    - 全局配置文件：mybatis-config.xml
    - sql映射文件 : EmployeeMapper.xml
- 测试    
    - 1、根据全局配置文件， 利用
      SqlSessionFactoryBuilder创建SqlSessionFactory
    - 2、使用SqlSessionFactory获取sqlSession对象。一个
      SqlSession对象代表和数据库的一次会话。
    - 使用SqlSession根据方法id进行操作
```java
String resource = "mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

SqlSession openSession = sqlSessionFactory.openSession();
try {
    Employee employee = openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
    System.out.println(employee);
}finally {
    openSession.close();
}
```


----
### other（MyBatisTest.java）
- 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
- 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。
- 3、将sql映射文件注册在全局配置文件中
- 4、写代码：
    - 1）、根据全局配置文件得到SqlSessionFactory；
    - 2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
        - 一个sqlSession就是代表和数据库的一次会话，用完关闭
    - 3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。

- 2、获取sqlSession实例，能直接执行已经映射的sql语句
    - // sql的唯一标识：statement Unique identifier matching the statement to use.
    - // 执行sql要用的参数：parameter A parameter object to pass to the statement.
    

----
### 接口式编程
    