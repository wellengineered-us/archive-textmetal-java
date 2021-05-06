#
#	Copyright ©2002-2017 Daniel P. Bullington (dpbullington@gmail.com)
#	Distributed under the MIT license: http://www.opensource.org/licenses/mit-license.php
#

cls
$root = [System.Environment]::CurrentDirectory

$src_dir = "..\..\src"
$build_flavor_dir = "Debug"
$template_dir = "."
$source_dir = "."

$textmetal_exe = "$src_dir\TextMetal.ConsoleTool\bin\$build_flavor_dir\TextMetal.exe"

$template_file = "$template_dir\get_bat_copy_frags_template.xml"
$source_file = "$source_dir\get_bat_copy_frags_source.txt"
$base_dir = ".\output"
$source_strategy = "TextMetal.Framework.Source.Primative.TextSourceStrategy, TextMetal.Framework"
$strict = $true
$property_first_record_is_header = $false
$property_field_delimiter = "~"
$property_has_quoted_values = $false

echo "The operation is starting..."

if ((Test-Path -Path $base_dir))
{
	Remove-Item $base_dir -recurse
}

New-Item -ItemType directory -Path $base_dir

$argz = @("-templatefile:$template_file",
	"-sourcefile:$source_file",
	"-basedir:$base_dir",
	"-sourcestrategy:$source_strategy",
	"-strict:$strict",
	"-property:FirstRecordIsHeader=$property_first_record_is_header",
	"-property:FieldDelimiter=$property_field_delimiter",
	"-property:HasQuotedValues=$property_has_quoted_values",
	"-property:HeaderName=Field0001")

&"$textmetal_exe" $argz

if (!($LastExitCode -eq $null -or $LastExitCode -eq 0))
{ echo "An error occurred during the operation."; return; }

echo "The operation completed successfully."