package cn.emay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.emay.eucp.inter.http.v1.dto.response.BalanceResponse;
import cn.emay.eucp.inter.http.v1.dto.response.MoResponse;
import cn.emay.eucp.inter.http.v1.dto.response.ReportResponse;
import cn.emay.eucp.inter.http.v1.dto.response.ResponseData;
import cn.emay.eucp.inter.http.v1.dto.response.SmsResponse;
import cn.emay.util.DateUtil;
import cn.emay.util.JsonHelper;
import cn.emay.util.Md5;
import cn.emay.util.http.HttpClient;
import cn.emay.util.http.HttpRequest;
import cn.emay.util.http.HttpRequestKV;
import cn.emay.util.http.HttpRequestParams;
import cn.emay.util.http.HttpResponseString;
import cn.emay.util.http.HttpResponseStringPraser;
import cn.emay.util.http.HttpResultCode;
import cn.emay.util.http.HttpsRequestKV;

import com.google.gson.reflect.TypeToken;

public class SimpleExample {

	public static void main(String[] args) {

		// appId
		String appId = "EUCP-EMY-SMS0-11111";// 请联系销售，或者在页面中 获取
		// 密钥
		String secretKey = "1231231231";// 请联系销售，或者在页面中 获取
		// 接口地址
		String host = "http://emay.com";// 请联系销售获取
		// 时间戳
		String timestamp = DateUtil.toString(new Date(), "yyyyMMddHHmmss");
		// 签名
		String sign = Md5.md5((appId + secretKey + timestamp).getBytes());
		// 获取余额
		getBalance(appId, sign, timestamp, host);
		// 获取状态报告
		getReport(appId, sign, timestamp, host);
		// 获取上行
		getMo(appId, sign, timestamp, host);
		// 发送批次短信,定时时间格式yyyyMMddHHmmss
		setSms(appId, sign, timestamp, host, "【某某公司】你好今天天气不错，挺风和日丽的&1=D$", "12100000000", "839273940", null, "20170506120000");// 如果通道已绑定签名，可以去掉【某某公司】
		// 发送个性短信
		Map<String, String> mobileAndContents = new HashMap<String, String>();
		mobileAndContents.put("12100000000", "【某某公司】天气不错啊1&32");
		mobileAndContents.put("12100000001", "【某某公司】天气不错啊1&31");
		mobileAndContents.put("12100000002", "【某某公司】天气不错啊1&30");
		setPersonalitySms(appId, sign, timestamp, host, mobileAndContents, "83927391", "012", null);// 如果通道已绑定签名，可以去掉【某某公司】
	}

	/**
	 * 获取余额
	 */
	private static void getBalance(String appId, String sign, String timestamp, String host) {
		System.out.println("=============begin getBalance==================");
		Map<String, String> params = new HashMap<String, String>();
		params.put("appId", appId);
		params.put("sign", sign);
		params.put("timestamp", timestamp);
		String json = request(params, host + "/simpleinter/getBalance");
		if (json != null) {
			ResponseData<BalanceResponse> data = JsonHelper.fromJson(new TypeToken<ResponseData<BalanceResponse>>() {
			}, json);
			String code = data.getCode();
			if ("SUCCESS".equals(code)) {
				System.out.println("result data : " + data.getData().getBalance());
			}
		}
		System.out.println("=============end getBalance==================");
	}

	/**
	 * 获取状态报告
	 */
	private static void getReport(String appId, String sign, String timestamp, String host) {
		System.out.println("=============begin getReport==================");
		Map<String, String> params = new HashMap<String, String>();
		params.put("appId", appId);
		params.put("sign", sign);
		params.put("timestamp", timestamp);
		params.put("number", "500");
		String json = request(params, host + "/simpleinter/getReport");
		if (json != null) {
			ResponseData<ReportResponse[]> data = JsonHelper.fromJson(new TypeToken<ResponseData<ReportResponse[]>>() {
			}, json);
			String code = data.getCode();
			if ("SUCCESS".equals(code)) {
				for (ReportResponse d : data.getData()) {
					System.out.println("result data : " + d.getMobile() + "," + d.getExtendedCode() + "," + d.getMobile() + "," + d.getCustomSmsId() + "," + d.getSmsId() + "," + d.getState() + ","
							+ d.getDesc() + "," + d.getSubmitTime() + "," + d.getReceiveTime());
				}
			}
		}
		System.out.println("=============end getReport==================");
	}

