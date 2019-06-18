package com.zzg.common.domain;

import java.util.HashMap;

public class ResponseBo extends HashMap<String, Object> {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1910723090048855479L;
	
	// 成功
		private static final Integer SUCCESS = 0;
		// 警告
		private static final Integer WARN = 1;
		// 异常 失败
		private static final Integer FAIL = 500;

		public ResponseBo() {
			put("code", SUCCESS);
			put("msg", "操作成功");
		}

		public static ResponseBo error(Object msg) {
			ResponseBo responseBo = new ResponseBo();
			responseBo.put("code", FAIL);
			responseBo.put("msg", msg);
			return responseBo;
		}

		public static ResponseBo warn(Object msg) {
			ResponseBo responseBo = new ResponseBo();
			responseBo.put("code", WARN);
			responseBo.put("msg", msg);
			return responseBo;
		}

		public static ResponseBo ok(Object msg) {
			ResponseBo responseBo = new ResponseBo();
			responseBo.put("code", SUCCESS);
			responseBo.put("msg", msg);
			return responseBo;
		}

		public static ResponseBo ok() {
			return new ResponseBo();
		}

		public static ResponseBo error() {
			return ResponseBo.error("");
		}

		@Override
		public ResponseBo put(String key, Object value) {
			super.put(key, value);
			return this;
		}
	
}
