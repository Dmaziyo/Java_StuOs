### 使用方法

```JAVA
//在mybatis-config.xml修改成你的mysql用户名和密码即可
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
    	//修改区域**************
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/stusys_java"/>
                <property name="username" value="root"/>
                <property name="password" value="abc123456"/>
    	//***************
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper class="mapper.Score.ScoreMapper"/>
        <mapper resource="mapper/Stu/StuMapper.xml"/>
        <mapper resource="mapper/Course/CourseMapper.xml"/>
        <!--    这里用的是url，也可以使用其他类型，我们会在后面讲解    -->
    </mappers>
</configuration>

```

