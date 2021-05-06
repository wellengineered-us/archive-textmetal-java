/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.hosting.tool;

import us.wellengineered.textmetal.hosting.TextMetalHost;

import java.util.List;
import java.util.Map;

public interface TextMetalToolHost extends TextMetalHost
{
	void host(int argc, String[] argv, Map<String, Object> args, String templateFilePath, String sourceFilePath, String baseDirectoryPath,
			  String sourceStrategyAqtn, boolean strictMatching, Map<String, List<String>> properties);
}
