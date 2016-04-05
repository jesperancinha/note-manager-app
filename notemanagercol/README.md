# Note Manager Solr Collection

## Description

This is an example collection.

You can just create a collection of the same name and replace the files created with these ones.

## Solr Build

```
$ solr start
$ solr create -c notemanagercol -d basic_configs
```
> URL access to fully import data
* http://localhost:8983/solr/#/notemanagercol/dataimport?command=full-import

> Replacement
* Make sure you have the mysql library in your lib folder and also all the solr libraries:

```
./notemanagercol/lib/mysql-connector-java-5.1.32-bin.jar
./notemanagercol/lib/solr-analysis-extras-5.5.0.jar
./notemanagercol/lib/solr-analytics-5.5.0.jar
./notemanagercol/lib/solr-cell-5.5.0.jar
./notemanagercol/lib/solr-clustering-5.5.0.jar
./notemanagercol/lib/solr-core-5.5.0.jar
./notemanagercol/lib/solr-dataimporthandler-5.5.0.jar
./notemanagercol/lib/solr-dataimporthandler-extras-5.5.0.jar
./notemanagercol/lib/solr-langid-5.5.0.jar
./notemanagercol/lib/solr-map-reduce-5.5.0.jar
./notemanagercol/lib/solr-morphlines-cell-5.5.0.jar
./notemanagercol/lib/solr-morphlines-core-5.5.0.jar
./notemanagercol/lib/solr-solrj-5.5.0.jar
./notemanagercol/lib/solr-test-framework-5.5.0.jar
./notemanagercol/lib/solr-uima-5.5.0.jar
./notemanagercol/lib/solr-velocity-5.5.0.jar
./notemanagercol/lib/solrj-lib/commons-io-2.4.jar
./notemanagercol/lib/solrj-lib/httpclient-4.4.1.jar
./notemanagercol/lib/solrj-lib/httpcore-4.4.1.jar
./notemanagercol/lib/solrj-lib/httpmime-4.4.1.jar
./notemanagercol/lib/solrj-lib/jcl-over-slf4j-1.7.7.jar
./notemanagercol/lib/solrj-lib/noggit-0.6.jar
./notemanagercol/lib/solrj-lib/slf4j-api-1.7.7.jar
./notemanagercol/lib/solrj-lib/stax2-api-3.1.4.jar
./notemanagercol/lib/solrj-lib/woodstox-core-asl-4.4.1.jar
./notemanagercol/lib/solrj-lib/zookeeper-3.4.6.jar
./notemanagercol/lib/test-framework/lib/ant-1.8.2.jar
./notemanagercol/lib/test-framework/lib/junit-4.10.jar
./notemanagercol/lib/test-framework/lib/junit4-ant-2.3.2.jar
./notemanagercol/lib/test-framework/lib/randomizedtesting-runner-2.3.2.jar
./notemanagercol/lib/test-framework/lucene-libs/lucene-test-framework-5.5.0.jar
```

## Special Reads
* https://gist.github.com/maxivak/3e3ee1fca32f3949f052