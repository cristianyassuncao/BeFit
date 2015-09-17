dataSource {
    pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    //driverClassName = "org.postgresql.Driver"
    //dialect = "org.hibernate.dialect.PostgreSQLDialect"
    loggingSql=true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "none" // one of 'create', 'create-drop', 'update', 'validate', ''
            //url = "jdbc:postgresql://localhost:5432/BeFit"
			url = "jdbc:mysql://127.0.0.1:3306/befit?useUnicode=yes&characterEncoding=UTF-8"
			//username="postgres"
            //password="crnilu03"
			username="befit"
			password="L8Az7%UY"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "none" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost:5432/BeFit"
            username="postgres"
            password="crnilu03"
        }
    }
}
