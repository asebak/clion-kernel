package com.atsebak.kernel.linux.project.module;

import com.atsebak.kernel.linux.project.module.ui.DeviceDriverForm;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.jetbrains.cidr.cpp.cmake.projectWizard.CMakeProjectWizard;
import com.jetbrains.cidr.cpp.cmake.projectWizard.NewCMakeProjectStepAdapter;
import com.jetbrains.cidr.cpp.cmake.workspace.CMakeWorkspace;

public class KernelModuleWizard  extends CMakeProjectWizard {
    private NewCMakeProjectStepAdapter adapter = new NewCMakeProjectStepAdapter();
    private DeviceDriverForm driverForm = new DeviceDriverForm();

    public KernelModuleWizard() {
        super("New Kernel Module", "KernelModule");
        initWithStep(adapter);
        addStep(driverForm);
    }

    @Override
    protected boolean tryFinish() {
        return true;
    }

    @Override
    protected void doRunWizard() {

    }

    private void deleteBuildOutputDir(Project project) {
        FileUtil.delete(CMakeWorkspace.getInstance(project).getProjectGeneratedDir());
    }
}