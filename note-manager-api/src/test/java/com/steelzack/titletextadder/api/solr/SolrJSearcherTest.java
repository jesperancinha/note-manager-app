package com.steelzack.titletextadder.api.solr;

import org.apache.solr.common.SolrDocumentList;
import org.jmock.Mockery;
import org.junit.Ignore;
import org.junit.Test;

public class SolrJSearcherTest {
	final Mockery context = new Mockery();

	@Test
	@Ignore
	public void testGetAllFilteredResults() throws Exception {
		final SolrJSearcher searcher = new SolrJSearcher();

		final SolrDocumentList results = searcher.getAllFilteredResults("*");
		for (int i = 0; i < results.size(); ++i) {
			System.out.println(results.get(i).get("title"));
			System.out.println(results.get(i).get("title_text"));
		}
	}

}
