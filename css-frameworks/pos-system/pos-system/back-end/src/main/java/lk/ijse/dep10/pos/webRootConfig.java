package lk.ijse.dep10.pos;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class webRootConfig {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dbs = new BasicDataSource();
        dbs.setUrl("jdbc:mysql://localhost:3306/dep10_pos?createDatabaseIfNotExist=true");
        dbs.setUsername("root");
        dbs.setPassword("mysql");
        dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbs.setInitialSize(20);
        dbs.setMaxTotal(50);
        return dbs;
    }
}
