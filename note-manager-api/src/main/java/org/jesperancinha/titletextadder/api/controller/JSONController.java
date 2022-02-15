package org.jesperancinha.titletextadder.api.controller;

import org.jesperancinha.titletextadder.api.model.TitleEntity;
import org.jesperancinha.titletextadder.api.pojo.Response;
import org.jesperancinha.titletextadder.api.service.TitleService;
import org.jesperancinha.titletextadder.api.solr.SolrSearcher;
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
    private TitleService titleService;

    @Autowired
    private SolrSearcher searcher;

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
        List<TitleEntity> titleEntities = new ArrayList<TitleEntity>();
        for (int i = 0; i < allFilteredResults.size(); ++i) {
            titleEntities.add( //
                    TitleEntity.builder() //
                            .title(allFilteredResults.get(i).get("title").toString()) //
                            .text(allFilteredResults.get(i).get("title_text").toString()) //
                            .build() //
            ); //
        }
        return titleEntities;
    }
}
