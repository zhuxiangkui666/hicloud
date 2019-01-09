# hicloud
spring cloud Finchley.SR2,集成Mybatis-plus和shardingSphere,服务注册与发现使用consul，使用servicecomb saga解决分布式事务

项目使用的postgresql数据库

使用步骤：
1.运行sql目录下的脚本创建数据库。

2.执行：consul agent -dev -ui，运行consul。

3.执行：java -Dspring.profiles.active=prd -D"spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/saga?useSSL=false" -jar alpha-server-0.3.0-exec.jar，运行saga。

4.运行hicloud-test项目。

5.运行hicloud-demo项目。

6.运行hicloud-commonservice-gateway网关。

7.访问注册中心：http://127.0.0.1:8500，查看服务运行情况，服务都正常后执行一下步骤。

8.postman发送以下post请求：Content-Type=application/json

{
	"accesstoken":"accesstoken",
	"data":{
		"userId":"1077752964146974721",
		"goods":"1081461853413617666",
		"money":"1599"
	}
}


