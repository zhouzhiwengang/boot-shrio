package com.zzg.common.exception;

/**
 * 
 * @ClassName:  FileDownloadException   
 * @Description: 通用文件下载异常
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午3:05:58   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class FileDownloadException  extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    public FileDownloadException(String message) {
        super(message);
    }
}