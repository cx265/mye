package cap.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class FilesUploadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String execute() throws Exception {

		InputStream is = null;
		OutputStream ops = null;
		for (int i = 0; i < file.size(); i++) {
			try {
				is = new FileInputStream(file.get(i));
				String root = "F:";
				File destFile = new File(root + "\\", this.getFileFileName()
						.get(i));
				ops = new FileOutputStream(destFile);
				byte[] b = new byte[400];
				int length = 0;
				while ((length = is.read(b)) > 0) {
					ops.write(b, 0, length);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				is.close();
				ops.close();
			}
		}
		return SUCCESS;
	}

}
