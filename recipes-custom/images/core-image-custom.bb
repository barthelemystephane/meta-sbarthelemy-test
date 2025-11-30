SUMMARY = "A console-only image that fully supports the target device hardware."

REQUIRED_DISTRO_FEATURES = "ptest x11 opengl systemd"


IMAGE_FEATURES += "dev-pkgs"
IMAGE_FEATURES += "splash package-management x11-base ssh-server-dropbear hwcodecs"
#IMAGE_FEATURES += "x11-sato"

IMAGE_INSTALL:append = " infoip figlet"
IMAGE_INSTALL:append = " hello-rs print-rand-rs"
#IMAGE_INSTALL:append = " chromium-x11"


IMAGE_INSTALL:append = ""

LICENSE = "MIT"

inherit core-image features_check

TOOLCHAIN_HOST_TASK:append = " nativesdk-intltool nativesdk-glib-2.0-utils"
TOOLCHAIN_HOST_TASK:remove:task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0-utils"

PACKAGECONFIG:append:pn-chromium-x11 = " kiosk-mode"

VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"