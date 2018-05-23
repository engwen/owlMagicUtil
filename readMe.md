owlMagicUtil工具介绍
-------

*双师课堂一期中所有工具均来自自身，二期为提高相关代码重用度，转而采用引用jar的方式，用到的私有包被命名为owlMagicUtil-2.1（美容项目，owlMagicFile以及一期中均为1.0版本，后升级为1.1，1.2，2.0，2.1，但只有2.0，2.1版本被应用在二期以及owlMagicShiro中），这里只对2.1最新版的做一下基本说明*

* 包名
com.owl.magicUtil
* 引用方式为
```
<dependency>
    <groupId>owl.magic.util</groupId>
    <artifactId>owlMagicUtil</artifactId>
    <version>2.1-SNAPSHOT</version>
</dependency>
```
#### *项目结构以及介绍如下*
* **constant**  常用的常量类包，采用接口模式  
  1. MsgConstantUtil： 常用的返回信息工具类
* **model**  基础返回类  
  1. MsgResult： 抽象类，为所有model的基类提供基础返回消息以及序列化支持、错误消息以及成功消息初始化方法、请求参数以及返回参数的包装等等   
  2. MenuBase： 抽象类，菜单基础类
* **service**  基础service类
  1. CellBaseService：model基础业务类接口  
  提供以下接口  
  ```
   T create(T model);
   MsgResult createList(List<T> modelList);
   MsgResult delete(Long id);
   MsgResult deleteList(List<Long> idList);
   MsgResult banOrLeave(Long id, Boolean status);
   MsgResult banOrLeaveList(List<Long> idList, Boolean status);
   MsgResult update(T model);
   T details(T model);
   PageVO<T> list(Boolean getAll, Integer requestPage, Integer size, T model);
   List<T> listAll(T model);
  ```
  2. RelationBaseService：关系型业务接口  
  提供以下接口  
    ```
     MsgResultVO insert(T model);
     MsgResultVO insertList(List<T> modelList);
     MsgResultVO delete(T model);
     MsgResultVO deleteList(List<T> modelList);
    ```
    3. CellBaseServiceAb： 抽象类，实现了CellBaseService
    4. RelationBaseServiceAb：抽象类，实现了RelationBaseService
* **util**  常用工具类集合  
    1. DateCountUtil 日期工具类
    2. MD5Util MD5工具类
    3. ObjectAndByteArrayUtil 对象和数组变换工具
    4. PropertiesUtil 配置文件读取工具
    4. RandomUtil 随机数工具
    5. RegexUtil 正则工具
* **vo**  直接使用对象集合  
    1. MsgResultVO  vo级别对象，以方便操作其他model类的vo对象时，保持msgresult对象与vo对象同级
    2. PageVO  分页对象，包含objectList分页对象集合，sumPage总页数，sum总条数，size查询条数，requestPage查询页数，pageList页码集合以及getAll是否获取全部