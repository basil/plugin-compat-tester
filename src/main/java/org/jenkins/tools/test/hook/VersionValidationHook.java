package org.jenkins.tools.test.hook;

import edu.umd.cs.findbugs.annotations.NonNull;
import org.apache.maven.model.Model;
import org.jenkins.tools.test.exception.PluginCompatibilityTesterException;
import org.jenkins.tools.test.exception.PluginSourcesUnavailableException;
import org.jenkins.tools.test.model.hook.BeforeCompilationContext;
import org.jenkins.tools.test.model.hook.PluginCompatTesterHookBeforeCompile;
import org.kohsuke.MetaInfServices;

@MetaInfServices(PluginCompatTesterHookBeforeCompile.class)
public class VersionValidationHook extends PluginCompatTesterHookBeforeCompile {
    @Override
    public void action(@NonNull BeforeCompilationContext context)
            throws PluginCompatibilityTesterException {
        Model model = context.getModel();
        if (model.getScm().getTag() == null || model.getScm().getTag().equals("HEAD")) {
            throw new PluginSourcesUnavailableException(
                    "Failed to check out plugin sources for " + model.getVersion());
        }
    }
}
