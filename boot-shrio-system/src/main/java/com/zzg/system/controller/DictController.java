package com.zzg.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.dao.BaseController;
import com.zzg.common.annotation.Log;
import com.zzg.common.domain.QueryRequest;
import com.zzg.common.domain.ResponseBo;
import com.zzg.common.util.FileUtil;
import com.zzg.system.domain.Dict;
import com.zzg.system.service.DictService;

@Controller
public class DictController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DictService dictService;

    @Log("获取字典信息")
    @RequestMapping("dict")
    @RequiresPermissions("dict:list")
    public String index() {
        return "system/dict/dict";
    }

    @RequestMapping("dict/list")
    @RequiresPermissions("dict:list")
    @ResponseBody
    public Map<String, Object> dictList(QueryRequest request, Dict dict) {
        return super.selectByPageNumSize(request, () -> this.dictService.findAllDicts(dict, request));
    }

    @RequestMapping("dict/excel")
    @ResponseBody
    public ResponseBo dictExcel(Dict dict) {
        try {
            List<Dict> list = this.dictService.findAllDicts(dict, null);
            return FileUtil.createExcelByPOIKit("字典表", list, Dict.class);
        } catch (Exception e) {
            log.error("导出字典信息Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("dict/csv")
    @ResponseBody
    public ResponseBo dictCsv(Dict dict) {
        try {
            List<Dict> list = this.dictService.findAllDicts(dict, null);
            return FileUtil.createCsv("字典表", list, Dict.class);
        } catch (Exception e) {
            log.error("导出字典信息Csv失败", e);
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @RequestMapping("dict/getDict")
    @ResponseBody
    public ResponseBo getDict(Long dictId) {
        try {
            Dict dict = this.dictService.findById(dictId);
            return ResponseBo.ok(dict);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return ResponseBo.error("获取字典信息失败，请联系网站管理员！");
        }
    }

    @Log("新增字典 ")
    @RequiresPermissions("dict:add")
    @RequestMapping("dict/add")
    @ResponseBody
    public ResponseBo addDict(Dict dict) {
        try {
            this.dictService.addDict(dict);
            return ResponseBo.ok("新增字典成功！");
        } catch (Exception e) {
            log.error("新增字典失败", e);
            return ResponseBo.error("新增字典失败，请联系网站管理员！");
        }
    }

    @Log("删除字典")
    @RequiresPermissions("dict:delete")
    @RequestMapping("dict/delete")
    @ResponseBody
    public ResponseBo deleteDicts(String ids) {
        try {
            this.dictService.deleteDicts(ids);
            return ResponseBo.ok("删除字典成功！");
        } catch (Exception e) {
            log.error("删除字典失败", e);
            return ResponseBo.error("删除字典失败，请联系网站管理员！");
        }
    }

    @Log("修改字典 ")
    @RequiresPermissions("dict:update")
    @RequestMapping("dict/update")
    @ResponseBody
    public ResponseBo updateDict(Dict dict) {
        try {
            this.dictService.updateDict(dict);
            return ResponseBo.ok("修改字典成功！");
        } catch (Exception e) {
            log.error("修改字典失败", e);
            return ResponseBo.error("修改字典失败，请联系网站管理员！");
        }
    }
}
