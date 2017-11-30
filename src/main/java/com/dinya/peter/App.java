package com.dinya.peter;

import com.dinya.peter.entity.IntegrationImpl;
import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;

public class App
{
    public static void main( String[] args )
    {
        Integration integration = new IntegrationImpl("dev1");
        IntegrationTestRunner test = new IntegrationTestRunner();
        test.runTests(integration);
    }
}