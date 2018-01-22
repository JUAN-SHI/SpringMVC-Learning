# SpringMVC学习整理笔记
------------------------------
## SpringMVC概述
[(完整例:SpringMVC-Learning/HelloWeb](https://github.com/JUAN-SHI/SpringMVC-Learning.git))
- Spring web MVC框架提供了MVC(模型 - 视图 - 控制器)架构和用于开发灵活和松散耦合的Web应用程序的组件。 MVC模式导致应用程序的不同方面(输入逻辑，业务逻辑和UI逻辑)分离，同时提供这些元素之间的松散耦合
- 模型（Model）封装了应用程序的数据，通常它们将由POJO类组成。
- 视图（VIEW）负责渲染模型数据，一般来说它生成客户端浏览器可以解释HTML输出。
- 控制器（Controller）负责处理用户请求并构建适当的模型，并将其传递给视图进行渲染。
### DispatcherServlet组件类
- Spring Web模型-视图-控制器（MVC）框架是围绕DispatcherServlet设计的，它处理所有的HTTP请求和响应。
- 以下是对应于到DispacherSerlvet的传入HTTP请求的事件顺序：
1. 在接收到HTTP请求后，DispatcherServlet会查询HandlerMapping 以调用相应的Controller。
2. Controller 接受请求并根据使用的GET或POST方法调用相应的服务方法。 服务方法将基于定义的业务逻辑设置模型数据，并将视图名称返回给DispatcherServlet。
3. DispatcherServlet将从ViewResolver获取请求的定义视图。
4. 当视图完成，DispatcherServlet将模型数据传递到最终的视图，并在浏览器上呈现。

### 必需的配置
([示例:SpringMVC-Learning/HelloWeb](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/HelloWeb))
- 需要通过使用web.xml文件中的URL映射希望DispatcherServlet处理的请求。web.xml文件将保存web应用程序的WebContent/WEB-INF目录，在项目DispatcherServlet初始化时，框架将尝试从位于应用程序的WebContent/WEB-INF目录中的名为[servlet-name]-servlet.xml的文件加载应用程序上下文。

- 如果不想使用默认文件名为[servlet-name]-servlet.xml和默认位置为WebContent/WEB-INF，可以通过在web.xml文件中添加servlet侦听器ContextLoaderListener来自定义此文件名和位置,如下:
```
<web-app...>

<!-------- DispatcherServlet definition goes here----->
....
<context-param>
   <param-name>contextConfigLocation</param-name>
   <param-value>/WEB-INF/HelloWeb-servlet.xml</param-value>
</context-param>

<listener>
   <listener-class>
      org.springframework.web.context.ContextLoaderListener
   </listener-class>
</listener>
</web-app>

***HelloWeb-servlet.xml文件的重点说明***

[servlet-name]-servlet.xml文件将用于创建定义的bean，它会覆盖在全局范围中使用相同名称定义的任何bean的定义。

<context：component-scan ...>标签将用于激活Spring MVC注释扫描功能，允许使用@Controller和@RequestMapping等注释。

InternalResourceViewResolver将定义用于解析视图名称的规则。根据上面定义的规则，hello的逻辑视图将委托给位于/WEB-INF/jsp/hello.jsp这个视图来实现

------------------------------------------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/hello")
public class HelloController{

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");

        return "hello";
    }

value属性指示处理程序方法映射到的URL，method属性定义处理HTTP GET请求的服务方法。关于以上定义的控制器，需要注意以下几点：
在服务方法中定义所需的业务逻辑。可以根据需要在此方法内调用其他方法。
基于定义的业务逻辑，将在此方法中创建一个模型。可以设置不同的模型属性，这些属性将被视图访问以呈现最终结果。此示例创建且有属性“message”的模型。
定义的服务方法可以返回一个String，它包含要用于渲染模型的视图的名称。此示例将“hello”返回为逻辑视图名称。
--------------------------------------------------------------------------------------------------------------------------------------
```
## 表单处理
### Spring MVC表单处理
([表单处理:SpringMVC-Learning/FormHandling](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/FormHandling))
```
@RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
   }
 这里的第一个服务方法student()，我们已经在ModelAndView对象中传递了一个名为“command”的空对象，因为如果在JSP中使用<form：form>标签，spring框架需要一个名为“command”的对象文件。 所以当调用student()方法时，它返回student.jsp视图 
```
### Spring mvc静态页面
([静态页面:SpringMVC-Learning/StaticPage](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/StaticPage))
- 这里使用<mvc:resources ..../>标记来映射静态页面
```
  <!-- 自动注册组件 -->
             <mvc:annotation-driven/>

             <!-- 通过扫描将带有@Controller注解的类交由spring容器管理并维护 -->
             <context:component-scan base-package="com.www"/>

           <!-- 配置视图解析器 如果不配置ViewResolver,Spring MVC默认使用org.springframework.web.servlet.view.InternalResourceViewResolver作为
     ViewResolver,而且prefix和suffix都为空 -->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
         <property name="prefix" value="/WEB-INF/jsp/"></property>
         <property name="suffix" value=".jsp"></property>

    </bean>

            <!-- 访问静态资源 -->
            <mvc:resources  mapping="/pages/**" location="/WEB-INF/pages/"/>
```
### 页面重定向
([重定向:SpringMVC-Learning/PageRedirection](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/PageRedirection))
## 表单标签库
([标签库:SpringMVC-Learning/TextBox](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/TextBox))
- 使用<form:textarea />标签来呈现HTML文本域
- 使用<form:checkbox />标签来呈现HTML复选框  ||   <form:checkboxes />标签来呈现HTML多个复选框
- 使用<form:radiobutton />标签来呈现HTML单选按钮  ||  使用<form:radiobuttons />标签来呈现多项单选按钮
- 使用<form:select /> , <form:option /> 和 <form:options />标签来呈现HTML下拉选项
- 使用<form:select /> 及其属性 multiple=true标签来呈现HTML列表多选框
- 使用<form:hidden />标签来呈现HTML隐藏字段域

## 控制器
([控制器相关配置:SpringMVC-Learning/ControllerClassNameHandlerMapping](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/ControllerClassNameHandlerMapping))

- 相关配置
``` <!-- springmvc多动作控制器-->
    <!--<bean-->
            <!--class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>-->
            <!---->

    <!--<bean name="/helloWorld*" claHelloControllerller"/>-->
    <!--<bean name="/welcome.htm" claWelcomeControllerller"/>-->


    <!--<bean name="/home.html" claUserControllerller"></bean>-->
    <!--<bean name="/user/*.html" claUserControllerller"> </bean>-->
    <!---->


    <!-- Spring MVC 属性方法名称解析器 -->
    <!--<bean class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping">-->
        <!--<property name="caseSensitive" value="true" />-->
    <!--</bean>-->
    <!--<bean claUserControllerller">-->
        <!--<property name="methodNameResolver">-->
            <!--<bean class="org.springframework.web.servlet.mvc.multiaction.PropertiesMethodNameResolver">-->
            <!--<property name="mappings">-->
                <!--<props>-->
                    <!--<prop key="/user/home.html">home</prop>-->
                    <!--<prop key="/user/add.html">add</prop>-->
                    <!--<prop key="/user/remove.html">remove</prop>-->
                <!--</props>-->
            <!--</property>-->
            <!--</bean>-->
        <!--</property>-->
    <!--</bean>-->

    <!-- Spring MVC 参数方法名称解析器 请求URL=http://localhost:8080/user?action=xxx(home) -->
    <!--<bean class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping">-->
        <!--<property name="caseSensitive" value="true" />-->
    <!--</bean>-->
    <!--<bean claUserControllerller">-->
        <!--<property name="methodNameResolver">-->
            <!--<bean class="org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver">-->
                <!--<property name="paramName" value="action"/>-->
            <!--</bean>-->
        <!--</property>-->
    <!--</bean>-->


    <!--Spring MVC可参数化的视图控制器-->
    <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
        <property name="mappings">
            <value>
                index.html=userController
            </value>
        </property>
    </bean>
    <bean id="userController" class="org.springframework.web.servlet.mvc.ParameterizableViewController">
        <property name="viewName" value="index"/>
    </bean>

```
## 视图解析器
([视图解析器相关配置:SpringMVC-Learning/MultipleResolver](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/MultipleResolver))
```
<bean class="org.springframework.web.servlet.view.ResourceBundleViewResolver">
   <property name="basename" value="views" />
   <property name="order" value="0" />
</bean>
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
   <property name="prefix" value="/WEB-INF/jsp/" />
   <property name="suffix" value=".jsp" />
   <property name="order" value="1" />
</bean>
order属性定义了视图解析器的排序。0作为第一解析器，1作为下一解析器
```
## 集成
([集成XML:SpringMVC-Learning/GenerateXML](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/GenerateXML))
([集成Json:SpringMVC-Learning/GenerateJson](https://github.com/JUAN-SHI/SpringMVC-Learning/tree/master/GenerateJson)
