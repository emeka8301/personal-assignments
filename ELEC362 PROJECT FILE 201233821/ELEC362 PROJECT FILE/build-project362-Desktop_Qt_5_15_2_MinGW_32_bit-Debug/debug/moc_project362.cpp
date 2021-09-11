/****************************************************************************
** Meta object code from reading C++ file 'project362.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.15.2)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include <memory>
#include "../../project362/project362.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'project362.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.15.2. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_project362_t {
    QByteArrayData data[13];
    char stringdata0[195];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_project362_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_project362_t qt_meta_stringdata_project362 = {
    {
QT_MOC_LITERAL(0, 0, 10), // "project362"
QT_MOC_LITERAL(1, 11, 19), // "customMenuRequested"
QT_MOC_LITERAL(2, 31, 0), // ""
QT_MOC_LITERAL(3, 32, 3), // "pos"
QT_MOC_LITERAL(4, 36, 11), // "resizeEvent"
QT_MOC_LITERAL(5, 48, 13), // "QResizeEvent*"
QT_MOC_LITERAL(6, 62, 1), // "e"
QT_MOC_LITERAL(7, 64, 22), // "on_Load_File_triggered"
QT_MOC_LITERAL(8, 87, 20), // "on_plotGraph_clicked"
QT_MOC_LITERAL(9, 108, 22), // "on_ChangeColor_clicked"
QT_MOC_LITERAL(10, 131, 19), // "on_Colour_triggered"
QT_MOC_LITERAL(11, 151, 20), // "on_thickness_clicked"
QT_MOC_LITERAL(12, 172, 22) // "on_Thickness_triggered"

    },
    "project362\0customMenuRequested\0\0pos\0"
    "resizeEvent\0QResizeEvent*\0e\0"
    "on_Load_File_triggered\0on_plotGraph_clicked\0"
    "on_ChangeColor_clicked\0on_Colour_triggered\0"
    "on_thickness_clicked\0on_Thickness_triggered"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_project362[] = {

 // content:
       8,       // revision
       0,       // classname
       0,    0, // classinfo
       8,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    1,   54,    2, 0x08 /* Private */,
       4,    1,   57,    2, 0x08 /* Private */,
       7,    0,   60,    2, 0x08 /* Private */,
       8,    0,   61,    2, 0x08 /* Private */,
       9,    0,   62,    2, 0x08 /* Private */,
      10,    0,   63,    2, 0x08 /* Private */,
      11,    0,   64,    2, 0x08 /* Private */,
      12,    0,   65,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void, QMetaType::QPoint,    3,
    QMetaType::Void, 0x80000000 | 5,    6,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,

       0        // eod
};

void project362::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        auto *_t = static_cast<project362 *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->customMenuRequested((*reinterpret_cast< QPoint(*)>(_a[1]))); break;
        case 1: _t->resizeEvent((*reinterpret_cast< QResizeEvent*(*)>(_a[1]))); break;
        case 2: _t->on_Load_File_triggered(); break;
        case 3: _t->on_plotGraph_clicked(); break;
        case 4: _t->on_ChangeColor_clicked(); break;
        case 5: _t->on_Colour_triggered(); break;
        case 6: _t->on_thickness_clicked(); break;
        case 7: _t->on_Thickness_triggered(); break;
        default: ;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject project362::staticMetaObject = { {
    QMetaObject::SuperData::link<QMainWindow::staticMetaObject>(),
    qt_meta_stringdata_project362.data,
    qt_meta_data_project362,
    qt_static_metacall,
    nullptr,
    nullptr
} };


const QMetaObject *project362::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *project362::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_project362.stringdata0))
        return static_cast<void*>(this);
    return QMainWindow::qt_metacast(_clname);
}

int project362::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 8)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 8;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 8)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 8;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
