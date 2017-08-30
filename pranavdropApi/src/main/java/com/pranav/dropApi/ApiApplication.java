package com.pranav.dropApi;

import com.pranav.dropApi.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.concurrent.atomic.AtomicLong;

public class ApiApplication extends Application<ApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "pranav-Api";
    }

    public void run(ApiConfiguration apiConfiguration, Environment environment) throws Exception {
        HelloWorldResource helloWorldResource = new HelloWorldResource(apiConfiguration.getTemplate(),
                apiConfiguration.getDefaultName());
        environment.jersey().register(helloWorldResource);
    }
}
