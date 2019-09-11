package org.jenkins.tools.test.hook;


import org.jenkins.tools.test.model.PomData;
import hudson.model.UpdateSite;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PipelineRestApiHook extends AbstractMultiParentHook {

    private static final Logger LOGGER = Logger.getLogger(PipelineRestApiHook.class.getName());

    @Override
    protected String getParentFolder() {
        return "pipeline-stage-view";
    }

    @Override
    protected String getParentUrl() {
        return "scm:git:git://github.com/jenkinsci/pipeline-stage-view-plugin.git";
    }

    @Override
    protected String getParentProjectName() {
        return "pipeline-stage-view";
    }

    @Override
    protected String getPluginFolderName(UpdateSite.Plugin currentPlugin){
        return "rest-api";
    }

    @Override
    public boolean check(Map<String, Object> info) throws Exception {
        return isPipelineStageViewPlugin(info);
    }

    public static boolean isPipelineStageViewPlugin(Map<String, Object> moreInfo) {
        PomData data = (PomData) moreInfo.get("pomData");
        return isPipelineStageViewPlugin(data);
    }

    public static boolean isPipelineStageViewPlugin(PomData data) {
        return data.artifactId.contains("pipeline-rest-api");
    }
}
