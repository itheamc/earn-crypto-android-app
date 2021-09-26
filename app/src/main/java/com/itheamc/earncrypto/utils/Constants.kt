package com.itheamc.earncrypto.utils

enum class MenuConstants(val label: String) {
    Theme(
        label = "Theme"
    ),
    DrawerGesture(
        label = "Drawer Gesture"
    ),
    Share(
        label = "Share"
    ),
    Rate(
        label = "Rate it"
    ),
    ReportBugs(
        label = "Report Bugs"
    ),
    PrivacyPolicy(
        label = "Privacy Policy"
    );
}

// Setting Keys
enum class StorageConstants() {
    THEME,
    LANGUAGE
}