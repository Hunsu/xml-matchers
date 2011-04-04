/*
 * Copyright 2010 the original author or authors.
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
package org.xmlmatchers.xpath;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * @author David Ehringer
 *
 */
public class SourceHasXPath extends HasXPath<Source> {

	// TODO change constructors back to <? super String>
	
	public SourceHasXPath(String xPathExpression) {
		super(xPathExpression);
	}
	
	public SourceHasXPath(String xPathExpression,
			Matcher<?> valueMatcher,
			NamespaceContext namespaceContext) {
		super(xPathExpression, valueMatcher, namespaceContext);
	}

	public SourceHasXPath(String xPathExpression, Matcher<?> valueMatcher,
			NamespaceContext namespaceContext, QName xPathReturnType) {
		super(xPathExpression, valueMatcher, namespaceContext, xPathReturnType);
	}

	@Override
	protected Source convertToSource(Source source) throws IllegalArgumentException {
		return source;
	}
	
	@Factory
	public static Matcher<Source> hasXPath(String xPath) {
		return new SourceHasXPath(xPath);
	}

	@Factory
	public static Matcher<Source> hasXPath(String xPath,
			NamespaceContext namespaceContext) {
		return new SourceHasXPath(xPath, null, namespaceContext);
	}

	@Factory
	public static Matcher<Source> hasXPath(String xPath,
			Matcher<? super String> valueMatcher) {
		return new SourceHasXPath(xPath, valueMatcher, null);
	}

	// TODO keep <?>
	@Factory
	public static Matcher<Source> hasXPath(QName xPathReturnType, String xPath,
			Matcher<?> valueMatcher) {
		return new SourceHasXPath(xPath, valueMatcher, null, xPathReturnType);
	}

	@Factory
	public static Matcher<Source> hasXPath(String xPath,
			NamespaceContext namespaceContext,
			Matcher<? super String> valueMatcher) {
		return new SourceHasXPath(xPath, valueMatcher, namespaceContext);
	}


	// TODO keep <?>
	@Factory
	public static Matcher<Source> hasXPath(QName xPathReturnType, String xPath,
			NamespaceContext namespaceContext,
			Matcher<?> valueMatcher) {
		return new SourceHasXPath(xPath, valueMatcher, namespaceContext, xPathReturnType);
	}
	
	@Factory
	public static Matcher<Source> hasXPath(String xPath,
			Matcher<? super String> valueMatcher,
			NamespaceContext namespaceContext) {
		return new SourceHasXPath(xPath, valueMatcher, namespaceContext);
	}
	
}
