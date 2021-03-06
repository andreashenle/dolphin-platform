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
package org.opendolphin.core.server;

import org.opendolphin.core.Dolphin;
import org.opendolphin.core.server.action.DolphinServerAction;

public interface ServerDolphin extends Dolphin<ServerAttribute, ServerPresentationModel> {

    ServerConnector getServerConnector();

    void registerDefaultActions();

    void register(DolphinServerAction action);

    ServerModelStore getModelStore();

     ServerPresentationModel presentationModel(String id, String presentationModelType, DTO dto);
}
