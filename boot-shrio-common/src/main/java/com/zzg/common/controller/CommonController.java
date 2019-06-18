package com.zzg.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzg.common.exception.FileDownloadException;


/**
 * 
 * @ClassName:  CommonController   
 * @Description: 通用文件下载
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午3:01:29   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Controller
public class CommonController {
	
	 private Logger log = LoggerFactory.getLogger(this.getClass());

	    @RequestMapping("common/download")
	    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response) throws IOException, FileDownloadException {
	        if (StringUtils.isNotBlank(fileName) && !fileName.endsWith(".xlsx") && !fileName.endsWith(".csv"))
	            throw new FileDownloadException("不支持该类型文件下载");
	        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf('_') + 1);
	        String filePath = "file/" + fileName;
	        File file = new File(filePath);
	        if (!file.exists())
	            throw new FileDownloadException("文件未找到");
	        response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(realFileName, "utf-8"));
	        response.setContentType("multipart/form-data");
	        response.setCharacterEncoding("utf-8");
	        try (InputStream inputStream = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
	            byte[] b = new byte[2048];
	            int length;
	            while ((length = inputStream.read(b)) > 0) {
	                os.write(b, 0, length);
	            }
	        } catch (Exception e) {
	            log.error("文件下载失败", e);
	        } finally {
	            if (delete)
	                Files.delete(Paths.get(filePath));
	        }
	    }

}
