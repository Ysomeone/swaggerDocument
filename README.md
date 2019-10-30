## 根据swagger的json数据生成pdf文档或者html文档
###  步骤
-  修改com.example.swaggerdocument.util.Swagger2Markup类中的SWAGGER_API为你项目的swagger数据返回接口
 #![Image text](./src/main/webapp/resources/images/1572406943(1).png) 
   
-  启动Swagger2Markup类生成asciidoc文档
-  使用maven插件(asciidoctor-maven-plugin插件的命令asciidoctor:process-asciidoc)生成pdf文档或者html文档
  # ![Image text](./src/main/webapp/resources/images/1572406881(1).png)
### 文档预览
  #![Image text](./src/main/webapp/resources/images/1572407065(1).png)

