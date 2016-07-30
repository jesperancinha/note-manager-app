# Note Manager REST API


## You must have docker running or a postgres database running locally  on port 5432.

```
$ docker run --rm -P -p 5432:5432 --name pg_test eg_postgresql
```

## Usefull deploy commads
* mvn tomcat7:deploy
* mvn tomcat7:undeploy
* mvn tomcat7:redeploy
* mvn tomcat7:run

## Usefull test commands
* Should not work: curl -H "Content-Type: application/json" -X POST http://localhost:8080/note-manager-api/rest/tta/titleEntities/add -d '{ "titleEntity":"titleEntity"}'
* Should work: curl -H "Content-Type: application/json" -X POST http://localhost:8080/note-manager-api/rest/tta/titleEntities/add -d '{ "titleEntity":"titleEntity", "text":"text"}'
* Test in the browser: http://localhost:8080/note-manager-api/rest/tta/titleEntities/list/xt

## Solr Build
* http://localhost:8983/solr/#/notemanagercol/dataimport?command=full-import
* ./solr create -c notemanagercol -d basic_configs

## References:
* http://www.solrtutorial.com/solr-in-5-minutes.html
* http://blog.comperiosearch.com/blog/2014/08/28/indexing-database-using-solr/
* https://examples.javacodegeeks.com/enterprise-java/apache-solr/solr-dataimporthandler-example/
