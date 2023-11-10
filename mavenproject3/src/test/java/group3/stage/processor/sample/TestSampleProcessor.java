/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.processor.sample;

import com.streamsets.pipeline.api.Field;
import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.api.StageException;
import com.streamsets.pipeline.sdk.ProcessorRunner;
import com.streamsets.pipeline.sdk.RecordCreator;
import com.streamsets.pipeline.sdk.StageRunner;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestSampleProcessor {
  @Test
  @SuppressWarnings("unchecked")
  public void testProcessor() throws StageException {
    ProcessorRunner runner = new ProcessorRunner.Builder(SampleDProcessor.class)
        .addConfiguration("config", "value")
        .addOutputLane("output")
        .build();

    runner.runInit();

    try {
      Record record = RecordCreator.create();
      record.set(Field.create(true));
      StageRunner.Output output = runner.runProcess(Arrays.asList(record));
      Assert.assertEquals(1, output.getRecords().get("output").size());
      Assert.assertEquals(true, output.getRecords().get("output").get(0).get().getValueAsBoolean());
    } finally {
      runner.runDestroy();
    }
  }
}
