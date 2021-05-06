@echo off

REM
REM	Copyright ©2002-2017 Daniel P. Bullington (dpbullington@gmail.com)
REM	Distributed under the MIT license: http://www.opensource.org/licenses/mit-license.php
REM

set SHOULD_CREATE_DB=true
set SQLCMD_EXE=C:\Program Files\Microsoft SQL Server\Client SDK\ODBC\130\Tools\Binn\sqlcmd.exe
set SQL_DIR=.

set DB_SERVER=(local)
set DB_DATABASE_MASTER=master
set DB_SA_USERNAME=sa
set DB_SA_PASSWORD=???

set DB_DATABASE=textmetal_sample
set DB_LOGIN=textmetal_sample_mssql_dev_login
set DB_PASSWORD=LrJGmP6UfW8TEp7x3wWhECUYULE6zzMcWQ03R6UxeB4xzVmnq5S4Lx0vApegZVH
set DB_USER=textmetal_sample_mssql_dev_user


CALL deploy_textmetal_db.bat
IF %ERRORLEVEL% NEQ 0 goto pkgError


goto pkgSuccess


:pkgError
echo An error occured.
pause > nul
goto :eof

:pkgSuccess
echo Completed successfully.
pause > nul
goto :eof
