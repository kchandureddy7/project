/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.processor.sample;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ConfigGroups;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.StageDef;

@StageDef(
    version = 1,
    label = "Sample Processor",
    description = "",
    icon = "default.png",
    onlineHelpRefUrl = ""
)
@ConfigGroups(Groups.class)
@GenerateResourceBundle
public class SampleDProcessor extends SampleProcessor {

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
