/*
 * The MIT License
 *
 * Copyright (c) 2017, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugin.gitea;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;
import jenkins.scm.api.trait.SCMSourceBuilder;

public class GiteaSCMSourceBuilder extends SCMSourceBuilder<GiteaSCMSourceBuilder, GiteaSCMSource> {
    @CheckForNull
    private final String id;
    @CheckForNull
    private final String serverUrl;
    @CheckForNull
    private final String credentialsId;
    @NonNull
    private final String repoOwner;

    public GiteaSCMSourceBuilder(@CheckForNull String id, @CheckForNull String serverUrl,
                                 @CheckForNull String credentialsId, @NonNull String repoOwner,
                                 @NonNull String repoName) {
        super(GiteaSCMSource.class, repoName);
        this.id = id;
        this.serverUrl = serverUrl;
        this.repoOwner = repoOwner;
        this.credentialsId = credentialsId;
    }

    public final String id() {
        return id;
    }

    @CheckForNull
    public final String serverUrl() {
        return serverUrl;
    }

    @CheckForNull
    public final String credentialsId() {
        return credentialsId;
    }

    @NonNull
    public final String repoOwner() {
        return repoOwner;
    }

    @NonNull
    @Override
    public GiteaSCMSource build() {
        GiteaSCMSource result = new GiteaSCMSource(serverUrl, repoOwner, projectName());
        result.setId(id());
        result.setCredentialsId(credentialsId());
        result.setTraits(traits());
        return result;
    }
}
