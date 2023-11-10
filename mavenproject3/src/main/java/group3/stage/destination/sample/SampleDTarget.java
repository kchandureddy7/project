/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.destination.sample;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ConfigGroups;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.StageDef;

@StageDef(
    version = 1,
    label = "Sample Destination",
    description = "",
    icon = "default.png",
    recordsByRef = true,
    onlineHelpRefUrl = ""
)
@ConfigGroups(value = Groups.class)
@GenerateResourceBundle
public class SampleDTarget extends SampleTarget {

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      defaultValue = "default",
      label = "Sample Config",
      displayPosition = 10,
      group = "SAMPLE"
  )
  public String config;

  /** {@inheritDoc} */
  @Override
  public String getConfig() {
    return config;
  }

}
