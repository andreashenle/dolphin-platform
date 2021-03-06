/*
 * Copyright 2015-2016 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opendolphin.core
import spock.lang.Specification

class BaseAttributeSpec extends Specification {

    def "you can set a presentation model"() {
        given:
        def attribute = new MyAttribute("name")
        def model = new BasePresentationModel("1", [])

        when:
        attribute.setPresentationModel(model)

        then:
        model == attribute.getPresentationModel()
    }

    def "you can set the presentation model only once"() {
        given:
        def attribute = new MyAttribute("name")
        attribute.setPresentationModel(new BasePresentationModel("1", []))

        when:
        attribute.setPresentationModel(new BasePresentationModel("2", []))

        then:
        thrown IllegalStateException
    }

    def "simple constructor with null bean and null value"() {
        when:

        def attribute = new MyAttribute("name")

        then:

        attribute.value == null
        attribute.toString().contains "name"
    }
}

class MyAttribute extends BaseAttribute {
    MyAttribute(String propertyName) {
        super(propertyName)
    }

    MyAttribute(String propertyName, Object baseValue) {
        super(propertyName, baseValue)
    }

    @Override
    String getOrigin() {
        return "M"
    }
}