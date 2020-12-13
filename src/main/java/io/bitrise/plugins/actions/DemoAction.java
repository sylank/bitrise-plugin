package io.bitrise.plugins.actions;

import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class DemoAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        NotificationGroup noti = new NotificationGroup("", NotificationDisplayType.BALLOON, true);
        noti.createNotification("My Title", "My message2", NotificationType.INFORMATION, null).notify(e.getProject());
    }
}
