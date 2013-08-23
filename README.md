Virtual Campus
===

### TOC

* [目录](#toc)
* [任务单](#任务单)
	* [~~8.23日前完成各自负责模块界面~~](#823日前完成各自负责模块界面)
	* [8.26日前提交各自负责模块界面](#826日前提交各自负责模块界面)
	* [8.30日前提交各自负责模块 DEMO](#830日前提交各自负责模块-demo)
* [git 使用方法](#git-使用方法)
* [基本命名规范](#基本命名规范)
* [代码书写规范](#基本命名规范)
* [注释规范](#注释规范)
* [数据库相关](#数据库相关)

===

### 任务单

#### ~~8.23日前完成各自负责模块界面~~

~~包括个人负责模块的所有界面，包括相关按钮的弹出效果等等，业务逻辑与美化不需考虑。~~

~~在所有模块合并时会将当前登录用户身份作为参数传递，共有三种身份 学生、教师、管理员，设计界面时需要全部考虑。~~

#### 8.26日前提交各自负责模块界面

包括个人负责模块的所有界面，包括相关按钮的弹出效果等等，业务逻辑与美化不需考虑。

#### 8.30日前提交各自负责模块 DEMO

包括各自负责模块全部界面，全部业务逻辑，此阶段不需考虑UI美观。

===

### git 使用方法

安装 & 配置教程 [github help](https://help.github.com/articles/set-up-git)

这里有一篇关于如何使用 github 的教程 [GotGitHub](http://www.worldhello.net/gotgithub/index.html) 其中第 [4.2 共享版本库](http://www.worldhello.net/gotgithub/04-work-with-others/020-shared-repo.html) 基本就是我们需要使用的模式。


* git使用一般流程

```
git clone https://github.com/xindervella/VirtualCampus

	将远程 repo 代码 clone 至本地，只需在首次本地还没有 repo 的时候使用。

修改 & 添加代码

git add .

git pull

	在协作开发时在 commit 前要先将远程 repo 中代码 pull 回来检查是否冲突

git commit -m "注释"

git push

```


* 其他常用 git 命令

```
全局变量初始化：

git config --global user.name "xindervella"

git config --global user.email "xindervella@gmail.com"
```

```
撤销修改：

1. 撤销尚未提交的修改：

git checkout head <文件名> 或 .

2. 撤销提交：

git rest head >文件名>	取消暂存

git rest --head head^  不会在 repo 中留下痕迹

```

```
分支:

1. 创建分支：

git brach <分支名>

2. 合并分支:

git merge <分支名>

3. 删除分支：

git brach -d <分支名> 如果分支没被合并删除失败

git brach -D <分支名> 如果分支没被合并照删不误
```

```
解决冲突：

1. 冲突较少时直接编辑有冲突文件提交即可

2. 冲突较复杂时使用 git merge tool
```



.gitignore 里为不需要同步至 repo 的配置文件，可以自己手动添加不想同步的文件。


===


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

###数据库相关

数据库目前使用 mysql 只能通过内网访问

> **Hostname:  121.248.63.106**

> **Port: 3306**

> **username:  xindervella**

> **password:  hu@idi@nn@0**

> **schemas:  xindervella_VirtualCampus**

目前 **xindervella_VirtualCampus** 的数据表：

|Tables\_in\_xindervella\_VirtualCampus	|
|---------------------------------------|
|	vcUser				|
|	vcStudent			|
|	vcTeacher			|
|	vcClass				|
|	vcCourse			|
|	vcStudentCourse			|


**vcUser** 表中测试数据：

|    uID    |  uPwd   |  uRole  |
| --------- | ------- | ------- |
| 213110561 | 1234567 |  admin  |
| 213110562 | 3456789 | student |
| 213110563 | 4567890 | teacher |

**vcStudent** 表中测试数据 (部分）：

|   sCard   |   ...   |   ...   |   ...   |   ...   |   ...   |  sClassID  |
| --------- | ------- | ------- | ------- | ------- | ------- | ---------- |
| 213110561 |   ...   |   ...   |   ...   |   ...   |   ...   |   090111   |

**vcClass** 表中测试数据 （部分）：

|  cClassID |   ...   |   ...   |   ...   |   ...   |   ...   |   cMajor   |
| --------- | ------- | ------- | ------- | ------- | ------- | ---------- |
|   090111  |   ...   |   ...   |   ...   |   ...   |   ...   |     CSE    |

```sql
-- -----------------------------------------------------
-- 如需获得 学生相关信息
-- 并通过 vcStudent 表中 sClassID 获得相关班级信息 sql 语句可以写为：
-- -----------------------------------------------------
SELECT * FROM vcStudent INNER JOIN vcClass ON sClassID=cClassID;

-- -----------------------------------------------------
-- 如果需要同时限制班级ID 可以使用 AND 关键字:
-- -----------------------------------------------------
SELECT * FROM vcStudent INNER JOIN vcClass ON sClassID=cClassID AND sClassID='090111';
```

常用 [sql 语句](http://www.cnblogs.com/yubinfeng/archive/2010/11/02/1867386.html)

测试数据可以自己添加

<br />

数据库操作样例：[VirtualCampus.operateDbSample](https://github.com/xindervella/VirtualCampus/tree/master/VirtualCampus.operateDbSample)

如需在 eclipse 中操作数据库需要在相关项目 `Build Path` → `Add Library` → `User Library` 中 添加相关 jar 包

项目中使用 [mysql-connector-java-5.1.26-bin.jar](https://github.com/xindervella/VirtualCampus/tree/master/VirtualCampus.operateDbSample/mysql-connector-java-5.1.26)

