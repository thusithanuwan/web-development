package lk.ijse.dep10.pos;

import lk.ijse.dep10.pos.api.CustomerController;
import lk.ijse.dep10.pos.api.ItemController;
import lk.ijse.dep10.pos.dto.ItemDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class webAppConfig {

    @Bean
    public CustomerController customerController(){
        return  new CustomerController();
    }
    @Bean
    public ItemController itemController(){
        return new ItemController();
    }
}
