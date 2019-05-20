package com.ranjit.shinde.springbootdemo.controller;


import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactUrl;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RestPactRunner.class)
@Provider("movie-service")
@PactUrl(urls = {"https://s3.ap-south-1.amazonaws.com/pan-service-pact-contracts/movie-consumer-movie-service.json"})
public class MovieControllerS3PactProviderTest {

    @TestTarget
    public Target target = new HttpTarget("http", "localhost", 8080);

    @Before
    public void before() {
        initMocks(this);
    }

    @State("getMovie")
    public void personData() {
    }

}
