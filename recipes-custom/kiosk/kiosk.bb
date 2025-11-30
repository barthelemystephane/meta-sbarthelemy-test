SUMMARY = "Kiosk"

LICENSE = "CLOSED"

RDEPENDS_${PN} = "mini-x-session"

SRC_URI:append = " file://session"
FILES_${PN} += " ${sysconfdir}/mini_x/session"

do_install() {
    install -d ${D}${sysconfdir}/mini_x
    install -m 755 ${WORKDIR}/session ${D}${sysconfdir}/mini_x/session
}