# Note manager

*"This web applications was formerly known as title-text-adder"*

## Building notes

* You will need an installation of MySQL for the meantime

> MacOS

```
$ brew install mysql
$ mysqld
$ mysql -u root

```

or
> Linux

```
$ sudo apt-get install mysql
```

> Commands

```
mysql> SHOW DATABASES
```

Solr is required to be running. You will need to configure your collection and how you want it to be attached to your databas

> MacOS

```
$ brew install solr
```

or
> Linux

* You need to manually install it: *See: http://www.apache.org/dyn/closer.lua/lucene/solr/5.5.0*

Use bower in the note-manager-web folder:

```
../note-manager-web$ bower install
```

This application is using JETTY in the Maven POM files. (NOTE: It was already been tested in Tomcat7)


```
NOTE: The extra folder for mysql-tta-indexing is part of Solr configuration.
This is used for elastic search purposes
```