@echo off
REM 声明采用UTF-8编码
chcp 65001
set PROJECT_NAME=modeng_pig
set IMAGE_NAME=time-manager
set IMAGE_NAME_CMS=time-manager-cms
set IMAGE_NAME_GATEWAY=time-manager-gateway
set IMAGE_NAME_AUTH=time-manager-auth
set IMAGE_VERSION=1.0.0
set HARBOR_SERVER=registry.cn-hangzhou.aliyuncs.com

call docker login --username=18250792991 --password=wlj@123456 registry.cn-hangzhou.aliyuncs.com

call docker build -f time-manager-service/time-manager-cms/Dockerfile -t %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME_CMS%:%IMAGE_VERSION% .
echo 开始推送cms...
call docker push %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME_CMS%:%IMAGE_VERSION%

call docker build -f time-manager-gateway/Dockerfile -t %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME_GATEWAY%:%IMAGE_VERSION% .
echo 开始推送gateway...
call docker push %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME_GATEWAY%:%IMAGE_VERSION%

call docker build -f time-manager-auth/Dockerfile -t %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME_AUTH%:%IMAGE_VERSION% .
echo 开始推送auth...
call docker push %HARBOR_SERVER%/%PROJECT_NAME%/%IMAGE_NAME_AUTH%:%IMAGE_VERSION%


mshta vbscript:msgbox("脚本运行结束",64,"友情提示")(window.close)

pause