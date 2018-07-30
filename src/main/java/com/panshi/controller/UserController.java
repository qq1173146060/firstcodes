package com.panshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.panshi.domain.Result;
import com.panshi.domain.Student;
import com.panshi.domain.User;
import com.panshi.domain.Vo;

@RestController
public class UserController {

	/**
	 * 微服务的路劲
	 */
	String url = "http://USERSERVICE/login";
	String url1 = "http://USERSERVICE/stu/query";
	String url2 = "http://USERSERVICE/stu/add";
	String url3 = "http://USERSERVICE/stu/delete";
	String url4 = "http://USERSERVICE/stu/deleteAll";
	String url5 = "http://USERSERVICE/stu/update";

	@Autowired
	RestTemplate rst;

	@RequestMapping("/login")
	
	@HystrixCommand(fallbackMethod = "rlogin")
	public Result login(User user) throws InterruptedException {
		
		Thread.sleep(10000);

		ResponseEntity<Result> postForEntity = rst.postForEntity(url, user, Result.class);

		Result body = postForEntity.getBody();

		return body;
	}
	
	public Result rlogin(User user) {
		Result r = new Result();
		r.setCode(1);
		r.setMsg("金卡戴珊萨克雷 ");
		return r;
	}
	

	@RequestMapping("/stu/query")
	public Result query(int page, int limit, String title) {

		if (title == null) {
			title = "";
		}

		Vo vo = new Vo();
		vo.setPage(page);
		vo.setLimit(limit);
		vo.setTitle(title);

		ResponseEntity<Result> postForEntity = rst.postForEntity(url1, vo, Result.class);

		Result body = postForEntity.getBody();

		return body;
	}

	@RequestMapping("/stu/add")
	public Result add(Student stu) {

		ResponseEntity<Result> postForEntity = rst.postForEntity(url2, stu, Result.class);

		Result body = postForEntity.getBody();

		return body;
	}

	@RequestMapping("/stu/delete")
	public Result delete(int id) {

		ResponseEntity<Result> postForEntity = rst.getForEntity(url4 + "?id=" + id, Result.class);

		Result body = postForEntity.getBody();

		return body;

	}

	@RequestMapping("/stu/deleteAll")
	public Result deleteAll(String id) {

		ResponseEntity<Result> postForEntity = rst.getForEntity(url4 + "?id=" + id, Result.class);

		Result body = postForEntity.getBody();

		return body;
	}

	@RequestMapping("/stu/update")
	public Result update(Student stu) {

		ResponseEntity<Result> postForEntity = rst.postForEntity(url5, stu, Result.class);

		Result body = postForEntity.getBody();

		return body;
	}

}
