/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.destination.sample;

import com.streamsets.pipeline.api.Field;
import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.sdk.RecordCreator;
import com.streamsets.pipeline.sdk.TargetRunner;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestSampleTarget {
  @Test
  public void testWriteSingleRecord() throws Exception {
    TargetRunner runner = new TargetRunner.Builder(SampleDTarget.class)
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
