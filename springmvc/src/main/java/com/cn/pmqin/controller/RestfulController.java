package com.cn.pmqin.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cn.pmqin.Model.Person;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//@Controller和@ResponseBody混合使用的简写方法
@RestController
public class RestfulController {

	// ,method = RequestMethod.POST
	@RequestMapping(value = "/greeting")
	public Person greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		RequestType request = new RequestType();
		request.access_token = "360df9e2de794f14fbd713865a1becf0";
		request.request_body = new RequestTypeBody();
		request.request_body.dbName = "tmp_mobdb";
		request.request_body.retainDays = "7";
		request.request_body.tableName = "csy_test_hive_ms";

		ResponseType result = getResponseType("http://osg.ops.ctripcorp.com/api/updateTableRetainDays", request,
				ResponseType.class);

		return new Person(JSONArray.fromObject(result).toString(), name, 1);
	}

	@RequestMapping(value = "/greeting2")
	public Person greeting2(@RequestBody Person person) {

		return new Person("person", person.getName(), 1);

	}

	private static <T> T getResponseType(String url, Object requestParams, Class<T> responseType,
			Object... uriVariables) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		// JSONArray jsonArray = JSONArray.fromObject(params);//这个是请求数组
		JSONObject jsonObj = JSONObject.fromObject(requestParams);

		HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

		return (T) restTemplate.postForObject(url, formEntity, responseType, uriVariables);
	}

}
