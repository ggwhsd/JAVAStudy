import java.io.BufferedReader;


//判断文件中每条记录的类型
//默认为ctp日志
public class FileOp {
	

	
	private int indexRFQ;//找到ＲＦＱ下单的标志
	
	private boolean isRFQReturn;   // 是否为ＲＦＱ的回报
	
	enum FileLogType {
		CTPLOG,
		COMPACTUNITLOG

	}
	
	public String[] transFormat(String str ,BufferedReader br)
	{
		FileLogType fileType = FileLogType.CTPLOG;
		
		indexRFQ = -1;
		isRFQReturn = false;
		String[] fieldStr = str.split(" ");
		int i = 0;
		//日志文件分类
	
		
		
		//判断日志记录分类
		while(i<fieldStr.length){
			if(fieldStr[i].contains("ForQuoteSysID=\"")==true)
			{
				indexRFQ=i;
				break;
			}
			i++;
		}
		
		/**
		 * 判断是否为RFQ下单之后的最终回报状态
		 * 根据QuoteStatus状态
		 *0 全部成交
		 *1 部分成交
		 *3 未成交
		 *5 已经撤单
		 *a 未知
		 * */
		if((getIndexRFQ() != -1) && fieldStr[3].contains("callback") && fieldStr[6].contains("onRtnQuote")
				&& (fieldStr[36].contains("QuoteStatus=\'5\'")||fieldStr[36].contains("QuoteStatus=\'1\'")||fieldStr[36].contains("QuoteStatus=\'0\'")  ))
		{
			isRFQReturn = true;
		}
		
		
			
		return fieldStr;
	}
	
	public int getIndexRFQ()
	{
		return indexRFQ;
	}
	
	public boolean IsRFQReturn()
	{
		
		return isRFQReturn;
	}

}
