/*
 * Copyright 2016-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jsmart.zerocode.samplesjunit5.loadjupiter;

import org.jsmart.zerocode.jupiter.extension.ParallelLoadExtension;
import org.jsmart.zerocode.samplesjunit5.loadjupiter.commonload.JUnit5LoadCommonLoadTest;
import org.jsmart.zerocode.samplesjunit5.loadjupiter.differentload.JUnit5LoadDifferentLoadTest;
import org.jsmart.zerocode.samplesjunit5.loadjupiter.simpleload.JUnit5LoadTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Test suite which demonstrates that the load tests can be run as a Suite in JUnit 5.
 * Single type of load or different types of load can be generated via {@link ParallelLoadExtension}.
 *
 * @author N Chandra
 * @since 5.0
 * @see JUnit5LoadTest
 * @see JUnit5LoadDifferentLoadTest
 * @see JUnit5LoadCommonLoadTest
 */
@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
@SelectPackages("org.jsmart.zerocode.samplesjunit5.loadjupiter")
public class ParallelLoadTestSuite {
}
