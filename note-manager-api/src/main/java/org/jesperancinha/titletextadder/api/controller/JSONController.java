package org.jesperancinha.titletextadder.api.controller;

import org.jesperancinha.titletextadder.api.model.TitleEntity;
import org.jesperancinha.titletextadder.api.pojo.Response;
import org.jesperancinha.titletextadder.api.service.TitleServiceImpl;
import org.jesperancinha.titletextadder.api.solr.SolrJSearcherImpl;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.jesperancinha.titletextadder.api.pojo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tta/titles")
public class JSONController {

    @Autowired
    private TitleServiceImpl titleService;

    @Autowired
    private SolrJSearcherImpl searcher;

    @RequestMapping(headers = {"content-type=application/json"}, method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public Response addTitle(@RequestBody
                             TitleEntity titleEntity) throws URISyntaxException {
        titleService.persist(titleEntity);
        searcher.refreshCollection();
        return new Response(ResponseStatus.OK);
    }

    @RequestMapping(value = "/list/{filter}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TitleEntity> getTitleInJSON(@PathVariable String filter)
            throws SolrServerException, IOException {
        final SolrDocumentList allFilteredResults = searcher.getAllFilteredResults(filter);
        var titleEntities = new ArrayList<TitleEntity>();
        for (org.apache.solr.common.SolrDocument allFilteredResult : allFilteredResults) {
            titleEntities.add(
                    TitleEntity.builder()
                            .title(allFilteredResult.get("title").toString())
                            .text(allFilteredResult.get("title_text").toString())
                            .build()
            );
        }
        return titleEntities;
    }
}
