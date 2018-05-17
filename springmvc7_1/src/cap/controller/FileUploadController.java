package cap.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam MultipartFile[] files,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<String> filename = new ArrayList<String>();
		for (MultipartFile multipartFile : files) {
			if (multipartFile.isEmpty()) {
				System.out.println("文件没有上传");
			} else {
				System.out.println("长度：" + multipartFile.getSize());
				System.out.println("类型：" + multipartFile.getContentType());
				System.out.println("名称：" + multipartFile.getName());
				System.out.println("原名：" + multipartFile.getOriginalFilename());
				//String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				String realPath = "d://upload//";
				filename.add(multipartFile.getOriginalFilename());
				System.out.println("路径：" + realPath);
				try {
					FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(realPath,multipartFile.getOriginalFilename()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		mv.addObject("files",filename);
		mv.setViewName("success");
		return mv;
	}
}
