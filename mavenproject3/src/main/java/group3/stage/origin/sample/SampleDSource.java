/*
 * Copyright (c) 2021 StreamSets Inc.
 */
package group3.stage.origin.sample;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ConfigGroups;
import com.streamsets.pipeline.api.ExecutionMode;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.StageDef;

@StageDef(
    version = 1,
    label = "Sample Origin",
    description = "",
    icon = "default.png",
    execution = ExecutionMode.STANDALONE,
    recordsByRef = true,
    onlineHelpRefUrl = ""
)
@ConfigGroups(value = Groups.class)
@GenerateResourceBundle
public class SampleDSource extends SampleSource {

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
