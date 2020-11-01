/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.cluster.client.rpcutils;

import java.net.SocketException;
import org.apache.iotdb.db.utils.TestOnly;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;

public class TimeoutChangeableTFastFramedTransport extends TFastFramedTransport {

  private TSocket underlying;

  public TimeoutChangeableTFastFramedTransport(TSocket underlying) {
    super(underlying);
    this.underlying = underlying;
  }

  public void setTimeout(int timeout){
    underlying.setTimeout(timeout);
  }

  @TestOnly
  public int getTimeOut() throws SocketException {
    return underlying.getSocket().getSoTimeout();
  }
}