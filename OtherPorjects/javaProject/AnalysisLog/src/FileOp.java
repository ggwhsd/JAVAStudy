import java.io.BufferedReader;


//�ж��ļ���ÿ����¼������
//Ĭ��Ϊctp��־
public class FileOp {
	

	
	private int indexRFQ;//�ҵ��ңƣ��µ��ı�־
	
	private boolean isRFQReturn;   // �Ƿ�Ϊ�ңƣѵĻر�
	
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
		//��־�ļ�����
	
		
		
		//�ж���־��¼����
		while(i<fieldStr.length){
			if(fieldStr[i].contains("ForQuoteSysID=\"")==true)
			{
				indexRFQ=i;
				break;
			}
			i++;
		}
		
		/**
		 * �ж��Ƿ�ΪRFQ�µ�֮������ջر�״̬
		 * ����QuoteStatus״̬
		 *0 ȫ���ɽ�
		 *1 ���ֳɽ�
		 *3 δ�ɽ�
		 *5 �Ѿ�����
		 *a δ֪
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
