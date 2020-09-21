@echo off
REM 声明采用UTF-8编码
chcp 65001
set PROJECT_NAME=modeng_pig
set IMAGE_NAME=time-manager
set IMAGE_VERSION=1.0.0
set HARBOR_SERVER=registry.cn-hangzhou.aliyuncs.com


call docker login --username=18250792991 --password=wlj@123456 registry.cn-hangzhou.aliyuncs.com
call docker build -f Dockerfile -t %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME%:%IMAGE_VERSION% .
echo 开始推送inginging...
call docker push %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME%:%IMAGE_VERSION%

mshta vbscript:msgbox("脚本运行结束",64,"友情提示")(window.close)

pause