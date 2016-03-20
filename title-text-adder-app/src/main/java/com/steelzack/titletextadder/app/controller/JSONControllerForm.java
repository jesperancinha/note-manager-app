package com.steelzack.titletextadder.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steelzack.titletextadder.app.model.Title;

@Controller
public class JSONControllerForm {
	private List<Title> userList = new ArrayList<Title>();

	@RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.GET)
	public String showForm() {
		return "AddsTitle";
	}

	@RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.POST)
	public @ResponseBody String addTitle(@ModelAttribute(value = "title") Title title, BindingResult result) {
		String returnText;
		if (!result.hasErrors()) {
			userList.add(title);
			returnText = //
					"You have added title: \"". //
							concat(title.getTitle()). //
							concat("\" with text: \""). //
							concat(title.getText()). //
							concat("\"");
		} else {
			returnText = "An error has ocurred, it was not possible to add your title to the database";
		}
		return returnText;
	}

	@RequestMapping(value = "/ShowTitles.htm")
	public String showTitles(ModelMap model) {
		model.addAttribute("Titles", userList);
		return "ShowTitles";
	}

}
