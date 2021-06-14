import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


//��־��ȡ�͵���
public class Analysis {

	public void Deal(String dataFilePath,String outFilePath) {
		FileOp fop = new FileOp();
		String [] fields = null;
		try {
			String pathname = dataFilePath;
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			File writename = new File(outFilePath);
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			String line = "";
			line = br.readLine();
			int flush_count = 500;
			int i = 0;
			while (line != null) {
				flush_count--;
				
				fields = fop.transFormat(line, br);
				if (fop.IsRFQReturn())
					out.write(line+"\r\n"); // \r\n��Ϊ����

				if (flush_count == 0) {
					i++;
					out.flush();
					flush_count = 500;
				}
				line = br.readLine();
			}
			out.flush(); // �ѻ���������ѹ���ļ�
			out.close(); // ���ǵùر��ļ�
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
