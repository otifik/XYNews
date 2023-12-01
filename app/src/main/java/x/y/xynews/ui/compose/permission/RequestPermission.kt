package x.y.xynews.ui.compose.permission

import android.Manifest
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import x.y.xynews.extension.shortToast
import x.y.xynews.ui.compose.dialog.XYNewsAlertDialog

@OptIn(ExperimentalPermissionsApi::class)
@Composable
public fun RequestPermission() {

    val context = LocalContext.current

    val notificationPermissionState = rememberPermissionState(
        Manifest.permission.POST_NOTIFICATIONS
    )

    val showDialog = remember {
        mutableStateOf(true)
    }

    if (notificationPermissionState.status.isGranted) {
        shortToast(context, "通知权限已授予")
    } else {
        when {
            showDialog.value -> {
                XYNewsAlertDialog(
                    onDismissRequest = {
                        showDialog.value = false
                        shortToast(context, "取消授权")
                    },
                    onConfirmation = {
                        showDialog.value = false
                        notificationPermissionState.launchPermissionRequest()
                    },
                    dialogTitle = "注意",
                    dialogText = if (notificationPermissionState.status.shouldShowRationale) {
                        // If the user has denied the permission but the rationale can be shown,
                        // then gently explain why the app requires this permission
                        "通知权限用于推送热点新闻，请授予"
                    } else {
                        // If it's the first time the user lands on this feature, or the user
                        // doesn't want to be asked again for this permission, explain that the
                        // permission is required
                        "使用本应用需要授予通知权限"
                    },
                    icon = Icons.Default.Info
                )
            }
        }
    }
}