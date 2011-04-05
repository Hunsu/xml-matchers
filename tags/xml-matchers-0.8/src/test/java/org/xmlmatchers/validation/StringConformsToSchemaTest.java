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
package org.xmlmatchers.validation;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.xmlmatchers.validation.StringConformsToSchema.conformsTo;

import javax.xml.validation.Schema;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * @author David Ehringer
 * 
 */
public class StringConformsToSchemaTest extends AbstractConformsToSchemaTest{

	public StringConformsToSchemaTest(Schema schema) {
		super(schema);
	}

	@Test
	public void aValidXmlStringAdheresToTheSchema() throws SAXException {
		String xml = "<person private=\"true\"><name>Dave</name></person>";
		assertThat(xml, conformsTo(schema));
	}

	@Test
	public void anInvalidAttributeDoesNotAdhereToTheSchema()
			throws SAXException {
		String xml = "<person private=\"2\"><name>Dave</name></person>";
		assertThat(xml, not(conformsTo(schema)));
	}

	@Test
	public void anInvalidElementDoesNotAdhereToTheSchema() throws SAXException {
		String xml = "<person private=\"1\"><age/></person>";
		assertThat(xml, not(conformsTo(schema)));
	}

	@Test(expected = Exception.class)
	public void malformedXmlCausesAnExceptionToBeThrown() throws SAXException {
		String xml = "<person private=\"1\">";
		assertThat(xml, not(conformsTo(schema)));
	}
}