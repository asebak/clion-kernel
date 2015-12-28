package com.atsebak.kernel.linux.project.module.ui;

import com.atsebak.kernel.linux.project.module.DriverLicenseType;
import com.atsebak.kernel.locale.KernelBundle;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.text.StringUtil;
import com.jetbrains.cidr.cpp.cmake.projectWizard.CMakeProjectStepAdapter;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeviceDriverForm extends CMakeProjectStepAdapter {
    private JPanel main;
    private JTextField author;
    private JComboBox license;
    private JCheckBox useHostKernelCheckBox;
    private LabeledComponent<TextFieldWithBrowseButton> kernelSourcePath;
    private JLabel kernelVersion;

    public DeviceDriverForm() {
        author.setText(System.getProperty("user.name"));
        license.addItem(new ComboItem(DriverLicenseType.GPL.name(), DriverLicenseType.GPL.name()));
        license.addItem(new ComboItem(DriverLicenseType.BSD.name(), DriverLicenseType.BSD.name()));
        license.addItem(new ComboItem(DriverLicenseType.DUAL.name(), DriverLicenseType.DUAL.name()));
        kernelVersion.setText(KernelBundle.getString("kernel.version") + " " + System.getProperty("os.version"));
        useHostKernelCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kernelSourcePath.setEnabled(!useHostKernelCheckBox.isSelected());
            }
        });

        TextFieldWithBrowseButton textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        textFieldWithBrowseButton.addBrowseFolderListener(KernelBundle.getString("choose.kernel.sources"), null, null,
                new FileChooserDescriptor(false, true, false, false, false, false));
        kernelSourcePath.setComponent(textFieldWithBrowseButton);
        kernelSourcePath.setEnabled(false);
        kernelSourcePath.getComponent().setText("/usr/src/linux-headers-" + System.getProperty("os.version"));
    }

    @Override
    public void dispose() {

    }

    @Override
    public JComponent getComponent() {
        return main;
    }

    @Override
    protected void init() {

    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return main;
    }

    @Nullable
    @Override
    public String validateWithMessage() {
        if(StringUtil.isEmptyOrSpaces(author.getText())) {
            return "Author is not valid";
        } else if (StringUtil.isEmptyOrSpaces(kernelSourcePath.getComponent().getText())) {
            return "Kernel source path is not valid";
        } else {
            return null;
        }
    }
}

