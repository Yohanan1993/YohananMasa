package com.telran.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationMaanger app = new ApplicationMaanger();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        app.strat();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
