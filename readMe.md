owlMagicUtil工具介绍
-------

* 包名
com.owl.magicUtil
* 引用方式为
```
<dependency>
   <groupId>com.github.engwen</groupId>
    <artifactId>owlMagicUtil</artifactId>
    <version>*.*.*</version>
</dependency>
```
#### *项目结构以及介绍如下*
* **constant**  常用的常量类包，采用接口模式  
  1. MsgConstantUtil: 常用的返回信息工具类(现已不推荐使用)
  2. MsgConstantEM: 常用的返回信息枚举类（推荐使用，简化MsgResult中的error与succes方法）
* **controller**  基础controller类
  1. CellBaseController：model 基础类接口  
  提供以下接口  
  ```
    MsgResultVO<T>  create(T model);
    MsgResultVO createList(List<T> list);
    MsgResultVO delete(T model);
    MsgResultVO deleteList(List<Long> idList);
    MsgResultVO<T> update(T model);
    MsgResultVO<T> details(T model);
    MsgResultVO<PageVO<T>> list(Integer requestPage, Integer rows, T model);
    MsgResultVO<List<T>> listAll(T model);
    MsgResultVO isExist(T model);
  ```
  2. CellBaseControllerAb：抽象类，实现了上述接口，在使用时重写其中方法即可  
* **model**  基础返回类  
  1. ModelPrototype： 抽象类，为所有model的基类提供序列化支持   
* **service**  基础service类
  1. CellBaseService：model基础业务类接口  
  2. RelationBaseService：关系型业务接口  
  3. CellBaseServiceAb： 抽象类，实现了CellBaseService
  4. RelationBaseServiceAb：抽象类，实现了RelationBaseService
* **util**  常用工具类集合  
    1. DateCountUtil 日期工具类
    2. MD5Util MD5工具类
    3. ObjectAndByteArrayUtil 对象和数组变换工具
    4. PropertiesUtil 配置文件读取工具
    4. RandomUtil 随机数工具
    5. RegexUtil 正则工具
    6. ClassTypeUtil 类选择工具 
* **vo**  直接使用对象集合  
    1. MsgResultVO  vo级别对象，用于程序返回对象的包装，提供了result，resultCode，resultMsg，resultData，params，以及errorResult,successResult方法
    2. PageVO  分页对象，包含objectList分页对象集合，sumPage总页数，sum总条数，size查询条数，requestPage查询页数，pageList页码集合以及getAll是否获取全部
    3. ReorderVO 排序对象
    4. TreeStrVO 树对象，使用Str作为id和pid时使用
    5. TreeVO 树对象，使用Long或者Integer作为id和pid时使用