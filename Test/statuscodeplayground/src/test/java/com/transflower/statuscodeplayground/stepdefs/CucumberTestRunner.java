// package com.transflower.statuscodeplayground.stepdefs;

// import io.cucumber.junit.platform.engine.Cucumber;

// @Cucumber
// public class CucumberTestRunner {
// }

package com.transflower.statuscodeplayground.stepdefs;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.transflower.statuscodeplayground.stepdefs")
public class CucumberTestRunner {
}