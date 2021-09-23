# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

# vue的基础使用

* 测试vue.js是否有效 [示例](./src/main/resources/static/index.html)

* 基础入门声明试渲染 [示例](./src/main/resources/static/vueTest1.html)

* 基础使用：v-bind进行属性绑定，v-if进行条件判断是否显示，v-for循环标签，v-on:click事件绑定函数，v-model双向绑定。[示例](./src/main/resources/static/vueTest2.html)

* 基础使用：自定义组件和自定义组件的属性，包含循环功能的组件和非循环的组件。[示例](./src/main/resources/static/vueTest3.html)

* 基础使用：计算computed属性和方法method. [示例](./src/main/resources/static/vueTest4.html)

* 基础使用：watch回调，当绑定数据变化时会回调对应函数。结合vue声明周期的钩子created的使用。lodash限制函数调用频率，axios进行异步ajax请求。[示例](./src/main/resources/static/vueTest5.html)，配套的后台接口[示例](./src/main/java/com/studyspringcloud/controller/HelloController.java)

* 基础使用：表单。 [示例](./src/main/resources/static/vueTest6.html)

* 基础使用：使用css的class。  [示例](./src/main/resources/static/vueTestClass.html)

* 基础使用：全局和局部components。[示例](./src/main/resources/static/vueTestComponents.html)

* 基础使用： vue中的方法调用js的两个定时器。 [示例](./src/main/resources/static/vueTimer.html)

# css的基础使用

* [示例1](./src/main/resources/static/css/htmlStudy注册页面_1.html)

* [示例2](./src/main/resources/static/css/cssStudy页面案例_2.html)

* [示例3侧边栏](./src/main/resources/static/css/cssStudy侧边栏案例_3.html)

* [示例4背景图](./src/main/resources/static/css/cssStudy背景图_4.html)

* [示例5选择器](./src/main/resources/static/css/cssStudy_选择器5.html)

* [示例6五彩导航](./src/main/resources/static/css/cssHtml五彩导航_6.html)

* [示例7盒子布局和形状](./src/main/resources/static/css/cssHtml盒子布局和形状_7.html)

* [示例8浮动](./src/main/resources/static/css/cssHtml浮动_8.html)

* [示例9浮动布局](./src/main/resources/static/css/cssHtml浮动布局_9.html)

* [示例10轮播和隐藏](./src/main/resources/static/css/cssHtml轮播和隐藏_10.html)

* [示例11视频音频动画](./src/main/resources/static/css/cssHtml视频音频动画_11.html)

* [示例12奔跑的北极熊](./src/main/resources/static/css/12cssHtml奔跑的北极熊.html)

# javascript的基础使用

* 基础语法、函数、分支、对象等[示例](./src/main/resources/static/js/01demo.html)

* 内置对象time、date、string。 [示例](./src/main/resources/static/js/02内置对象.html)

* js操作DOM的Api，比如选中元素，修改元素，添加元素的clikc事件处理函数。 [示例](./src/main/resources/static/js/03webApi.html)

* 给html元素自定义属性，[示例](./src/main/resources/static/js/04自定义属性.html)

* 类似 tab的选择效果，点击到变色切换。[示例](./src/main/resources/static/js/05tab示例.html)

* 兄弟父子节点的操作，通过隐藏和显示，实现下拉菜单效果。[示例](./src/main/resources/static/js/06下拉菜单节点操作.html)

* 添加、删除元素，实现评论效果。 [示例](./src/main/resources/static/js/07评论添加节点.html)

* 添加元素同时添加事件处理函数，实现自动新增表格和行记录，删除行记录。

* 事件的三个阶段（事件流）：捕获、处理、冒泡。 事件注册的新接口（addEventListener）和旧接口（on开头）。事件处理函数匿名写法和非匿名写法。

# bootstrapTable表格组件的使用

[官网](https://examples.bootstrap-table.com/#welcome.html#view-source)
[其他使用示例](https://www.itxst.com/Bootstrap-Table/QuickStart.html)
[用的图标库](https://fontawesome.com/v5.15/icons?d=gallery&p=2)
通过https://fontawesome.com/v5.15/how-to-use/on-the-web/setup/hosting-font-awesome-yourself下载，然后根据提示把/webfonts和/css/all.css两个文件放到项目的static/assets目录下。

* 第一个示例，展示了表格的典型功能：表格列设置、请求url返回json格式数据并自动绑定到表格显示、服务器分页、客户端搜索、刷新、列显示选择、复选框、删除按钮、表格的语言环境、表格绑定相关自定义函数。[示例](.\src\main\resources\static\boostrapTable\demo1.html)。

json格式如下:
{
  "total": 800,
  "totalNotFiltered": 800,
  "rows": [
    {
      "id": 0,
      "name": "Item 0",
      "price": "$0"
    },
    {
      "id": 1,
      "name": "Item 1",
      "price": "$1"
    },
    ...
}
    

* 第二个示例，展示了如何在已有的HTML格式的表格中，使用bootstrap-Table。[示例](.\src\main\resources\static\boostrapTable\demo2_useInHtmlTable.html)

* 第三个示例，展示了如何通过单独设置json格式的data来绑定到bootstrap-table中进行刷新监视，展示如何通过按钮动态刷新变化的数据，利用定时器来展示动态刷新数据的效果。[示例](.\src\main\resources\static\boostrapTable\demo3_useDataLoad.html)

* 第四个示例，展示模态显示，即对话框弹出方式显示表格。 [示例](.\src\main\resources\static\boostrapTable\demo4_useModal.html)

* 第五个示例，展示列头的设置一个列头跨越多行或者多列。 [示例](.\src\main\resources\static\boostrapTable\demo5_useColSpan.html)

* 第六个示例，子表，即表中嵌套表。 [示例](.\src\main\resources\static\boostrapTable\demo6_useSubTable.html)

* 第七个例子，json格式除了上述以外，也支持flat json，比如如下。 [示例](.\src\main\resources\static\boostrapTable\demo7_useFlatJson.html)
'''
[
    {
        "github": {
            "name": "bootstrap-table",
            "count": {
                "stargazers": 768,
                "forks": 183
            },
            "description": "An extended Bootstrap table with radio, checkbox, sort, pagination, and other added features. (supports twitter bootstrap v2 and v3)"
        }
    },
    {
        "github": {
            "name": "multiple-select",
            "count": {
                "stargazers": 365,
                "forks": 166
            },
            "description": "A jQuery plugin to select multiple elements with checkboxes :)"
        }
    },
    {
        "github": {
            "name": "bootstrap-show-password",
            "count": {
                "stargazers": 37,
                "forks": 13
            },
            "description": "Show/hide password plugin for twitter bootstrap."
        }
    }
]
'''

* 最后一个例子，展示事件单击单元格事件绑定，单元格根据内容变换颜色，修改单元格值。 

