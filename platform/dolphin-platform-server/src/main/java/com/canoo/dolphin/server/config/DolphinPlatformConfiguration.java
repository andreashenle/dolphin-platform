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
package com.canoo.dolphin.server.config;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * This class defines the configuration of the Dolphin Platform. Normally the configuration is created based
 * on defaults and a property file (see {@link ConfigurationFileLoader}).
 */
public class DolphinPlatformConfiguration {

    private boolean useSessionInvalidationServlet = false;

    public final static int SESSION_TIMEOUT_DEFAULT_VALUE = 15 * 60;

    private boolean useCrossSiteOriginFilter = true;

    private boolean mBeanRegistration = true;

    private String dolphinPlatformServletMapping = "/dolphin";

    private String rootPackageForClasspathScan = null;

    private List<String> idFilterUrlMappings = Arrays.asList("/dolphin");

    private Level openDolphinLogLevel = Level.SEVERE;

    private int sessionTimeout = SESSION_TIMEOUT_DEFAULT_VALUE;

    private long maxPollTime = 5_000;

    private int maxClientsPerSession = 10;

    private boolean useGc = true;

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public boolean isUseCrossSiteOriginFilter() {
        return useCrossSiteOriginFilter;
    }

    public void setUseCrossSiteOriginFilter(boolean useCrossSiteOriginFilter) {
        this.useCrossSiteOriginFilter = useCrossSiteOriginFilter;
    }

    public String getDolphinPlatformServletMapping() {
        return dolphinPlatformServletMapping;
    }

    public void setDolphinPlatformServletMapping(String dolphinPlatformServletMapping) {
        this.dolphinPlatformServletMapping = dolphinPlatformServletMapping;
    }

    public Level getOpenDolphinLogLevel() {
        return openDolphinLogLevel;
    }

    public void setOpenDolphinLogLevel(Level openDolphinLogLevel) {
        this.openDolphinLogLevel = openDolphinLogLevel;
    }

    public int getMaxClientsPerSession() {
        return maxClientsPerSession;
    }

    public void setMaxClientsPerSession(int maxClientsPerSession) {
        this.maxClientsPerSession = maxClientsPerSession;
    }

    public boolean isUseSessionInvalidationServlet() {
        return useSessionInvalidationServlet;
    }

    public void setUseSessionInvalidationServlet(boolean useSessionInvalidationServlet) {
        this.useSessionInvalidationServlet = useSessionInvalidationServlet;
    }

    public List<String> getIdFilterUrlMappings() {
        return idFilterUrlMappings;
    }

    public void setIdFilterUrlMappings(List<String> idFilterUrlMappings) {
        this.idFilterUrlMappings = idFilterUrlMappings;
    }

    public boolean isMBeanRegistration() {
        return mBeanRegistration;
    }

    public void setMBeanRegistration(boolean mBeanRegistration) {
        this.mBeanRegistration = mBeanRegistration;
    }

   public String getRootPackageForClasspathScan() {
        return rootPackageForClasspathScan;
    }

    public void setRootPackageForClasspathScan(String rootPackageForClasspathScan) {
        this.rootPackageForClasspathScan = rootPackageForClasspathScan;
    }

    public long getMaxPollTime() {
        return maxPollTime;
    }

    public void setMaxPollTime(long maxPollTime) {
        this.maxPollTime = maxPollTime;
    }

    public boolean isUseGc() {
        return useGc;
    }

    public void setUseGc(boolean useGc) {
        this.useGc = useGc;
    }

    public void setmBeanRegistration(boolean mBeanRegistration) {
        this.mBeanRegistration = mBeanRegistration;
    }
}
