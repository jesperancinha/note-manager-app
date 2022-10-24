package org.jesperancinha.titletextadder.api.solr;

import org.jesperancinha.titletextadder.api.config.NoteManagerAPIConfigTest;
import org.jesperancinha.titletextadder.api.config.NoteManagerElasticSearchConfigTest;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NoteManagerAPIConfigTest.class, NoteManagerElasticSearchConfigTest.class})
@Ignore
public class SolrJSearcherTest {

    @Autowired
    private SolrJSearcherImpl solrSearcher;

    @Test
    public void testSearchIsNotNull() {
        Assert.assertNotNull(solrSearcher);
    }

    @Test
    @Ignore
    public void testGetAllFilteredResults() throws Exception {
        final SolrDocumentList results = solrSearcher.getAllFilteredResults("*");
        for (org.apache.solr.common.SolrDocument result : results) {
            System.out.println(result.get("title"));
            System.out.println(result.get("title_text"));
        }
    }

}
