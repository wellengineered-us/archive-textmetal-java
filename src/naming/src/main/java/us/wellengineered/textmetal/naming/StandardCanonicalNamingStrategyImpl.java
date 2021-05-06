/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.naming;

import us.wellengineered.solder.polyfills.exceptions.ArgumentNullException;
import us.wellengineered.solder.polyfills.exceptions.NotImplementedException;

public class StandardCanonicalNamingStrategyImpl implements CanonicalNamingStrategy
{
	protected StandardCanonicalNamingStrategyImpl()
	{
		this(false);
	}

	protected StandardCanonicalNamingStrategyImpl(boolean disableNameMangling)
	{
		this.disableNameMangling = disableNameMangling;
	}

	private final boolean disableNameMangling;

	public boolean isDisableNameMangling()
	{
		return this.disableNameMangling;
	}

	public static StandardCanonicalNamingStrategyImpl getInstance()
	{
		return instance;
	}

	public static StandardCanonicalNamingStrategyImpl getInstanceDisableNameMangling()
	{
		return instanceDisableNameMangling;
	}

	private static final StandardCanonicalNamingStrategyImpl instance = new StandardCanonicalNamingStrategyImpl();
	private static final StandardCanonicalNamingStrategyImpl instanceDisableNameMangling = new StandardCanonicalNamingStrategyImpl(true);

	@Override
	public String getCamelCase(String value)
	{
		StringBuilder sb;
		char prev;
		int i = 0;
		boolean toupper = false;

		if (value == null)
			throw new ArgumentNullException("value");

		value = getValidJavaIdentifier(value);

		if (value.length() < 1)
			return value;

		sb = new StringBuilder();
		prev = value.charAt(0);

		for (char curr : value.toCharArray())
		{
			if (curr == '_')
			{
				toupper = true;

				if (this.isDisableNameMangling())
					sb.append(curr);

				continue; // ignore setting prev=curr
			}

			toupper = toupper || Character.isDigit(prev) || (Character.isLowerCase(prev) && Character.isUpperCase(curr));

			if (toupper)
				sb.append(Character.toUpperCase(curr));
			else
				sb.append(Character.toLowerCase(curr));

			prev = curr;
			i++;
			toupper = false;
		}

		return sb.toString();
	}

	@Override
	public String getConstantCase(String value)
	{
		StringBuilder sb;
		char prev;

		if (value == null)
			throw new ArgumentNullException("value");

		value = getValidJavaIdentifier(value);

		if (value.length() < 1)
			return value;

		sb = new StringBuilder();
		prev = value.charAt(0);

		for (char curr : value.toCharArray())
		{
			if (!this.isDisableNameMangling() && curr == '_')
				continue;

			if (Character.isLowerCase(prev) && Character.isUpperCase(curr))
				sb.append('_');

			sb.append(Character.isUpperCase(curr));
			prev = curr;
		}

		return sb.toString();
	}

	@Override
	public String getPascalCase(String value)
	{
		StringBuilder sb;

		if (value == null)
			throw new ArgumentNullException("value");

		value = getValidJavaIdentifier(value);

		if (value.length() < 1)
			return value;

		value = this.getCamelCase(value);
		sb = new StringBuilder(value);

		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

		return sb.toString();
	}

	@Override
	public String getPluralForm(String value)
	{
		StringBuilder sb;

		if (value == null)
			throw new ArgumentNullException("value");

		value = getValidJavaIdentifier(value);

		if (this.isDisableNameMangling())
			return value;

		if (value.length() < 1)
			return value;

		sb = new StringBuilder(value);

		if (value.endsWith("x") ||
				value.endsWith("ch") ||
				(value.endsWith("ss") ||
						value.endsWith("sh")))
			sb.append("es");
		else if (value.endsWith("y") && value.length() > 1 &&
				!isVowel(value.charAt(value.length() - 2)))
		{
			sb.deleteCharAt(value.length() - 1);
			sb.append("ies");
		}
		else if (!value.endsWith("s"))
			sb.append("s");

		return value;
	}

	@Override
	public String getSingularForm(String value)
	{
		StringBuilder sb;

		if (value == null)
			throw new ArgumentNullException("value");

		if (value == null)
			throw new ArgumentNullException("value");

		value = getValidJavaIdentifier(value);

		if (this.isDisableNameMangling())
			return value;

		if (value.length() < 1)
			return value;

		if (value.equalsIgnoreCase("series"))
			return value;

		if (value.equalsIgnoreCase("wines"))
			return "wine";

		sb = new StringBuilder(value);

		if (value.length() > 3 && value.endsWith("ies"))
		{
			if (!isVowel(value.charAt(value.length() - 4)))
			{
				sb.delete(value.length() - 3, value.length() - 1);
				sb.append("y");
			}
		}
		else if (value.endsWith("ees"))
			sb.deleteCharAt(value.length() - 1);
		else if (value.endsWith("ches") || value.endsWith("xes") || value.endsWith("sses"))
		{
			sb.delete(value.length() - 2, value.length() - 1);
		}
		else
		{
			if (value.equalsIgnoreCase("gas") ||
					value.length() <= 1 ||
					(!value.endsWith("s") || value.endsWith("ss")) || value.endsWith("us"))
				return value;

			sb.deleteCharAt(value.length() - 1);
		}

		return value;
	}

	private static String getValidJavaIdentifier(String value)
	{
		boolean first = true;
		StringBuilder sb;

		if (value == null)
			throw new ArgumentNullException("value");

		sb = new StringBuilder();

		for (char curr : value.toCharArray())
		{
			if (!(first && Character.isDigit(curr)) && (Character.isLetterOrDigit(curr) || curr == '_'))
				sb.append(curr);
			else if ((first && Character.isDigit(curr)) || curr == ' ')
				sb.append('_');
			else
			{
				// skip
			}

			first = false;
		}

		return sb.toString();
	}

	private static boolean isValidJavaIdentifier(String value)
	{
		throw new NotImplementedException();
	}

	private static boolean isVowel(char ch)
	{
		switch (ch)
		{
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'Y':
				return true;
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':
				return true;
			default:
				return false;
		}
	}
}
