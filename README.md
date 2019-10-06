> _Visit here for a quick read about the essence of [performance-testing](https://github.com/authorjapps/zerocode/wiki/Load-or-Performance-Testing-(IDE-based)#in-essence-the-performance-testing-is-all-about-) before we actually generate load or stress_

## Table of Contents
* [Introduction and Quick Overview](https://github.com/authorjapps/zerocode/wiki/Load-or-Performance-Testing-(IDE-based)#in-essence-the-performance-testing-is-all-about-)
* [Performance testing (Testing load and stress)](#performance-testing-testing-load-and-stress)
    * [Using - JUnit5 Jupiter](#maven-dependencies---junit5-jupiter-tests)
    * [Using - JUnit4](#maven-dependencies---junit4)
* [One user-journey parallel load](#single-scenario-parallel-load)
* [Combining single user-journeys(GET, POST, PUT etc)](#combining-single-loadsget-post-put-etc)
* [Multi scenario parallel load](#multi-scenario-parallel-load)
    * [Grouping the multiload tests(Optional)](#optionallygrouping-the-multiload-tests)
* [Load with gradually increasing or decreasing](#load-with-gradually-increasing-or-decreasing)
* [Maven library used](#maven-library-used)
* [Disbaling long-running HTML reports]()

# Performance testing (Testing load and stress)

Sample Performance Tests - Banking (Using [JUnit](https://github.com/junit-team/junit4) and [Zerocode](https://github.com/authorjapps/zerocode) test framework)

#### Maven dependencies - JUnit5 Jupiter Tests
```xml
<dependency>
    <groupId>org.jsmart</groupId>
    <artifactId>zerocode-tdd-jupiter</artifactId>
    <version>1.3.7</version> <!-- or higher -->
</dependency>
```
Then follow this [WikiPage](https://github.com/authorjapps/zerocode/wiki/JUnit5-Jupiter-Parallel-Load-Extension).

For **JUnit4** parallel-run or load testing, follow the samples in the below sections.

#### Maven dependencies - JUnit4
```xml
<dependency>
    <groupId>org.jsmart</groupId>
    <artifactId>zerocode-tdd</artifactId>
    <version>1.3.7</version> 
</dependency>
```

![Prepare Scenario](help_images/load_tests_L.png)

Single scenario parallel load
===
See this `GET` load test in the repo e.g.
```java
@LoadWith("load_generation.properties")
@TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadGetTest {

}
```
Where, the `load_generation.properties` has the below load e.g. </br>
(100 requests in 100secs i.e. each request in 1 sec gap, looping twice, meaning 200 parallel requests)
```properties
number.of.threads=100
ramp.up.period.in.seconds=100
loop.count=2
```

It generates load for the below GET scenario:
```
@TargetEnv("screening_service_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class GetScreeningServiceTest {

    @Test
    @JsonTestCase("load_tests/get/get_screening_details_by_custid.json")
    public void testGetScreeningLocalAndGlobal() throws Exception {
    }
}
```

Where the `get_screening_details_by_custid.json` with payload and assertions/validations :
```
{
    "scenarioName": "Screening API- Get Screening by customerId test",
    "steps": [
        {
            "name": "get_screening_details",
            "url": "/api/v1/screening/cust-ids/SINGAHV3033",
            "method": "GET",
            "request": {
            },
            "verify": {
                "status": 200,
                "body": {
                    "id" : "SINGAHV3033",
                    "localScreeningStatus" : "Green",
                    "globalScreeningStatus" : "Red"
                }
            }
        }

    ]
}
```
+ [Download](https://github.com/authorjapps/performance-tests/archive/master.zip) or [browse](https://github.com/authorjapps/performance-tests) in the repo

Combining single loads(GET, POST, PUT etc)
===
See the suite test firing different loads with single scenario each 
e.g.
sample test-class: `org.jsmart.zerocode.samples.load.LoadTestSuite`

```java
@Suite.SuiteClasses({

        LoadGetTest.class,
        LoadPostTest.class,
        LoadMultipleGetPostPutTest.class

})
@RunWith(Suite.class)
public class LoadTestSuite {

}
```
+ [Download](https://github.com/authorjapps/performance-tests/archive/master.zip) or [browse](https://github.com/authorjapps/performance-tests) in the repo

Multi scenario parallel load
===
See the test-class `org.jsmart.zerocode.samples.load.parallelmulti.LoadMultipleGetPostPutTest`
```java
/**
 * What's new in ZeroCodeMultiLoadRunner.class ?
 * ---------------------------------------------
 * While running with "ZeroCodeMultiLoadRunner.class", each test mapping here is equivalent to one user,
 * that means there are 3 concurrent users below invoking their respective user operations as:
 *         User-1) POST,GET
 *         User-2) PUT,GET
 *         User-3) GET
 *         User-N) so on
 *
 * Note :
 * ------
 * All 3 users are running in parallel which resembles the production like scenario where each user
 * doing different jobs.
 *
 * You can keep feeding/adding as many tests by using @TestMapping(TestClassName.class, "testMethodName")
 *
 * Please make sure you set "number.of.threads" >= "number of test mappings(= 3 here)" giving chance for
 * each scenario to get executed at least once.
 *
 */
@LoadWith("load_generation.properties")
@TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal")
@TestMapping(testClass = PostCorpLoanServiceTest.class, testMethod = "testPostNewLoan_crudOperations")
@TestMapping(testClass = PutCorpLoanServiceTest.class, testMethod = "testPutAmendExistingLoan")
@RunWith(ZeroCodeMultiLoadRunner.class)
public class LoadMultipleGetPostPutTest {

}
```
+ [Download](https://github.com/authorjapps/performance-tests/archive/master.zip) or [browse](https://github.com/authorjapps/performance-tests) in the repo

#### (Optionally)Grouping the multiload tests
You can(optionally) group the `@TestMapping`s as below for better readability and pretty looking too.
```java
@LoadWith("load_generation.properties")
@TestMappings({
        @TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal"),
        @TestMapping(testClass = PostCorpLoanServiceTest.class, testMethod = "testPostNewLoan_crudOperations"),
        @TestMapping(testClass = PutCorpLoanServiceTest.class, testMethod = "testPutAmendExistingLoan")
})
@RunWith(ZeroCodeMultiLoadRunner.class)
public class LoadMultipleGroupAnnotationTest {
}
```
+ [Download](https://github.com/authorjapps/performance-tests/archive/master.zip) or [browse](https://github.com/authorjapps/performance-tests) in the repo

Load with gradually increasing or decreasing
===

See the test-class `org.jsmart.zerocode.samples.loadgradually.LoadGraduallyTestSuite`
```java
@Suite.SuiteClasses({

        LoadGet1Per5SecTest.class, // <-- Less load (5 sec gap)
        LoadGet1Per1SecTest.class, // <-- Bit more load (1 sec gap)
        LoadGet5Per1SecTest.class  // <-- Heavy load (0.2 sec gap)

})
@RunWith(Suite.class)
public class LoadGraduallyTestSuite {

}
```
+ [Download](https://github.com/authorjapps/performance-tests/archive/master.zip) this project to run using your local IDE

Maven library used
===
+ Latest release (includes Kafka testing):
```
<dependency>
    <groupId>org.jsmart</groupId>
    <artifactId>zerocode-tdd</artifactId>
    <version>1.3.x</version> 
</dependency>
```
+ Visit here for the latest in [Maven Central](https://mvnrepository.com/artifact/org.jsmart/zerocode-tdd)
+ Or check here at [zerocode maven-and-ci](https://github.com/authorjapps/zerocode/blob/master/README.md#maven-and-ci-)
+ Visit here for the earlier releases [Maven Central](https://mvnrepository.com/artifact/org.jsmart/zerocode-rest-bdd)

Disabling long-running HTML Reports
===

The Interactive-Html-Report generation is enabled by default. For load testing this report may not be quite useful as we are mostly interested in load statistics which we can get from the CSV reports. Also the HTML interactive reports particularly takes bit longer to generate during load testing.

To disable this report generation please use the following flag in the host properties file annotated with `@TargetEnv("app_host_sit.properties")`.

```properties
interactive.html.report.disabled=true
```

