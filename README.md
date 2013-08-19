Virtual Campus
========

### 基本命名规范

* 避免难懂的名称，如xxK8

* 类命名使用Pascal大小写处理 (CalculateInvoiceTotal)，其中每个单词的第一个字母都是大写的。

* 函数 & 变量命名，使用camel大小写处理 (documentFormatType)，其中除了第一个单词外每个单词的第一个字母都是大写的。构造函数命名与类命名相同。

* 常量命名，不要使用原义数字或原义字符串，而是使用命名常数（MAX_VALUE） ，以便于维护和理解。

### 代码书写规范

**尤其是谈小伟请注意再密密麻麻写一起就干死你**

* 在括号对齐方式使用以下两种均可

```java
for(i=0; i<100; i++){

	// code block

}

for(i=0; i<100; i++)
{

	// code block

}

```

* 沿逻辑结构行缩进


```java
if(expression){
	if(expression){

		// code block

	} else {

		// code block

	}
}
```

* SQL语句关键字全部使用大写

```sql
SELECT * FROM Table1 WHERE State = 'WA';
```

### 注释规范

**所有Java代码，请至少在编写时写明以下注释**

* 某个类之前

```java
/**
 * 类的简单介绍
 * @author      类作者
 */
public class Test {

	// class body

}
```

* 某个方法（函数）前：

```java
/**
 * 函数功能介绍
 * @param  传入参数
 * @return  返回值
 */
public void test(){

	// function body

}
```
具体参照 [javadoc](http://en.wikipedia.org/wiki/Javadoc)

===

.gitignore 里为不需要同步至 repo 的配置文件，可以自己手动添加不想同步的文件。

===

server 端数据库目前使用 mysql 如需使用需要自己添加依赖包

数据表名为 `holyshit`

数据库登陆用户名为 `root`

数据库登陆密码为 `123212321`

```sql
CREATE  TABLE `holyshit`.`user` (

  `sID` INT NOT NULL ,

  `password` VARCHAR(45) NOT NULL ,

  `type` INT NOT NULL COMMENT 'USER_TYPE:1:STUDENT;2:TEACHER;3:OTHER' ,

  `name` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`sID`) ,

  UNIQUE INDEX `sID_UNIQUE` (`sID` ASC) )

DEFAULT CHARACTER SET = utf8;
```

测试数据需自己添加
