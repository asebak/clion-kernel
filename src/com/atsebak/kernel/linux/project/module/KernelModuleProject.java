package com.atsebak.kernel.linux.project.module;


import com.atsebak.kernel.locale.KernelBundle;
import com.atsebak.kernel.utils.KernelIcons;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.wm.impl.welcomeScreen.NewWelcomeScreen;

public class KernelModuleProject extends AnAction {
    public void update(AnActionEvent event) {
        Presentation presentation = event.getPresentation();
        presentation.setText(KernelBundle.getString("linux.driver.projectname"));
        presentation.setDescription(KernelBundle.getString("linux.driver.description"));
        presentation.setIcon(KernelIcons.Linux);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        new KernelModuleWizard().runWizard();
    }
}