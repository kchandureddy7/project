/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.origin.sample;

import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.sdk.SourceRunner;
import com.streamsets.pipeline.sdk.StageRunner;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestSampleSource {
  private static final int MAX_BATCH_SIZE = 5;

  @Test
  public void testOrigin() throws Exception {
    SourceRunner runner = new SourceRunner.Builder(SampleDSource.class)
        .addConfiguration("config", "value")
        .addOutputLane("lane")
        .build();

    try {
      runner.runInit();

      final String lastSourceOffset = null;
      StageRunner.Output output = runner.runProduce(lastSourceOffset, MAX_BATCH_SIZE);
      Assert.assertEquals("5", output.getNewOffset());
      List<Record> records = output.getRecords().get("lane");
      Assert.assertEquals(5, records.size());
      Assert.assertTrue(records.get(0).has("/fieldName"));
      Assert.assertEquals("Some Value", records.get(0).get("/fieldName").getValueAsString());

    } finally {
      runner.runDestroy();
    }
  }

}
