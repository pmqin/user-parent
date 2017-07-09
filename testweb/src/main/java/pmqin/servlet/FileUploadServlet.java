package pmqin.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/servlet/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/** http://haohaoxuexi.iteye.com/blog/2013691
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Part part = req.getPart("upload");
		// 格式如：form-data; name="upload"; filename="YNote.exe"
		String disposition = part.getHeader("content-disposition");
		System.out.println(disposition);
		String fileName = disposition.substring(disposition.lastIndexOf("=") + 2, disposition.length() - 1);
		String fileType = part.getContentType();
		long fileSize = part.getSize();
		System.out.println("fileName: " + fileName);
		System.out.println("fileType: " + fileType);
		System.out.println("fileSize: " + fileSize);
		//路径必须先创建在根目录下面/upload
		String uploadPath = req.getServletContext().getRealPath("/upload");
		System.out.println("uploadPath" + uploadPath);
		part.write(uploadPath + File.separator + fileName);
	}

}
