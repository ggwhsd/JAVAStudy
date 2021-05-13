package AnnotationStudy;


@Description("如何使用自定义的注解")
public class CaseJava {
	@Name(originate = "gugw", community = "获取key")
	public String getKey()
	{
		return "Key";
	}
	@Name(originate = "gugw", community = "获取value")
	public String getValue()
	{
		return "value";
	}
}
