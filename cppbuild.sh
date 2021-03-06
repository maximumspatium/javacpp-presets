#!/bin/bash
# Scripts to build and install native C++ libraries
set -eu

[[ -z ${CMAKE:-} ]] && CMAKE=cmake

KERNEL=(`uname -s | tr [A-Z] [a-z]`)
ARCH=(`uname -m | tr [A-Z] [a-z]`)
case $KERNEL in
    darwin)
        OS=macosx
        ;;
    mingw32*)
        OS=windows
        KERNEL=windows
        ARCH=x86
        ;;
    mingw64*)
        OS=windows
        KERNEL=windows
        ARCH=x86_64
        ;;
    *)
        OS=$KERNEL
        ;;
esac
case $ARCH in
    arm*)
        ARCH=arm
        ;;
    i386|i486|i586|i686)
        ARCH=x86
        ;;
    amd64|x86-64)
        ARCH=x86_64
        ;;
esac
PLATFORM=$OS-$ARCH
echo "Detected platform \"$PLATFORM\""

while [[ $# > 0 ]]; do
    case "$1" in
        -platform)
            shift
            PLATFORM="$1"
            ;;
        install)
            OPERATION=install
            ;;
        clean)
            OPERATION=clean
            ;;
        *)
            PROJECTS+=("$1")
            ;;
    esac
    shift
done
echo "Targeting platform \"$PLATFORM\""

if [[ -z ${OPERATION:-} ]]; then
    echo "Usage: ANDROID_NDK=/path/to/android-ndk/ bash cppbuild.sh [-platform <name>] <install | clean> [projects]"
    echo "where possible platform names are: android-arm, android-x86, linux-x86, linux-x86_64, macosx-x86_64, windows-x86, windows-x86_64, etc."
    exit 1
fi

if [[ -z ${ANDROID_NDK:-} ]]; then
    ANDROID_NDK=~/Android/android-ndk/
fi
export ANDROID_NDK
export ANDROID_CPP="$ANDROID_NDK/sources/cxx-stl/gnu-libstdc++/4.9/"
case $PLATFORM in
    android-x86)
        export ANDROID_BIN="$ANDROID_NDK/toolchains/x86-4.9/prebuilt/$KERNEL-$ARCH/bin/i686-linux-android"
        export ANDROID_ROOT="$ANDROID_NDK/platforms/android-9/arch-x86/"
        ;;
    *)
        export ANDROID_BIN="$ANDROID_NDK/toolchains/arm-linux-androideabi-4.9/prebuilt/$KERNEL-$ARCH/bin/arm-linux-androideabi"
        export ANDROID_ROOT="$ANDROID_NDK/platforms/android-9/arch-arm/"
        ;;
esac

function download {
    if [[ ! -e $2 ]]; then
        echo "Downloading $1"
        curl -L $1 -o $2
    fi
}

if [[ -z ${PROJECTS:-} ]]; then
    PROJECTS=(opencv ffmpeg flycapture libdc1394 libfreenect videoinput artoolkitplus chilitags flandmark fftw gsl llvm leptonica tesseract caffe cuda)
fi

for PROJECT in ${PROJECTS[@]}; do
    case $OPERATION in
        install)
            if [[ ! -d $PROJECT ]]; then
                echo "Warning: Project \"$PROJECT\" not found"
            else
                echo "Installing \"$PROJECT\""
                mkdir -p $PROJECT/cppbuild
                pushd $PROJECT/cppbuild
                source ../cppbuild.sh
                popd
            fi
            ;;
        clean)
            echo "Cleaning \"$PROJECT\""
            rm -Rf $PROJECT/cppbuild
            ;;
    esac
done
