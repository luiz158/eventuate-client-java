package io.eventuate.javaclient.spring.jdbc;

import io.eventuate.example.banking.services.counting.InvocationCounter;
import io.eventuate.javaclient.tests.common.spring.AbstractSpringAccountIntegrationSyncTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JdbcAutoConfigurationIntegrationTestConfiguration.class)
@IntegrationTest
public class JdbcAutoConfigurationIntegrationSyncTest extends AbstractSpringAccountIntegrationSyncTest {

  @Autowired
  private InvocationCounter invocationCounter;

  @Override
  public void shouldStartMoneyTransfer() throws ExecutionException, InterruptedException {
    super.shouldStartMoneyTransfer();
    assertTrue("Expected invocation", invocationCounter.get() > 0);
  }
}
