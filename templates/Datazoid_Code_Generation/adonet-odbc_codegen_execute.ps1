#
#	Copyright ©2002-2017 Daniel P. Bullington (dpbullington@gmail.com)
#	Distributed under the MIT license: http://www.opensource.org/licenses/mit-license.php
#

cls
$root = [System.Environment]::CurrentDirectory

$src_dir = "..\..\src"
$build_flavor_dir = "Debug"
$template_dir = "."

$robocopy_exe = "robocopy.exe"
$textmetal_exe = "$src_dir\TextMetal.ConsoleTool\bin\$build_flavor_dir\TextMetal.exe"

$template_file = "$template_dir\master_template.xml"
$source_file = "Driver={SQL Server Native Client 11.0};Server=(local);UID=textmetal_sample_mssql_lcl_login;PWD=LrJGmP6UfW8TEp7x3wWhECUYULE6zzMcWQ03R6UxeB4xzVmnq5S4Lx0vApegZVH;Database=textmetal_sample"
$base_dir = ".\output"
$source_strategy = "TextMetal.Framework.Source.DatabaseSchema.Odbc.OdbcSchemaSourceStrategy, TextMetal.Framework"
$strict = $true
$property_connection_type = "System.Data.Odbc.OdbcConnection, System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089"
$property_data_source_tag = "odbc.sqlserver"
$property_module_name = "TextMetal.Sample.DataModel"
$property_clr_namespace = "TextMetal.Sample.DataModel"
$property_table_model_clr_super_type = "TableModelObject"
$property_dynamic_table_model_clr_super_type = "DynamicTableModelObject"
$property_call_procedure_model_clr_super_type = "CallProcedureModelObject"
$property_result_procedure_model_clr_super_type = "ResultProcedureModelObject"
$property_dynamic_result_procedure_model_clr_super_type = "DynamicResultProcedureModelObject"
$property_return_procedure_model_clr_super_type = "ReturnProcedureModelObject"

$property_schema_filter = "^testcases"
$property_disable_name_mangling = $true

$lib_dir = "..\..\lib"

$base_src_dir = "$base_dir\src"
$base_lib_dir = "$base_dir\lib"

$sn_exe = "C:\Program Files (x86)\Microsoft SDKs\Windows\v8.1A\bin\NETFX 4.5.1 Tools\sn.exe"
$snk_file = "$base_src_dir\$property_module_name.snk"

echo "The operation is starting..."

if ((Test-Path -Path $base_dir))
{
	Remove-Item $base_dir -recurse -force
}

New-Item -ItemType directory -Path $base_dir

$argz = @("-templatefile:$template_file",
	"-sourcefile:$source_file",
	"-basedir:$base_src_dir",
	"-sourcestrategy:$source_strategy",
	"-strict:$strict",
	"-property:ConnectionType=$property_connection_type",
	"-property:DataSourceTag=$property_data_source_tag",
	"-property:ModuleName=$property_module_name",
	"-property:ClrNamespace=$property_clr_namespace",
	"-property:TableModelClrSuperType=$property_table_model_clr_super_type",
	"-property:DynamicTableModelClrSuperType=$property_dynamic_table_model_clr_super_type",
	"-property:CallProcedureModelClrSuperType=$property_call_procedure_model_clr_super_type",
	"-property:ResultProcedureModelClrSuperType=$property_result_procedure_model_clr_super_type",
	"-property:DynamicResultProcedureModelClrSuperType=$property_dynamic_result_procedure_model_clr_super_type",
	"-property:ReturnProcedureClrSuperType=$property_return_procedure_model_clr_super_type",
	"-property:DisableNameMangling=$property_disable_name_mangling")

&"$textmetal_exe" $argz

if (!($LastExitCode -eq $null -or $LastExitCode -eq 0))
{ echo "An error occurred during the operation."; return; }

$argz = @("-k",
	"$snk_file")

&"$sn_exe" $argz

if (!($LastExitCode -eq $null -or $LastExitCode -eq 0))
{ echo "An error occurred during the operation."; return; }

New-Item -ItemType directory -Path $base_lib_dir

$argz = @("$lib_dir",
	"$base_lib_dir",
	"/MIR",
	"/e",
	"/xd", "*!git*", "output",
	"/xf", "*!git*")

&"$robocopy_exe" $argz

if (!($LastExitCode -eq $null -or $LastExitCode -eq 1))
{ echo "An error occurred during the operation."; return; }

New-Item -ItemType directory -Path "$base_lib_dir\TextMetal"

Copy-Item "$src_dir\TextMetal.ConsoleTool\bin\$build_flavor_dir\TextMetal.exe" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.ConsoleTool\bin\$build_flavor_dir\TextMetal.exe.config" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.ConsoleTool\bin\$build_flavor_dir\TextMetal.xml" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.ConsoleTool\bin\$build_flavor_dir\TextMetal.pdb" "$base_lib_dir\TextMetal\."

Copy-Item "$src_dir\TextMetal.Framework\bin\$build_flavor_dir\TextMetal.Framework.dll" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.Framework\bin\$build_flavor_dir\TextMetal.Framework.xml" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.Framework\bin\$build_flavor_dir\TextMetal.Framework.pdb" "$base_lib_dir\TextMetal\."

Copy-Item "$src_dir\TextMetal.Middleware.Data\bin\$build_flavor_dir\TextMetal.Middleware.Data.dll" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.Middleware.Data\bin\$build_flavor_dir\TextMetal.Middleware.Data.xml" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.Middleware.Data\bin\$build_flavor_dir\TextMetal.Middleware.Data.pdb" "$base_lib_dir\TextMetal\."

Copy-Item "$src_dir\TextMetal.Middleware.Solder\bin\$build_flavor_dir\TextMetal.Middleware.Solder.dll" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.Middleware.Solder\bin\$build_flavor_dir\TextMetal.Middleware.Solder.xml" "$base_lib_dir\TextMetal\."
Copy-Item "$src_dir\TextMetal.Middleware.Solder\bin\$build_flavor_dir\TextMetal.Middleware.Solder.pdb" "$base_lib_dir\TextMetal\."

echo "The operation completed successfully."