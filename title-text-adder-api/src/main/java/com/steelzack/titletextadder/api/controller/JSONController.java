package com.steelzack.titletextadder.api.controller;

import static com.steelzack.titletextadder.api.pojo.ResponseStatus.OK;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steelzack.titletextadder.api.dao.TitleDao;
import com.steelzack.titletextadder.api.dao.TitleDaoInterface;
import com.steelzack.titletextadder.api.model.Title;
import com.steelzack.titletextadder.api.pojo.Response;

@Controller
@RequestMapping("/tta/titles")
public class JSONController {

	@RequestMapping(headers = { "content-type=application/json" }, method = RequestMethod.POST, value = "/add")
	@ResponseBody
	public Response addTitle(@RequestBody Title title) {
		final TitleDaoInterface<Title, String> titleDao = new TitleDao();
		titleDao.persist(title);
		return new Response(OK);
	}
}
