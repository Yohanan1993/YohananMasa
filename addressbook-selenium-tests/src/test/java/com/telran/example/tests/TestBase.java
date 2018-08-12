package com.telran.example.tests;

import com.telran.example.manager.ApplicationMaanger;
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
