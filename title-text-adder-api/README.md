# Title text adder REST API


## Usefull deploy commads

* mvn tomcat7:deploy
* mvn tomcat7:undeploy
* mvn tomcat7:redeploy

## Usefull test commands

* Should not work: curl -H "Content-Type: application/json" -X POST http://localhost:8080/title-text-adder-api/rest/tta/titles/add -d '{ "title":"title"}'
* Should work: curl -H "Content-Type: application/json" -X POST http://localhost:8080/title-text-adder-api/rest/tta/titles/add -d '{ "title":"title", "text":"text"}'


## References:

* http://www.solrtutorial.com/solr-in-5-minutes.html
* http://blog.comperiosearch.com/blog/2014/08/28/indexing-database-using-solr/
