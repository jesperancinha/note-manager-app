package com.steelzack.titletextadder.api.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class SolrJSearcher {
	private HttpSolrClient solr;

	public SolrJSearcher() {
		solr = new HttpSolrClient("http://localhost:8983/solr/mysql-tta-indexing");
	}

	public SolrDocumentList getAllFilteredResults(final String filter) throws SolrServerException, IOException {
		final SolrQuery query = new SolrQuery();
		query.setQuery("title_text:*" + filter + "*");
		query.setStart(0);
		query.setRows(1000);
		query.set("defType", "edismax");

		final QueryResponse response = solr.query(query);
		return response.getResults();
	}
}