/*
 * Copyright © 2015 Cask Data, Inc.
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

package co.cask.cdap.client;

import co.cask.cdap.client.common.ClientTestBase;
import co.cask.cdap.common.conf.Constants;
import co.cask.cdap.common.exception.AlreadyExistsException;
import co.cask.cdap.common.exception.BadRequestException;
import co.cask.cdap.common.exception.CannotBeDeletedException;
import co.cask.cdap.common.exception.NotFoundException;
import co.cask.cdap.common.exception.UnauthorizedException;
import co.cask.cdap.proto.Id;
import co.cask.cdap.proto.NamespaceMeta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Tests for {@link NamespaceClient}
 */
public class NamespaceClientTestRun extends ClientTestBase {
  private NamespaceClient namespaceClient;
  private static final Id.Namespace DOES_NOT_EXIST = Id.Namespace.from("doesnotexist");
  private static final Id.Namespace DEFAULT = Id.Namespace.from("default");
  private static final Id.Namespace SYSTEM = Id.Namespace.from("system");
  private static final Id.Namespace TEST_NAMESPACE_ID = Id.Namespace.from("testnamespace");
  private static final String TEST_NAME = "testname";
  private static final String TEST_DESCRIPTION = "testdescription";
  private static final Id.Namespace TEST_DEFAULT_FIELDS = Id.Namespace.from("testdefaultfields");

  @Before
  public void setup() {
    namespaceClient = new NamespaceClient(clientConfig);
  }

  @Test
  @Ignore
  public void testNamespaces() throws Exception {
    List<NamespaceMeta> namespaces = namespaceClient.list();
    int initialNamespaceCount = namespaces.size();

    if (namespaces.size() == 1) {
      Assert.assertEquals(Constants.DEFAULT_NAMESPACE, namespaces.get(0).getName());
    } else {
      Assert.assertEquals(0, namespaces.size());
    }

    verifyDoesNotExist(DOES_NOT_EXIST);
    verifyReservedCreate();
    verifyReservedDelete();
    // include default namespace
    initialNamespaceCount++;

    // create a valid namespace
    NamespaceMeta.Builder builder = new NamespaceMeta.Builder();
    builder.setName(TEST_NAMESPACE_ID).setDescription(TEST_DESCRIPTION);
    namespaceClient.create(builder.build());

    // verify that the namespace got created correctly
    namespaces = namespaceClient.list();
    Assert.assertEquals(initialNamespaceCount + 1, namespaces.size());
    NamespaceMeta meta = namespaceClient.get(TEST_NAMESPACE_ID.getId());
    Assert.assertEquals(TEST_NAMESPACE_ID.getId(), meta.getName());
    Assert.assertEquals(TEST_DESCRIPTION, meta.getDescription());

    // try creating a namespace with the same id again
    builder.setName("existing").setDescription("existing");
    try {
      namespaceClient.create(builder.build());
      Assert.fail("Should not be able to re-create an existing namespace");
    } catch (AlreadyExistsException e) {
    }
    // verify that the existing namespace was not updated
    meta = namespaceClient.get(TEST_NAMESPACE_ID.getId());
    Assert.assertEquals(TEST_NAMESPACE_ID.getId(), meta.getName());
    Assert.assertEquals(TEST_DESCRIPTION, meta.getDescription());

    // create and verify namespace without name and description
    builder = new NamespaceMeta.Builder();
    builder.setName(TEST_DEFAULT_FIELDS);
    namespaceClient.create(builder.build());
    namespaces = namespaceClient.list();
    Assert.assertEquals(initialNamespaceCount + 2, namespaces.size());
    meta = namespaceClient.get(TEST_DEFAULT_FIELDS.getId());
    Assert.assertEquals(TEST_DEFAULT_FIELDS.getId(), meta.getName());
    Assert.assertEquals("", meta.getDescription());

    // cleanup
    namespaceClient.delete(TEST_NAMESPACE_ID.getId());
    namespaceClient.delete(TEST_DEFAULT_FIELDS.getId());

    Assert.assertEquals(initialNamespaceCount, namespaceClient.list().size());
  }

  private void verifyDoesNotExist(Id.Namespace namespaceId)
    throws IOException, UnauthorizedException, CannotBeDeletedException {

    try {
      namespaceClient.get(namespaceId.getId());
      Assert.fail(String.format("Namespace '%s' must not be found", namespaceId));
    } catch (NotFoundException e) {
    }

    try {
      namespaceClient.delete(namespaceId.getId());
      Assert.fail(String.format("Namespace '%s' must not be found", namespaceId));
    } catch (NotFoundException e) {
    }
  }

  private void verifyReservedCreate() throws AlreadyExistsException, IOException, UnauthorizedException {
    NamespaceMeta.Builder builder = new NamespaceMeta.Builder();
    builder.setName(DEFAULT);
    try {
      namespaceClient.create(builder.build());
      Assert.fail(String.format("Must not create '%s' namespace", DEFAULT));
    } catch (BadRequestException e) {
    }
    builder.setName(SYSTEM);
    try {
      namespaceClient.create(builder.build());
      Assert.fail(String.format("Must not create '%s' namespace", SYSTEM));
    } catch (BadRequestException e) {
    }
  }

  private void verifyReservedDelete() throws Exception {
    // For the purposes of NamespaceClientTestRun, deleting default namespace has no effect.
    // Its lifecycle is already tested in NamespaceHttpHandlerTest
    namespaceClient.delete(DEFAULT.getId());
    namespaceClient.get(DEFAULT.getId());
    try {
      namespaceClient.delete(SYSTEM.getId());
      Assert.fail(String.format("'%s' namespace must not exist", SYSTEM));
    } catch (NotFoundException e) {
    }
  }
}
