/*
 * Copyright 2014 Cask, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.cdap.internal.app.services;

import co.cask.cdap.api.service.DefaultServiceWorkerContext;
import co.cask.cdap.api.service.ServiceWorker;
import co.cask.cdap.api.service.ServiceWorkerSpecification;
import com.google.common.base.Throwables;
import org.apache.twill.api.Command;
import org.apache.twill.api.TwillContext;
import org.apache.twill.api.TwillRunnable;
import org.apache.twill.api.TwillRunnableSpecification;

/**
 * TwillRunnable to run a custom Service worker.
 */
public class ServiceWorkerTwillRunnable implements TwillRunnable {
  private ServiceWorker worker;

  /**
   * Create a TwillRunnable for a custom Service worker.
   * @param worker
   */
  public ServiceWorkerTwillRunnable(ServiceWorker worker) {
    this.worker = worker;
  }

  @Override
  public TwillRunnableSpecification configure() {
    ServiceWorkerSpecification workerSpecification = worker.configure();
    return TwillRunnableSpecification.Builder.with()
                                             .setName(worker.getClass().getSimpleName())
                                             .withConfigs(workerSpecification.getProperties())
                                             .build();
  }

  @Override
  public void initialize(TwillContext context) {
    try {
      worker.initialize(new DefaultServiceWorkerContext(context.getSpecification().getConfigs()));
    } catch (Exception e) {
      Throwables.propagate(e);
    }
  }

  @Override
  public final void handleCommand(Command command) throws Exception {
    // no-op
  }

  @Override
  public void stop() {
    worker.stop();
  }

  @Override
  public void destroy() {
    worker.destroy();
  }

  @Override
  public void run() {
    worker.run();
  }
}
