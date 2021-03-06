![#f03c15](https://placehold.it/15/0000ff/000000?text=+)  **★ 协议：Apache Licence 2.0**

![#f03c15](https://placehold.it/15/ffff00/000000?text=+) **★ 声明：本项目的创建者与一切销售或推广的人员无任何合作关系。**

使用后，若觉得效果不错，或者能在学习上帮助到您，欢迎点击右上角的"★ Star" (#^.^#)


# 茶饮销售系统

本系统通俗称为奶茶销售系统，适用对象为小型商户

## 依赖
系统采用C/S架构，采用Swing设计，美化使用到[BeautyEye](https://github.com/JackJiang2011/beautyeye)
用Mybatis作为数据库框架,JFreeChart图表生成工具

## 界面结构
系统的功能分为三个界面，前后台分离，双屏显示
- 员工下单界面，在后屏供显示供管理员进行操作
- 前屏显示界面,在前屏显示，供顾客查看订单信息
- 管理员后台界面,在另外的电脑内显示，供管理员对系统进行管理

## 系统功能

功能主要包含以下几个方面的基本内容：
1. 对于员工，应实现登录，查看饮品类别和饮品，定制饮品，开通会员，订单提交，积分兑换等功能。
1. 对于客户，应该能在前屏显示推荐的人气饮品，订单详情，总价和折扣价。
1. 下单应实现饮品的定制，订单的提交功能。
1. 系统管理员，应实现对系统的会员、订单、饮品、员工模块的所有管理，销售情况统计的输出。

详细的功能需求如下：
1. 登录功能：包括员工账号密码验证，管理员专属密码验证。
1. 下单功能：员工按具体要求定制饮品，确认无误后提交订单到后台。
1. 显示功能：在前屏显示已经添加待购列表的饮品、总价、折扣价、推荐的人气饮品，下单完成后输出的票据。
1. 密码管理功能：管理员能够在后台管理修改员工的登录账号和密码，还可以修改管理员进入后台的专属验证密码。
1. 会员功能：在前台开通，注册时填写个人的基本信息，包括：姓氏、性别、手机号，会员有会员折扣85折，并且可以设置，每次消费一杯饮品就能够累积一点积分，累积满五点积分即可直接在前台与员工沟通兑换任意一杯饮品。
1. 折扣功能：员工可以设置今日折扣，所有顾客均可享受折扣。
1. 管理员系统控制：管理员能够对会员进行添加删除修改，并且能够管理饮品类别、饮品、员工、订单各模块的信息。
1. 统计功能：对销售情况进行销售总量和饮品销售量统计，各自可以按月，按季，按年进行统计。



## 配置文件

db.properties：数据库连接文件，默认账号密码 root 123456

my.conf：主要存放前屏显示窗口的人气饮品图片路径，还有后台管理员的加密密码，密码采用base32加密

## 设计图
本系统的功能模块图如下

数据流图
![数据流图](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/flow.jpg) 

ER图
![ER图](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/er.jpg) 

模块图
![模块图](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/structure.jpg) 



## 系统截图

登录界面

![登录界面](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/login.jpg) 

前台主界面

![主界面](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/main.jpg) 

前屏界面

![主界面](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/front.jpg) 

后台界面

![后台界面](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/manage.jpg) 

饮品管理界面

![饮品管理界面](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/drink.jpg) 

统计界面

![统计界面](https://github.com/zhukangHong/DrinkSeal/blob/master/readmeImg/seal.jpg) 


# 协议
[Apache Licence 2.0](http://www.apache.org/licenses/LICENSE-2.0)

# 个人博客
iamkb's vblog: http://www.iamkb.cn/

# 联系方式
邮箱:**414251867@qq.com**

wechat:**414251867**
