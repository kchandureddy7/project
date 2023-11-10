/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.executor.sample;

import com.streamsets.pipeline.api.Field;
import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.sdk.RecordCreator;
import com.streamsets.pipeline.sdk.ExecutorRunner;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestSampleExecutor {
  @Test
  public void testWriteSingleRecord() throws Exception {
    ExecutorRunner runner = new ExecutorRunner.Builder(SampleDExecutor.class)
        .addConfiguration("config", "value")
        .build();

    runner.runInit();

    Record record = RecordCreator.create();
    Map<String, Field> fields = new HashMap<>();
    fields.put("first", Field.create("John"));
    fields.put("last", Field.create("Smith"));
    fields.put("someField", Field.create("some value"));
    record.set(Field.create(fields));


    runner.runWrite(Arrays.asList(record));

    // Here check the data destination. E.g. a mock.

    runner.runDestroy();
  }
}
