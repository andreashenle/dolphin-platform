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
package com.canoo.dolphin.client.javafx.binding;

import com.canoo.dolphin.binding.Binding;
import com.canoo.dolphin.mapping.Property;

/**
 * Created by hendrikebbers on 27.09.15.
 */
public interface JavaFXBinder<S> {

    default Binding to(Property<? extends S> dolphinProperty) {
        if (dolphinProperty == null) {
            throw new IllegalArgumentException("dolphinProperty must not be null");
        }
        return to(dolphinProperty, n -> n);
    }

    <T> Binding to(Property<T> dolphinProperty, Converter<? super T, ? extends S> converter);

}