# spring-boot-template-all
The template including many examples in spring boot,like mybatis,redis,mail and so on.

加入maven assembly plugin
打包出来是个tgz
tgz解压后直接运行start.sh/start.bat即可运行
舍弃springboot的maven jar plugin，因为会把依赖jar打入springboot的jar中，导致jar包很大，不利于快速传输部署
所以将依赖拿出来放在lib下，配置放在config下，一些配置文件在resources下

springboot
  src
  bin
  config
  resources
