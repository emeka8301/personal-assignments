QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += c++11

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

SOURCES += \
    main.cpp \
    project362.cpp \
    qgraphicsaxisitem.cpp

HEADERS += \
    project362.h \
    qgraphicsaxisitem.h

FORMS += \
    project362.ui

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

win32:CONFIG(release, debug|release): LIBS += -L$$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/VC8/libgsl/Debug-DLL/' -llibgsl_dll_
else:win32:CONFIG(debug, debug|release): LIBS += -L$$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/VC8/libgsl/Debug-DLL/' -llibgsl_dll_d

INCLUDEPATH += $$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/'
DEPENDPATH += $$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/VC8/libgsl/Debug-DLL'

win32:CONFIG(release, debug|release): LIBS += -L$$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/VC8/libgslcblas/Debug-DLL/' -llibgslcblas_dll_
else:win32:CONFIG(debug, debug|release): LIBS += -L$$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/VC8/libgslcblas/Debug-DLL/' -llibgslcblas_dll_d

INCLUDEPATH += $$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/'
DEPENDPATH += $$PWD/'../../Downloads/windows-gsl-32 bit/windows-gsl-32 bit/src/gsl/1.8/gsl-1.8/VC8/libgslcblas/Debug-DLL'
