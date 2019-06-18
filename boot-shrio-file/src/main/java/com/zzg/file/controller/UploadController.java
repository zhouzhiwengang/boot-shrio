package com.zzg.file.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zzg.file.domain.Chunk;
import com.zzg.file.domain.FileInfo;
import com.zzg.file.service.ChunkService;
import com.zzg.file.service.FileInfoService;
import com.zzg.file.util.FileUtils;

/**
 * 
 * @ClassName: UploadController
 * @Description: 大文件上传管理平台
 * @author: 世纪伟图 -zzg
 * @date: 2019年6月18日 下午12:23:36
 * 
 * @Copyright: 2019 www.digipower.cn 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Controller
@RequestMapping("/uploader")
public class UploadController {
	// 日志记录
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// 文件上传目录
	@Value("${prop.upload-folder}")
	private String uploadFolder;

	@Autowired
	private FileInfoService fileInfoService;

	@Autowired
	private ChunkService chunkService;

	@PostMapping("/chunk")
	public String uploadChunk(Chunk chunk) {
		MultipartFile file = chunk.getFile();
		log.debug("file originName: {}, chunkNumber: {}", file.getOriginalFilename(), chunk.getChunkNumber());

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(FileUtils.generatePath(uploadFolder, chunk));
			// 文件写入指定路径
			Files.write(path, bytes);
			log.debug("文件 {} 写入成功, uuid:{}", chunk.getFilename(), chunk.getIdentifier());
			chunkService.save(chunk);

			return "文件上传成功";
		} catch (IOException e) {
			e.printStackTrace();
			return "后端异常...";
		}
	}

	@GetMapping("/chunk")
	public Object checkChunk(Chunk chunk, HttpServletResponse response) {

		// if (chunkService.checkChunk(chunk.getIdentifier(),
		// chunk.getChunkNumber())) {
		// response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
		// }
		Chunk obj = chunkService.findChunkDomain(chunk);
		// 判断查询对象是否为空
		if (obj == null) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
		}

		return chunk;
	}

	@PostMapping("/mergeFile")
	public String mergeFile(FileInfo fileInfo) {
		String filename = fileInfo.getFilename();
		String file = uploadFolder + "/" + fileInfo.getIdentifier() + "/" + filename;
		String folder = uploadFolder + "/" + fileInfo.getIdentifier();
		FileUtils.merge(file, folder, filename);
		fileInfo.setLocation(file);
		fileInfoService.save(fileInfo);

		return "合并成功";
	}

}
