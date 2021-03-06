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
package org.opendolphin.core.comm;

import java.util.Map;

/**
 * A command that allows the receiving side to read the data without
 * necessarily working with presentation models if that is not appropriate.
 * This is very similar to a REST response.
 */
public class DataCommand extends Command {
    public DataCommand(Map data) {
        this.data = data;
    }

    public DataCommand() {
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    private Map data;
}
