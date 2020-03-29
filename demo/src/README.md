该module实现接口的幂等操作
幂等性解释：
- 幂等性, 通俗的说就是一个接口, 多次发起同一个请求, 必须保证操作只能执行一次

常见解决方法：

1. 唯一索引 -- 防止新增脏数据

2. token机制 -- 防止页面重复提交

3. 悲观锁 -- 获取数据的时候加锁(锁表或锁行)

4. 乐观锁 -- 基于版本号version实现, 在更新数据那一刻校验数据

5. 分布式锁 -- redis(jedis、redisson)或zookeeper实现

6. 状态机 -- 状态变更, 更新数据时判断状态

本文实现网上的已有方案，token机制实现方式，基于redis实现  
实现原理： 

1. 请求token，并在redis存储
2. 携带token进行请求
3. 判断token,存在且进过校验则处理逻辑并删除token
4. 重复请求无法通过校验


[参考](https://mp.weixin.qq.com/s?src=11&timestamp=1585448631&ver=2245&signature=NGwph9MmJYoyvaneGT60k0yg-aI1Ros2zxh1yO1U5kbt*7TPcoRgJLbuGmp1ulf352yElO27x6-A9fnBTm35a5qAu4Rp3zTS9saaG6igbi0-UUHZp0LrglW3etB1BdhZ&new=1)