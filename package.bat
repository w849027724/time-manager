@echo off
REM 声明采用UTF-8编码
chcp 65001
set PROJECT_NAME=time-manager
set IMAGE_NAME=time-manager-cms
set IMAGE_VERSION=1.0.0
set HARBOR_SERVER=124.70.40.151:9001


call docker login --username admin --password admin %HARBOR_SERVER%
call docker build -f Dockerfile -t %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME%:%IMAGE_VERSION% .
echo 开始推送inginging...
call docker push %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME%:%IMAGE_VERSION%

mshta vbscript:msgbox("脚本运行结束",64,"友情提示")(window.close)

pause