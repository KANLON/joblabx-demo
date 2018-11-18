# joblabxDemo
&emsp;&emsp;该项目为参加Joblabx比赛的热身题，主要功能是通过上传Excel文件，然后分析文件中的数据。
<br/>
项目链接：<a href="http://kanlon.ink:8081/joblabxDemo/">http://kanlon.ink:8081/joblabxDemo/</a>
<br/>
接口文档地址：<a href='https://documenter.getpostman.com/view/3892535/RzZDhGNM'>https://documenter.getpostman.com/view/3892535/RzZDhGNM</a>

<br/><br/>
<hr/>

#### 2018年11月19日
0.  当前项目架构为：html+css+jquery+bootstrap+servlet+c3p0+DBUtil+jdbc+mysql（因为迭代要求快，当时也想重新复习这些一下基础技术，所以用了这些简单技术，并没有使用大量使用后端框架搭建，后期会逐步使用框架改进，也当复习）
1. 修改了一下mysql文件，修改了表结构（sql/20181119dump.sql）的文件为最新的sql文件，只要导入这个就可以了。更改数据库名为joblabx。
2.  本地测试过上传含有20万条数据的excel文件也可以，大概花费2分钟。读取excel40秒，写入数据库70秒左右。未来应该会对其进行优化，mysql写入大量数据优化有点困难。
3. 重新修改数据库为本地数据库。
4. 后期计划，增加地图功能，优化mysql大量写入，使用spring boot框架优化结构

#### 2018年11月18日
1. 增加查看原始数据的功能。
2. 使用C3P0链接池
3. 修改功能展示页面
4. 增加学校情况表，用来绘制各省人数图
5. 还差各省地图功能
6. 项目链接：<a href="http://kanlon.ink:8081/joblabxDemo/">http://kanlon.ink:8081/joblabxDemo/</a>



#### 2018年11月17日
1. 增加sql文件
2. 增加男女比例分析和删除原来的数据
3. 增加前5名的各高校参赛人数数量
4. 更改了新的模板，使用决赛模板，增加部门列

#### 2018年11月14日
1. 已经能上传2007版后的excel了。
2. 添加了直接前往各个学校人数和各个入学年份的情况分析页面的链接。
3. 下一步打算根据用户需要决定要不要叠加结果。
4. 还有可能清除之前上传的数据的功能。
5. 测试链接：<a href="http://kanlon.ink:8081/joblabxDemo5/">http://kanlon.ink:8081/joblabxDemo5/</a>

#### 2018年11月13日

1. 增加连接数据库和测试文件（测试的excel文件在webroot/testdata/目录下）。
2. 当前只能上传一个文件，分析一次，返回json原始数据。
3. 当前只能解析2003版及之前的excel表，预计明天会使系统兼容2007版后的excel表。
4. 已经初步完成前端后整合，能展示各学校，各学年的人数情况，还需要具体表格数据和相关交互设计，预计11月15号能完成。
5. 还需要登录注册功能，以便能存储到对应用户的Excel表信息。
6. 当前只能上传一次分析一次，然后结果会叠加，下一步打算根据用户需要决定要不要叠加结果。
7. 测试连接：
<a href="http://kanlon.ink:8081/joblabxDemo4/">http://kanlon.ink:8081/joblabxDemo4/</a>
