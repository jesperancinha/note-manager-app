package com.steelzack.titletextadder.api.controller;

import com.steelzack.titletextadder.api.model.Title;
import com.steelzack.titletextadder.api.pojo.Response;
import com.steelzack.titletextadder.api.service.TitleService;
import com.steelzack.titletextadder.api.solr.SolrSearcher;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.steelzack.titletextadder.api.pojo.ResponseStatus.OK;

@Controller
@RequestMapping("/tta/titles")
public class JSONController {

	@Autowired
	private TitleService titleService;

	@Autowired
	private SolrSearcher searcher;

	@RequestMapping(headers = { "content-type=application/json" }, method = RequestMethod.POST, value = "/add")
	@ResponseBody
	public Response addTitle(@RequestBody Title title) throws URISyntaxException {
		titleService.persist(title);
		searcher.refreshCollection();
		return new Response(OK);
	}

	@RequestMapping(value = "/list/{filter}", method = RequestMethod.GET)
	public @ResponseBody List<Title> getTitleInJSON(@PathVariable String filter)
			throws SolrServerException, IOException {
		final SolrDocumentList allFilteredResults = searcher.getAllFilteredResults(filter);
		List<Title> titles = new ArrayList<Title>();
		for (int i = 0; i < allFilteredResults.size(); ++i) {
			titles.add( //
					new Title( //
							allFilteredResults.get(i).get("title").toString(), //
							allFilteredResults.get(i).get("title_text").toString()) //
			);
		}
		return titles;
	}
}
