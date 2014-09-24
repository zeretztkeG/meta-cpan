DESCRIPTION = "Type::Tiny is a tiny class for creating Moose-like type constraint \
objects which are compatible with Moo, Moose and Mouse."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Type-Tiny"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://cpan.metacpan.org/authors/id/T/TO/TOBYINK/Type-Tiny-1.000004.tar.gz"

SRC_URI[md5sum] = "3fab2a0ec2634d1fa057d6254678b79f"
SRC_URI[sha256sum] = "d294b54b9177ad4fcbfd1ec868228dea7c4f49cd19a9b5dff763d61fcee144ba"
RDEPENDS_${PN} += "exporter-tiny-perl"
RRECOMMENDS_${PN} += "devel-lexalias-perl"
RRECOMMENDS_${PN} += "devel-stacktrace-perl"
RRECOMMENDS_${PN} += "sub-name-perl"
RRECOMMENDS_${PN} += "type-tie-perl"
RRECOMMENDS_${PN} += "type-tiny-xs-perl"
DEPENDS += "perl"
RECOMMENDS += "test-tester-perl-native"
RECOMMENDS += "test-warnings-perl-native"

S = "${WORKDIR}/Type-Tiny-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"