package com.zzg.common.handler;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * 
 * @ClassName:  ExportHandler   
 * @Description: excel 导出接口  
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 上午11:28:15   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public interface ExportHandler {
	/**
	 * 设置表头样式
	 * 
	 * @param wb
	 *            当前Wordbook对象
	 * @return 处理后的样式
	 */
	CellStyle headCellStyle(SXSSFWorkbook wb);

	/**
	 * 设置导出的文件名（无需处理后缀）
	 * 
	 * @param sheetName
	 *            sheetName
	 * @return 处理后的文件名
	 */
	String exportFileName(String sheetName);
}
