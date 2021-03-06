/*
 * Copyright 2015-2017 Canoo Engineering AG.
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
package com.canoo.dolphin.converters;

import com.canoo.dolphin.converter.Converter;
import com.canoo.dolphin.converter.ValueConverterException;
import com.canoo.dolphin.impl.converters.AbstractConverterFactory;
import com.canoo.dolphin.impl.converters.AbstractStringConverter;

import java.time.Duration;

public class DurationConverterFactory extends AbstractConverterFactory {

    private final static Converter CONVERTER = new DurationConverter();

    @Override
    public boolean supportsType(Class<?> cls) {
        return Duration.class.isAssignableFrom(cls);
    }

    @Override
    public int getTypeIdentifier() {
        return ValueFieldTypes.DURATION_FIELD_TYPE;
    }

    @Override
    public Converter getConverterForType(Class<?> cls) {
        return CONVERTER;
    }

    private static class DurationConverter extends AbstractStringConverter<Duration> {

        @Override
        public Duration convertFromDolphin(String value) throws ValueConverterException {
            if (value == null) {
                return null;
            }
            try {
                return Duration.parse(value);
            } catch (Exception e) {
                throw new ValueConverterException("Can not convert to Duration", e);
            }
        }

        @Override
        public String convertToDolphin(Duration value) throws ValueConverterException {
            if (value == null) {
                return null;
            }
            try {
                return value.toString();
            } catch (Exception e) {
                throw new ValueConverterException("Can not convert from Duration", e);
            }
        }
    }

}
