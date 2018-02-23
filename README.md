springCloud包含以下模块：
    1、eureka        服务注册中心
    2、zuul          网关路由

    3、intergration  基础服务
    4、user          用户服务
    5、account       开户服务
    6、borrow        借款服务
    7、telecom       运营商服务
    8、merchant      商户服务

    9、common-util   公共类
    10、fiter        打包配置


其中3-8(springCloudApp)服务是常见的springboot+mybatis+driud工程
此后只维护这个模块即可，所有业务逻辑代码均再此编写

打包命令 mvn clean package -Dmaven.test.skip=true -Pdev
运行命令 java -jar xxxx.jar --server.port=8081  加上jvm调优
启动顺序：
    eureka->intergration->merchant->user,account,borrow,telecom->zuul
注意：
    其中任何一个服务断掉之后，如果zuul的自动发现失效，就得重启zuul
部署结构网：
    eureka、zuul可以放在同一台机器上，也可以集群处理
    intergration X2放一台
    merchant X2放一台
    user X2放一台
    account X2放一台
    borrow X2放一台
    telecom X2放一台

    一共需要7台服务器(看业务需要，也可以2台即可)