package org.api.aplicacion;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("api")
public class Aplicacion extends Application{
	
	public Aplicacion() {

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("TJaxRs Swagger");
        beanConfig.setBasePath("/JaxRs/api");
        beanConfig.setResourcePackage("org.api.recursos");
        beanConfig.setScan(true);
	}

}
