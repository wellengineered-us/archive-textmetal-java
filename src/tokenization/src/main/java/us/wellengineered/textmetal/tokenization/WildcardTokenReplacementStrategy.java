/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.tokenization;

/**
 * Represents a token replacement strategy.
 */
public interface WildcardTokenReplacementStrategy
{
	/**
	 * Evaluate a token using any parameters specified.
	 * @param token The wildcard token to evaludate.
	 * @param parameters Should be null for value semantics; or a valid object array for function semantics.
	 * @return An approapriate token replacement value.
	 */
	Object evaluate(String token, Object[] parameters);
}
