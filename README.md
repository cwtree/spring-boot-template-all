# spring-boot-template-all
包括从dao到manager到service到controller的一个完整实例  
包括完整的dao单元测试，manager单元测试，service单元测试  

## 打包
加入maven assembly plugin
打包出来是个tgz
舍弃springboot的maven jar plugin，因为会把依赖jar打入springboot的jar中，导致jar包很大，不利于快速传输部署

## 解压后的目录结构
bin  
config  
lib  
static  
templates  
springboot_ditty.jar  

