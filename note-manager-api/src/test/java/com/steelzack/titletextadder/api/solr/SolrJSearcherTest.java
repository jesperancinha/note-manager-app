package com.steelzack.titletextadder.api.solr;

import com.steelzack.titletextadder.api.config.NoteManagerAPIConfig;
import org.apache.solr.common.SolrDocumentList;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NoteManagerAPIConfig.class})
@Ignore
public class SolrJSearcherTest {
    final Mockery context = new Mockery();

    @Autowired
    private SolrSearcher searcher;

    @Test
    public void testSearchIsNotNull() {
        Assert.assertNotNull(searcher);
    }

    @Test
    @Ignore
    public void testGetAllFilteredResults() throws Exception {
        final SolrDocumentList results = searcher.getAllFilteredResults("*");
        for (int i = 0; i < results.size(); ++i) {
            System.out.println(results.get(i).get("title"));
            System.out.println(results.get(i).get("title_text"));
        }
    }

}
