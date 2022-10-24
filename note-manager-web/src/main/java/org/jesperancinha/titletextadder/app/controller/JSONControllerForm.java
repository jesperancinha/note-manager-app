package org.jesperancinha.titletextadder.app.controller;

import org.jesperancinha.titletextadder.app.model.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@Controller
@Component
public class JSONControllerForm {

    @Autowired
    private URI noteManagerApiUrlAdd;

    @Autowired
    private URI noteManagerApiUrlList;

    @RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.GET)
    public String showForm() {
        return "AddsTitle";
    }

    @RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.POST)
    public
    @ResponseBody
    String addTitle(
            @ModelAttribute(value = "title")
                    Title title,
            BindingResult result
    )
            throws URISyntaxException {

        String returnText;
        if (!result.hasErrors()) {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.postForEntity(noteManagerApiUrlAdd, title, String.class);
            returnText =
                    "You have added title: \"".
                            concat(title.getTitle()).
                            concat("\" with text: \"").
                            concat(title.getText()).
                            concat("\" and the response is").
                            concat(Objects.requireNonNull(response.getBody()));

        } else {
            returnText = "An error has ocurred, it was not possible to add your title to the database";
        }
        return returnText;
    }

    @RequestMapping(value = "/ShowTitles.htm")
    public String showTitles(ModelMap model,
                             @ModelAttribute(value = "text_filter") String textFilter
    )
            throws URISyntaxException, MalformedURLException {
        final RestTemplate restTemplate = new RestTemplate();
        if (textFilter == null || textFilter.isEmpty()) {
            textFilter = "*";
        }
        final ResponseEntity<List> response = restTemplate.getForEntity(
                new URI(noteManagerApiUrlList.getRawPath().concat(textFilter)),
                List.class);
        model.addAttribute("Titles", response.getBody());
        return "ShowTitles";
    }


    @RequestMapping(value = "/ping/{title}/alive", method = RequestMethod.GET)
    public
    @ResponseBody
    Title getTitleInJSON(@PathVariable String title) {

        Title objectTitle = new Title();
        objectTitle.setId("1");
        objectTitle.setTitle("This is an endpoint check" + title);
        objectTitle.setText("This is the expected text");
        objectTitle.setScore(1);

        return objectTitle;
    }

}
