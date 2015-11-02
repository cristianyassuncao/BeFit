dataSource {
    pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 60000
		timeBetweenEvictionRunsMillis = 60000
		maxWait = 10000
		validationQuery="select 1"
		testWhileIdle=true
	}
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "none" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:mysql://localhost:3306/befit"
            username="befit"
            password="L8Az7!UY"
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
            url = "jdbc:mysql://befit.mysql.uhserver.com/befit?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			username="befit"
			password="L8Az7!UY"
        }
    }
}