	/**
	 * 获取上行
	 */
	private static void getMo(String appId, String sign, String timestamp, String host) {
		System.out.println("=============begin getMo==================");
		Map<String, String> params = new HashMap<String, String>();
		params.put("appId", appId);
		params.put("sign", sign);
		params.put("timestamp", timestamp);
		params.put("number", "500");
		String json = request(params, host + "/simpleinter/getMo");
		if (json != null) {
			ResponseData<MoResponse[]> data = JsonHelper.fromJson(new TypeToken<ResponseData<MoResponse[]>>() {
			}, json);
			String code = data.getCode();
			if ("SUCCESS".equals(code)) {
				for (MoResponse d : data.getData()) {
					System.out.println("result data:" + d.getMobile() + "," + d.getExtendedCode() + "," + d.getMobile() + "," + d.getMoTime());
				}
			}
		}
		System.out.println("=============end getMo==================");
	}

	/**
	 * 发送批次短信
	 */
	private static void setSms(String appId, String sign, String timestamp, String host, String content, String mobiles, String customSmsId, String extendedCode, String timerTime) {
		System.out.println("============= setSms==================");
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("appId", appId);
			params.put("sign", sign);
			params.put("timestamp", timestamp);
			params.put("mobiles", mobiles);
			params.put("content", URLEncoder.encode(content, "utf-8"));
			if (customSmsId != null) {
				params.put("customSmsId", customSmsId);
			}
			if (timerTime != null) {
				params.put("timerTime", timerTime);
			}
			if (extendedCode != null) {
				params.put("extendedCode", extendedCode);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String json = request(params, host + "/simpleinter/sendSMS");
		if (json != null) {
			ResponseData<SmsResponse[]> data = JsonHelper.fromJson(new TypeToken<ResponseData<SmsResponse[]>>() {
			}, json);
			String code = data.getCode();
			if ("SUCCESS".equals(code)) {
				for (SmsResponse d : data.getData()) {
					System.out.println("data:" + d.getMobile() + "," + d.getSmsId() + "," + d.getCustomSmsId());
				}
			}
		}
		System.out.println("=============end setSms==================");
	}

	/**
	 * 发送个性短信
	 */
	private static void setPersonalitySms(String appId, String sign, String timestamp, String host, Map<String, String> mobileAndContents, String customSmsId, String extendedCode, String timerTime) {
		System.out.println("=============setPersonalitySms ==================");
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("appId", appId);
			params.put("sign", sign);
			params.put("timestamp", timestamp);
			for (String mobile : mobileAndContents.keySet()) {
				params.put(mobile, URLEncoder.encode(mobileAndContents.get(mobile), "utf-8"));
			}
			if (customSmsId != null) {
				params.put("customSmsId", customSmsId);
			}
			if (timerTime != null) {
				params.put("timerTime", timerTime);
			}
			if (extendedCode != null) {
				params.put("extendedCode", extendedCode);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String json = request(params, host + "/simpleinter/sendPersonalitySMS");
		if (json != null) {
			ResponseData<SmsResponse[]> data = JsonHelper.fromJson(new TypeToken<ResponseData<SmsResponse[]>>() {
			}, json);
			String code = data.getCode();
			if ("SUCCESS".equals(code)) {
				for (SmsResponse d : data.getData()) {
					System.out.println("data:" + d.getMobile() + "," + d.getSmsId() + "," + d.getCustomSmsId());
				}
			}
		}
		System.out.println("=============end setPersonalitySms==================");
	}

	/**
	 * 公共请求方法
	 */
	public static String request(Map<String, String> params, String url) {
		HttpRequestParams<Map<String, String>> requestparams = new HttpRequestParams<Map<String, String>>();
		requestparams.setCharSet("UTF-8");
		requestparams.setMethod("POST");
		requestparams.setParams(params);
		requestparams.setUrl(url);
		HttpRequest<Map<String, String>> request;
		if (url.startsWith("https://")) {
			request = new HttpsRequestKV(requestparams, null);
		} else {
			request = new HttpRequestKV(requestparams);
		}
		HttpClient client = new HttpClient();
		String json = null;
		try {
			String mapst = "";
			for (String key : params.keySet()) {
				String value = params.get(key);
				mapst += key + "=" + value + "&";
			}
			mapst = mapst.substring(0, mapst.length() - 1);
			System.out.println("request params: " + mapst);
			HttpResponseString res = client.service(request, new HttpResponseStringPraser());
			if (res == null) {
				System.err.println("请求接口异常");
				return null;
			}
			if (res.getResultCode().equals(HttpResultCode.SUCCESS)) {
				if (res.getHttpCode() == 200) {
					json = res.getResult();
					System.out.println("response json: " + json);
				} else {
					System.out.println("请求接口异常,请求码:" + res.getHttpCode());
				}
			} else {
				System.out.println("请求接口网络异常:" + res.getResultCode().getCode());
			}
		} catch (Exception e) {
			System.err.println("解析失败");
			e.printStackTrace();
		}
		return json;
	}

}
