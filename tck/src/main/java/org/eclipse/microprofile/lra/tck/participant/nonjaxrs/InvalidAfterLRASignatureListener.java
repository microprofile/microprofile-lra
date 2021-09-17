/*
 *******************************************************************************
 * Copyright (c) 2019 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.eclipse.microprofile.lra.tck.participant.nonjaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.lra.annotation.AfterLRA;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;
import org.eclipse.microprofile.lra.tck.TckInvalidSignaturesTests;

/**
 * TCK invalid LRA resource containing invalid signature for <code>&#64;AfterLRA</code> method. It's used for
 * verification of deployment time invalid signature detection and error report in {@link TckInvalidSignaturesTests}.
 */
@Path(InvalidAfterLRASignatureListener.RESOURCE_PATH)
public class InvalidAfterLRASignatureListener {

    public static final String RESOURCE_PATH = "invalid-after-lra";
    public static final String START_LRA = "start-lra";

    @GET
    @Path(START_LRA)
    @LRA(LRA.Type.REQUIRED)
    public Response doInLRA() {
        return Response.ok().build();
    }

    @AfterLRA
    public void onLRAEnd(String lraId, String lraStatus) {
        // intentionally empty
    }
}
