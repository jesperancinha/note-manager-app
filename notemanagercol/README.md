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

## About me

[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=informational)](http://joaofilipesabinoesperancinha.nl)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=informational)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=informational)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=informational)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Project%20Status&color=informational)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Badges&color=informational)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Google%20Apps&message=Joao+Filipe+Sabino+Esperancinha&color=informational)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social)](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social)](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=DEV&message=Profile&color=informational)](https://dev.to/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Medium&message=@jofisaes&color=informational)](https://medium.com/@jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Free%20Code%20Camp&message=jofisaes&color=informational)](https://www.freecodecamp.org/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Hackerrank&message=jofisaes&color=informational)](https://www.hackerrank.com/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Acclaim%20Badges&message=joao-esperancinha&color=informational)](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Pen&message=jesperancinha&color=informational)](https://codepen.io/jesperancinha)

---

[![GitHub Logo](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/JEsperancinhaOrg-32.png)](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=informational)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=informational)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=informational)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=informational)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=informational)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)

## License

```text
Copyright 2016-2019 João Esperancinha (jesperancinha)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
