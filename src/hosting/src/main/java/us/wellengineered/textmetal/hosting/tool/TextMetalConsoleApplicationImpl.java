/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.hosting.tool;

import us.wellengineered.solder.executive.AbstractExecutableApplicationFascade;
import us.wellengineered.solder.executive.ExecutableArgument;
import us.wellengineered.solder.utilities.AppConfigFascade;
import us.wellengineered.solder.utilities.DataTypeFascade;
import us.wellengineered.solder.utilities.PackageInfoFascade;
import us.wellengineered.solder.utilities.ReflectionFascade;

import java.util.List;
import java.util.Map;

public class TextMetalConsoleApplicationImpl extends AbstractExecutableApplicationFascade
{
	@DependencyInjection
	public TextMetalConsoleApplicationImpl(@DependencyInjection DataTypeFascade dataTypeFascade,
										   @DependencyInjection AppConfigFascade appConfigFascade,
										   @DependencyInjection ReflectionFascade reflectionFascade,
										   @DependencyInjection PackageInfoFascade packageInformationFascade)
	{
		super(dataTypeFascade, appConfigFascade, reflectionFascade, packageInformationFascade);
	}

	@Override
	protected Map<String, ExecutableArgument<?>> getArgumentMap()
	{
		return null;
	}

	@Override
	protected int onStartup(String[] strings, Map<String, List<Object>> map)
	{
		return 0;
	}
}
