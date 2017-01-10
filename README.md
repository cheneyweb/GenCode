# GenCode
框架简介
>
	这是一个超简单好用的，云端在线代码生成器；
	目前支持Javaweb代码生成，一键生成Service,Dao,Entity等等，快来试试吧，编码效率会空前提高呢~；
	未来还会拓展PHP，JavaScript，HTML，SQL，Android，IOS，XML等等众多语言代码的一键生成，GenCode的目标是——最懒程序员！

解析引擎层次
>
	com.cheney.gencode.enums:					通用枚举
>
	com.cheney.gencode.gen.html:				HTML代码生成
>
	com.cheney.gencode.gen.java:				Java代码生成
	com.cheney.gencode.gen.java.comment:		Java注释生成
	com.cheney.gencode.gen.java.common:         Java通用代码生成
	com.cheney.gencode.gen.java.module: 		Java代码模块
>
	com.cheney.gencode.gen.javascript:			JavaScript代码生成
	com.cheney.gencode.gen.linuxbash:			LinuxBash代码生成
	com.cheney.gencode.gen.regex:				正则表达式代码生成
	com.cheney.gencode.gen.sql:					SQL代码生成
>	
	com.cheney.gencode.module:					模块的实体
>	
	com.cheney.gencode.util.db:					数据库操作工具
	com.cheney.gencode.util.file:				文件操作工具
	com.cheney.gencode.util.string:				字符串操作工具
	com.cheney.gencode.util.xml:				XML操作操作工具

前端结构
>
	resources/static/
		custom(自定义前端文件)
		frame（前端框架文件）
		html（生成器前端文件）
	resources/templates/
		code(生成代码模板文件)
		layout（VM基础布局文件）

注意事项
>
	使用帮助联系：457299596@qq.com (希望大家也能踊跃地给我提意见，包括你们希望生成的代码类别等等，这个项目坚持下去，是会方便大家的~~)
	
更新记录
>
	2017.1.6:由SpringMVC改为SpringBoot，前端使用Vue解耦，花了一个月的时间推倒重构，但是这也是一个学习的过程
	2017.1.9:开始采用模板生成代码，后续将逐步取代原先的字符串拼接