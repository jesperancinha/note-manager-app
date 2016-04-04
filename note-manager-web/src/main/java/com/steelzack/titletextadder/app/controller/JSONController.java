package com.steelzack.titletextadder.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steelzack.titletextadder.app.model.Title;

@Controller
@RequestMapping("/tta/titles")
public class JSONController {
	@RequestMapping(value = "{title}", method = RequestMethod.GET)
	public @ResponseBody Title getTitleInJSON(@PathVariable String title) {

		Title objectTitle = new Title();
		objectTitle.setId("1");
		objectTitle.setTitle("This is an endpoint check" + title);
		objectTitle.setText("This is the expected text");
		objectTitle.setScore(1);

		return objectTitle;
	}
}
