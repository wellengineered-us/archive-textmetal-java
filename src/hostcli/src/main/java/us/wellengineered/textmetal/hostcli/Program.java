/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.hostcli;

public class Program
{
	public static void main(String[] args) throws Exception
	{
		return TextMetalConsoleApplication.run(args);
		/*if (args == null)
			throw new ArgumentNullException("args");

		if (args.length != 1 || Utils.isNullOrEmptyString(args[0]))
		{
			System.out.println("USAGE: ... host-config-[file]-path");
			System.exit(-1);
			return;
		}

		final String path = args[0];

		// simply delegate to static bootstrapping method...
		bootstrapHost(path);*/
	}
}
