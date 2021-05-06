/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * Provides custom optimized XML serializer/deserializer behavior.
 */
public interface XmlPersistEngine
{
	/**
	 * Clears all known XML object registrations.
	 */
	void clearAllKnownRegistrations();

	/**
	 * Deserialize an XML object graph from the specified XML file.
	 * @param clazz The target class.
	 * @param fileName The XML file to load.
	 * @param <TXmlObject> The target type for which to deserialize.
	 * @return An XML object graph.
	 */
	<TXmlObject extends XmlObject> TXmlObject deserializeFromXml(Class<? extends TXmlObject> clazz, String fileName);

	/**
	 * Deserialize an XML object graph from the specified stream.
	 * @param clazz The target class.
	 * @param inputStream The input stream to load.
	 * @param <TXmlObject> The target type for which to deserialize.
	 * @return An XML object graph.
	 */
	<TXmlObject extends XmlObject> TXmlObject deserializeFromXml(Class<? extends TXmlObject> clazz, InputStream inputStream);

	/**
	 * Deserialize an XML object graph from the specified XML reader.
	 * @param clazz The target class.
	 * @param xmlReader The XML reader to load.
	 * @param <TXmlObject> The target type for which to deserialize.
	 * @return An XML object graph.
	 */
	<TXmlObject extends XmlObject> TXmlObject deserializeFromXml(Class<? extends TXmlObject> clazz, Object xmlReader);

	/**
	 * Deserialize an XML object graph from the specified text reader.
	 * @param clazz The target class.
	 * @param inputReader The input reader to load.
	 * @param <TXmlObject> The target type for which to deserialize.
	 * @return An XML object graph.
	 */
	<TXmlObject extends XmlObject> TXmlObject deserializeFromXml(Class<? extends TXmlObject> clazz, Reader inputReader);

	/**
	 * Registers a known XML object by target type and explicit XML name (local name and namespace URI).
	 * @param clazz The target class.
	 * @param xmlName The explicit XML name.
	 * @param <TXmlObject> The target type to register.
	 */
	<TXmlObject extends XmlObject> void registerKnownXmlObject(Class<? extends TXmlObject> clazz, XmlName xmlName);

	/**
	 * Registers a known XML object by target type and implicit annotation-based XML name (local name and namespace URI).
	 * @param clazz The target class.
	 * @param <TXmlObject> The target type to register.
	 */
	<TXmlObject extends XmlObject> void registerKnownXmlObject(Class<? extends TXmlObject> clazz);

	/**
	 * Registers a known XML text object by target type.
	 * @param clazz The target class.
	 * @param <TXmlTextObject> The target type to register.
	 */
	<TXmlTextObject extends XmlTextObject> void registerKnownXmlTextObject(Class<? extends TXmlTextObject> clazz);

	/**
	 * Serializes an XML object graph to the specified XML file.
	 * @param fileName The output file name.
	 * @param clazz The target class.
	 * @param <TXmlObject> The target type for which to serialize.
	 */
	<TXmlObject extends XmlObject> void serializeToXml(String fileName, Class<? extends TXmlObject> clazz, TXmlObject obj);

	/**
	 * Serializes an XML object graph to the specified output stream.
	 * @param outputStream The output stream.
	 * @param clazz The target class.
	 * @param <TXmlObject> The target type for which to serialize.
	 */
	<TXmlObject extends XmlObject> void serializeToXml(OutputStream outputStream, Class<? extends TXmlObject> clazz, TXmlObject obj);

	/**
	 * Serializes an XML object graph to the specified XML writer.
	 * @param xmlWriter The XML writer.
	 * @param clazz The target class.
	 * @param <TXmlObject> The target type for which to serialize.
	 */
	<TXmlObject extends XmlObject> void serializeToXml(Object xmlWriter, Class<? extends TXmlObject> clazz, TXmlObject obj);

	/**
	 * Serializes an XML object graph to the output writer.
	 * @param outputWriter The output writer.
	 * @param clazz The target class.
	 * @param <TXmlObject> The target type for which to serialize.
	 */
	<TXmlObject extends XmlObject> void serializeToXml(Writer outputWriter, Class<? extends TXmlObject> clazz, TXmlObject obj);

	/**
	 * Unregisters a known XML object by target type.
	 * @param clazz The target class.
	 * @param <TXmlObject> The target type for which to unregister.
	 * @return A value indicating if the registration was present.
	 */
	<TXmlObject extends XmlObject> boolean unregisterKnownXmlObject(Class<? extends TXmlObject> clazz);

	/**
	 * Unregisters a known XML object by target type.
	 * @param clazz The target class.
	 * @param <TXmlTextObject> The target type for which to unregister.
	 * @return A value indicating if the registration was present.
	 */
	<TXmlTextObject extends XmlTextObject> boolean unregisterKnownXmlTextObject(Class<? extends TXmlTextObject> clazz);
}
