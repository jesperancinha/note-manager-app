# Note Manager Log Book

<ins>2024/05/16</ins>

Move to toml:

### Replace

```regexp
implementation\("([a-z.-]*):([a-z.-]*):([a-z0-9.-]*)"\)
```

With

```regexp
$2 = { group = "$1", name = "$2", version = "$3" }
```

### Replace

```regexp
implementation\("([a-z.-]*):([a-z.-]*):([a-z0-9.-]*)"\)
```

With 

```regexp
api(libs.$2)
```

### Replace

All dashes to dots 

<ins>2022/11/20</ins>

Decision to drop all Solr code. At the same time decision to not use ElasticSearch.

This project will become the implementation of an own search engine.

## Planning

1. Dependency injection  - Koin, Guice, Spring 
2. Arrow - Objects containers
3. Ktor
