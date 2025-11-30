SUMMARY = "display banner"
DESCRIPTION = "display ip at statup "
LICENSE = "MIT"

inherit systemd 

LICENSE = "CLOSED"

DEPENDS += "figlet"
RDEPENDS_${PN}  += "figlet"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = 	"file://infoip.sh \
		 file://infoip.service \
		"

S= "$WORKDIR"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = "infoip.service"

do_install () {

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/infoip.sh ${D}${bindir}

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/infoip.service ${D}${systemd_system_unitdir}
}

FILES:${PN} = " \
    ${bindir}/* \
    ${systemd_system_unitdir}/* \
"

