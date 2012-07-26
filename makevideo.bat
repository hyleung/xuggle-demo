del screencaps\*.* /Q
adb pull /storage/sdcard0/fsScreenCap screencaps
adb shell rm -r /storage/sdcard0/fsScreenCap
gradle clean build
