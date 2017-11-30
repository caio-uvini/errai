/**
 * Copyright (C) 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.cdi.rpc.server;

import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.cdi.common.client.payload.GenericPayload;
import org.jboss.errai.cdi.common.client.payload.ParameterizedSubtypePayload;
import org.jboss.errai.cdi.common.client.remote.GenericService;

/**
 *
 * @author Max Barkley <mbarkley@redhat.com>
 */
@Service
public class GenericServiceImpl implements GenericService {

  @Override
  public <A, B> GenericPayload<A, B> genericRoundTrip(final GenericPayload<A, B> payload) {
    return payload;
  }

  @Override
  public GenericPayload<String, Integer> parameterizedRoundTrip(final GenericPayload<String, Integer> payload) {
    return payload;
  }

  @Override
  public ParameterizedSubtypePayload parameterizedSubtypeRoundTrip(final ParameterizedSubtypePayload payload) {
    return payload;
  }

}
