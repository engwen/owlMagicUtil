owlMagicUtil工具介绍
-------

* Package name (包名)
com.owl.magicUtil
* The way of reference is (引用方式为)

```
<dependency>
   <groupId>com.github.engwen</groupId>
    <artifactId>owlMagicUtil</artifactId>
    <version>*.*.*</version>
</dependency>
```
#### *项目结构以及介绍如下*

* **model**  常用工具类集合

    1. ModelPrototype  序列化对象，正则中使用。使用 owlMagicComment 时，提供序列化功能
  
* **util**  常用工具类集合  
    1. DateCountUtil 日期工具类 日期格式化，两个日期的间隔小时，月份，年份等等
    2. MD5Util MD5工具类 计算文件或字符串的MD5
    3. ObjectAndByteArrayUtil 对象和数组变换工具
    4. PropertiesUtil 配置文件读取工具
    4. RandomUtil 随机数工具
    5. RegexUtil 正则工具
    6. ClassTypeUtil 类选择工具 

2.3.1

   添加类选择工具ClassTypeUtil,优化reorderRule排序工具
   取消基于接口（MsgConstantUtil）以及枚举(MsgConstantEM)的msg常量，使用新的类MsgConstant，以方便拓展，该类支持继承与重写
   
   
2.3.2-2.3.9
    
   将MVC功能移至 owlMagicComment 中。本工具类现在仅仅提供工具