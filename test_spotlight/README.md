### Selenium Framework with Cucumber

This repository contains a collection of sample selenium-cucumber-java projects and libraries that demonstrate how to use the tool and develop automation script using the Cucumber (v 3.0.0) BDD framework with Java as programming language.

#### The framework has following features
### Installation (pre-requisites)
1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set
3. IDE
4. IDE Plugins for
   Maven
   Cucumber
5. Browser driver (make sure you have your desired browser driver and class path is set)


### Framework set up
Fork / Clone repository or download zip and set it up in your local workspace.

### Add the Feature file 

Add the feature file under `test\resources\featurefile`

```java
Feature: Picks wise Sports Filter

        Scenario: Valid Sports Filter
        Given I am on "https://www.pickswise.com/"
        When I Select the Next Up Sports Filter
        Then I can see an available list of valid Sports to filter by
```

use the tag `@chrome` to launch the specific browser or no-tag to use the browser form the `config.properties` file

### Create the Runner

```java
package com.cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/filterSports.feature" }, 
        glue = {"classpath:com.cucumber.framework.stepdefinition" },
        plugin = { "pretty", "json:target/FilterSportsFeatureRunner.json" })
public class filterSportsFeatureRunner extends AbstractTestNGCucumberTests {
}
``` 

### Use the testng.xml file to run the test cases

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">

    <test name="Test - 1">
        <classes>
            <class name="com.cucumber.framework.runner.filterSportsFeatureRunner" />
            <class name="com.cucumber.framework.runner.selectAnalysisFeatureRunner" />
        </classes>
    </test>
</suite>
```

### To see this whole thing running simply checkout this project and run this command:

`mvn clean test`

### Cucumber Report

There is a feature overview page:

![feature overview page](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-overview.png)

And there are also feature specific results pages:

![feature specific page passing](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-passed.png)

And useful information for failures:

![feature specific page passing](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-failed.png)

If you have tags in your cucumber features you can see a tag overview:

![Tag overview](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/tag-overview.png)

And you can drill down into tag specific reports:

![Tag report](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/tag-report.png)

