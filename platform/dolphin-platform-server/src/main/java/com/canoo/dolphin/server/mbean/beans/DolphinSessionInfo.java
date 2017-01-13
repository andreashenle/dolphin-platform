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
package com.canoo.dolphin.server.mbean.beans;

import com.canoo.dolphin.server.DolphinSession;
import com.canoo.dolphin.server.impl.gc.GarbageCollector;
import com.canoo.common.Assert;

import java.lang.ref.WeakReference;
import java.util.Set;

/**
 *  MBean implementation for the {@link DolphinSessionInfoMBean} MBean interface
 */
public class DolphinSessionInfo implements DolphinSessionInfoMBean {

    private final WeakReference<DolphinSession> dolphinSessionRef;

    private final WeakReference<GarbageCollector> garbageCollectionRef;

    public DolphinSessionInfo(DolphinSession dolphinSession, GarbageCollector garbageCollector) {
        this.dolphinSessionRef = new WeakReference<>(dolphinSession);
        this.garbageCollectionRef = new WeakReference<>(garbageCollector);
    }

    private DolphinSession getSession() {
        DolphinSession session = dolphinSessionRef.get();
        Assert.requireNonNull(session, "session");
        return session;
    }

    private GarbageCollector getGarbageCollection() {
        GarbageCollector garbageCollector = garbageCollectionRef.get();
        Assert.requireNonNull(garbageCollector, "garbageCollector");
        return garbageCollector;
    }

    @Override
    public String getDolphinSessionId() {
        return getSession().getId();
    }

    @Override
    public Set<String> getAttributesNames() {
        return getSession().getAttributeNames();
    }

    @Override
    public Object getAttribute(String name) {
        return getSession().getAttribute(name);
    }

    @Override
    public long getGarbageCollectionRuns() {
        return getGarbageCollection().getGcCalls();
    }

    @Override
    public long getGarbageCollectionRemovedBeansTotal() {
        return getGarbageCollection().getRemovedBeansCount();
    }

    @Override
    public int getGarbageCollectionCurrentManagedBeansCount() {
        return getGarbageCollection().getManagedInstancesCount();
    }
}
